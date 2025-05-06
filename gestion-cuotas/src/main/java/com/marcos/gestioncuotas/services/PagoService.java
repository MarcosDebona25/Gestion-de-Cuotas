package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.PagoDTO;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface PagoService {
    PagoDTO savePago(PagoDTO pagoDTO);
    PagoDTO findPagoById(Long id);
    List<PagoDTO> findAllPago();
}