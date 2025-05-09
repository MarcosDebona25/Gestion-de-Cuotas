package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.CuotaSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Marcos Debona
 */

public interface CuotaSocialRepository extends JpaRepository<CuotaSocial, Long> {
    CuotaSocial findCuotaSocialByActivoTrue();

    @Modifying
    @Query("UPDATE CuotaSocial c SET c.activo = false WHERE c.activo = true")
    void desactivarCuotasSociales();
}