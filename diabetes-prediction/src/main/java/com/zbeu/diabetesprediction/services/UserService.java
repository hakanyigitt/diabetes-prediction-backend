package com.zbeu.diabetesprediction.services;

import com.zbeu.diabetesprediction.dto.request.LoginRequest;
import com.zbeu.diabetesprediction.dto.request.SignUpRequest;
import com.zbeu.diabetesprediction.dto.response.LoginResponse;

/**
 * @author HAKAN YIGIT
 */

public interface UserService {

    LoginResponse login(LoginRequest loginRequest);

    void signUp(SignUpRequest signUpRequest);

    boolean existsUserByUsername(String username);

    boolean existsUserByEmail(String email);

}
