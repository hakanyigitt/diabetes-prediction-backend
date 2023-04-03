package com.zbeu.diabetesprediction.services.impl;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.configuration.security.JwtTokenProvider;
import com.zbeu.diabetesprediction.dto.request.LoginRequest;
import com.zbeu.diabetesprediction.dto.request.SignUpRequest;
import com.zbeu.diabetesprediction.dto.response.LoginResponse;
import com.zbeu.diabetesprediction.model.entity.Role;
import com.zbeu.diabetesprediction.model.entity.User;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.repos.RoleRepository;
import com.zbeu.diabetesprediction.repos.UserRepository;
import com.zbeu.diabetesprediction.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HAKAN YIGIT
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        final String username = loginRequest.getUsername();
        final String password = loginRequest.getPassword();
        try {
            final User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            final String token = jwtTokenProvider.createToken(username, user.getRole());
            return new LoginResponse(token);
        } catch (AuthenticationException authenticationException) {
            throw new CustomException(ExceptionMessages.INVALID_USERNAME_OR_PASSWORD_SUPPLIED, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) {
        final String username = signUpRequest.getUsername();
        final String password = signUpRequest.getPassword();
        final String role = signUpRequest.getRole();
        final String email = signUpRequest.getEmail();
        final String firstName = signUpRequest.getFirstName();
        final String lastName = signUpRequest.getLastName();

        final var roleEntity = findRoleByRoleName(role);

        User user = new User();
        user.setUsername(username);
        user.setPassword(encodePassword(password));
        user.setRole(roleEntity);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean existsUserByUsername(String username) {
        return !userRepository.existsUserByUsername(username);
    }

    @Override
    @Transactional
    public boolean existsUserByEmail(String email) {
        return !userRepository.existsUserByEmail(email);
    }

    private Role findRoleByRoleName(String role){
        return roleRepository.findByName(role)
                .orElseThrow(() -> new CustomException(ExceptionMessages.ROLE_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}


