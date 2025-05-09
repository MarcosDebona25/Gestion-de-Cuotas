package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class SocioAlreadyExistsException extends RuntimeException {
    public SocioAlreadyExistsException(String message) {
        super(message);
    }
}
