package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class SocioNotActiveException extends RuntimeException {
    public SocioNotActiveException(String message) {
        super(message);
    }
}
