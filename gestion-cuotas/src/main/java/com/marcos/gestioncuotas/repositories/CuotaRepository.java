package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface CuotaRepository extends JpaRepository<Cuota, Long> {
}
