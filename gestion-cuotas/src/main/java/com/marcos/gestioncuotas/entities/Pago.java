package com.marcos.gestioncuotas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Marcos Debona
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Pago {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private LocalDate fechaPago;
    private double montoPagado;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToOne(mappedBy = "pago")
    private Cuota cuota;
}