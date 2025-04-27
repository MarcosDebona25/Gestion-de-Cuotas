package com.marcos.gestioncuotas.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marcos Debona
 */

public class Socio {
    private Long dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaAlta;
    private boolean activo;

    private List<Cuota> listaCuotas;
}