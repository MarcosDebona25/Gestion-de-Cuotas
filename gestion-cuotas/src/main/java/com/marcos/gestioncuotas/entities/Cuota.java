package com.marcos.gestioncuotas.entities;

import jakarta.persistence.*;
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
@ToString
@Entity
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoCuota estado;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "cuota_social_id")
    private CuotaSocial cuotaSocial;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @ManyToMany()
    @JoinTable( name = "cuota_disciplina",
                joinColumns = @JoinColumn(name = "fk_cuota"),
                inverseJoinColumns = @JoinColumn(name = "fk_disciplina"))
    private List<Disciplina> listaDisciplinas;
}