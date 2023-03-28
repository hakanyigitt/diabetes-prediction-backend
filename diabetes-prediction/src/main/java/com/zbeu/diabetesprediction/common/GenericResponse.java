package com.zbeu.diabetesprediction.common;

import lombok.Getter;

import java.time.LocalDate;

/**
 * @author HAKAN YIGIT
 */
@Getter
public final class GenericResponse {

    private String message;

    private LocalDate date;

    public GenericResponse(String message) {
        this.message = message;
        date = LocalDate.now();
    }

}
