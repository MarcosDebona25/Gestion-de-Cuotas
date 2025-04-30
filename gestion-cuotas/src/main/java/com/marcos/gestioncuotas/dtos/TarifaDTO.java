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
public class TarifaDTO {
    private Long id;
    private String descripcion;
    private double monto;
    private DisciplinaDTO disciplina;
}