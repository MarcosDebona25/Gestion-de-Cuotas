package com.marcos.gestioncuotas.entity;

import java.time.LocalDate;

/**
 * @author Marcos Debona
 */

public class Pago {
    private Long id;
    private LocalDate fechaPago;
    private double montoPagado;

    private MetodoPago metodoPago;
    private Cuota cuota;
}