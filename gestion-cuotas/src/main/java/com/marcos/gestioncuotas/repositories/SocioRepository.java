package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
