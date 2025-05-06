package com.marcos.gestioncuotas.dtos;

import com.marcos.gestioncuotas.entities.MetodoPago;
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
public class PagoDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPago;

    private double montoPagado;
    private MetodoPago metodoPago;
    private Long cuotaId;
}