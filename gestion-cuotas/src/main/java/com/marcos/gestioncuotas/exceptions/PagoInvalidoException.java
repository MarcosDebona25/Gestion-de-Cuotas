package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class PagoInvalidoException extends RuntimeException {
    public PagoInvalidoException(String message) {
        super(message);
    }
}