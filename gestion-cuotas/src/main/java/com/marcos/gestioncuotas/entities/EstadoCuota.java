package com.marcos.gestioncuotas.entities;

import lombok.ToString;

/**
 * @author Marcos Debona
 */

@ToString
public enum EstadoCuota {
    PENDIENTE,
    PAGADA,
    VENCIDA;
}