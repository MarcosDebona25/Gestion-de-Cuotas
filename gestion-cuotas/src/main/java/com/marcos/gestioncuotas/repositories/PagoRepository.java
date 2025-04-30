package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
