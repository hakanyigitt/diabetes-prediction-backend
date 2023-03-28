package com.zbeu.diabetesprediction.exception;

import lombok.Getter;

import java.time.LocalDate;

/**
 * @author HAKAN YIGIT
 */

@Getter
public final class ApiErrorResponse {

    private int statusCode;

    private String message;

    private LocalDate date;

    public ApiErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        date = LocalDate.now();
    }

}
