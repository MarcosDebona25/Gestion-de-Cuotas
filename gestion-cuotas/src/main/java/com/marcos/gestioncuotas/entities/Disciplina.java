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
public class Disciplina {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;

}