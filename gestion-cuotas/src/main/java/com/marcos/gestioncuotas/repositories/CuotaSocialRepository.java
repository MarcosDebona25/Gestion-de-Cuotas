package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.CuotaSocial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface CuotaSocialRepository extends JpaRepository<CuotaSocial, Long> {
}