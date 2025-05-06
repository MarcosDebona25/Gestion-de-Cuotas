package com.marcos.gestioncuotas.utils;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author Marcos Debona
 */

@Getter
@Setter
public class ApiError {
    private int status;
    private String error;
    private LocalDateTime timestamp;

    public ApiError(HttpStatus status, String error) {
        this.status = status.value();
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}