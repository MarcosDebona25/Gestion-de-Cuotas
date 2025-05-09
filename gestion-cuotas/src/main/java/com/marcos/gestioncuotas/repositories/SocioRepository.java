package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface SocioRepository extends JpaRepository<Socio, Long> {
    Socio findSocioByNombreLikeIgnoreCase(String nombre);

    List<Socio> findSocioByDni(String dni);
}
