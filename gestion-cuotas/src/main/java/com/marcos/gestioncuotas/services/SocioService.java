package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.SocioDTO;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface SocioService {
    SocioDTO findSocioById(Long id);
    SocioDTO findSocioByNombre(String nombre);
    List<SocioDTO> findAllSocio();
    SocioDTO saveSocio(SocioDTO socioDTO);
    SocioDTO updateSocio(Long id, SocioDTO socioDTO);
    void deleteSocio(Long id);
}