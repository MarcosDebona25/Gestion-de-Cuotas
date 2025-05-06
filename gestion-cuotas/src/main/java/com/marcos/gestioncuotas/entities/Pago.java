package com.marcos.gestioncuotas.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPago;

    private double montoPagado;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToOne
    @JoinColumn(name = "cuota_id")
    private Cuota cuota;
}