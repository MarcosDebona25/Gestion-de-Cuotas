package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class SocioNotFoundException extends RuntimeException {
    public SocioNotFoundException(String message) {
        super(message);
    }
}
