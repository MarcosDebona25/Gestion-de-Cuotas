package com.marcos.gestioncuotas.exceptions;

/**
 * @author Marcos Debona
 */

public class TarifaNotFoundException extends RuntimeException {
    public TarifaNotFoundException(String message) {
        super(message);
    }
}