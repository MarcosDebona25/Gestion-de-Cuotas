package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.CuotaSocialDTO;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface CuotaSocialService {
    CuotaSocialDTO findCuotaSocialActivo();
    List<CuotaSocialDTO> findAllCuotaSocial();
    CuotaSocialDTO saveCuotaSocial(CuotaSocialDTO cuotaSocialDTO);
    void deleteCuotaSocial(Long id);
}