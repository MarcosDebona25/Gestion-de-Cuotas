package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.TarifaDTO;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface TarifaService {
    List<TarifaDTO> getAllTarifas();
    TarifaDTO getTarifaById(Long id);
    TarifaDTO saveTarifa(TarifaDTO tarifa);
    TarifaDTO updateTarifa(Long id, TarifaDTO tarifa);
}