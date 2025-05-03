package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}