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
public class Tarifa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private double monto;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
}