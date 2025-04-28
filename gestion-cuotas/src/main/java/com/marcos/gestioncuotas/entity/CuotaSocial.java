package com.marcos.gestioncuotas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CuotaSocial {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private double monto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
}