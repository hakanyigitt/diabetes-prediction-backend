package com.zbeu.diabetesprediction.configuration.security;

import com.zbeu.diabetesprediction.common.constant.ExceptionMessages;
import com.zbeu.diabetesprediction.exception.CustomException;
import com.zbeu.diabetesprediction.repos.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author HAKAN YIGIT
 */
@Service
@RequiredArgsConstructor
class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomException(ExceptionMessages.USER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }
}
