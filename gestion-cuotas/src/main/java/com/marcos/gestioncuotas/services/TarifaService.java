package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.TarifaDTO;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface TarifaService {
    List<TarifaDTO> findAllTarifas();
    TarifaDTO findTarifaById(Long id);
}