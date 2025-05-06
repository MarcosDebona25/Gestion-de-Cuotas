package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class PagoNotFoundException extends RuntimeException {
    public PagoNotFoundException(String message) {
        super(message);
    }
}