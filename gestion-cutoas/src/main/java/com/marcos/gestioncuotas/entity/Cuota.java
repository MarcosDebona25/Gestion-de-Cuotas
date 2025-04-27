package com.marcos.gestioncuotas.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marcos Debona
 */

public class Cuota {
    private Long id;
    private LocalDate fecha;
    private EstadoCuota estado;

    private Socio socio;
    private CuotaSocial cuotaSocial;
    private Pago pago;
    private List<Disciplina> disciplina;
}