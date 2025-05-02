package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class DisciplinaNotFoundException extends RuntimeException {
    public DisciplinaNotFoundException(String message) {
        super(message);
    }
}