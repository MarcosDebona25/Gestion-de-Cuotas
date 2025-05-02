package com.marcos.gestioncuotas.dtos;

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
public class TarifaDTO {
    private double monto;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
}