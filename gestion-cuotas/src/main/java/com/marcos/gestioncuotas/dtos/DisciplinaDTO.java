package com.marcos.gestioncuotas.dtos;

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
public class DisciplinaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private TarifaDTO tarifa;
}