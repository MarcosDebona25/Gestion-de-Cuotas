package com.marcos.gestioncuotas.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private String descripcion;
    private double monto;

    @OneToOne(mappedBy = "tarifa")
    private Disciplina disciplina;
}