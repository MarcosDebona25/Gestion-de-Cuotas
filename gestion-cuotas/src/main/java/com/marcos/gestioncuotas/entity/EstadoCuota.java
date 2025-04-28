package com.marcos.gestioncuotas.entity;

import jakarta.persistence.Enumerated;

/**
 * @author Marcos Debona
 */

public enum EstadoCuota {
    PENDIENTE,
    PAGADA,
    VENCIDA;
}