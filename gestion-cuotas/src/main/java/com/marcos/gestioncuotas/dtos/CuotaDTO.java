package com.marcos.gestioncuotas.dtos;

import com.marcos.gestioncuotas.entities.EstadoCuota;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
public class CuotaDTO {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    private EstadoCuota estado;
    private SocioDTO socio;
    private CuotaSocialDTO cuotaSocial;
    private PagoDTO pago;
    private List<DisciplinaDTO> listaDisciplinas;
}