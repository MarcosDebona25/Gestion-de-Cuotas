package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class CuotaNotFoundException extends RuntimeException {
    public CuotaNotFoundException(String message) {
        super(message);
    }
}