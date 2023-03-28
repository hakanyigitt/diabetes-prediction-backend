package com.zbeu.diabetesprediction.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author HAKAN YIGIT
 */

@RequiredArgsConstructor
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    @Getter
    private final HttpStatus httpStatus;

    @Override
    public String getMessage(){
        return message;
    }

}
