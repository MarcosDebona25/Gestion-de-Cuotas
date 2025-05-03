package com.marcos.gestioncuotas.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    private List<Tarifa> listaTarifas;
}