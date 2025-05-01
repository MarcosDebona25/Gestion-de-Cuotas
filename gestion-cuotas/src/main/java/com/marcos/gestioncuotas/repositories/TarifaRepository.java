package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}