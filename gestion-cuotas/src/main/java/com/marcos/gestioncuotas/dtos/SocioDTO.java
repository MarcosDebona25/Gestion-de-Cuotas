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
public class SocioDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;
}