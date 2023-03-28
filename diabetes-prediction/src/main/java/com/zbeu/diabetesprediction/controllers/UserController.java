package com.zbeu.diabetesprediction.controllers;

import com.zbeu.diabetesprediction.common.GenericResponse;
import com.zbeu.diabetesprediction.common.annotation.ApiController;
import com.zbeu.diabetesprediction.common.constant.GenericMessages;
import com.zbeu.diabetesprediction.common.constant.SwaggerMessages;
import com.zbeu.diabetesprediction.dto.request.LoginRequest;
import com.zbeu.diabetesprediction.dto.request.SignUpRequest;
import com.zbeu.diabetesprediction.dto.response.LoginResponse;
import com.zbeu.diabetesprediction.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author HAKAN YIGIT
 */

@ApiController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_LOGIN),
            @ApiResponse(code = 400, message = SwaggerMessages.UNSUCCESSFUL_LOGIN),
            @ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN),
    })
    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@ApiParam(value = "Login Request", required = true)
                                               @Valid @RequestBody LoginRequest loginRequest) {
        final LoginResponse loginResponse = userService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @ApiOperation(value = "Sign-up")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerMessages.SUCCESSFUL_SIGNUP),
            @ApiResponse(code = 400, message = SwaggerMessages.UNSUCCESSFUL_SIGNUP),
            @ApiResponse(code = 403, message = SwaggerMessages.FORBIDDEN),
    })
    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@ApiParam(value = "Sign up Request", required = true)
                                    @Valid @RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
        return ResponseEntity.ok(new GenericResponse(GenericMessages.SUCCESSFULLY_CREATED));
    }

}
