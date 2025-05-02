package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.DisciplinaDTO;
import com.marcos.gestioncuotas.dtos.TarifaDTO;

import java.util.List;

/**
 * @author Marcos Debona
 */

public interface DisciplinaService {
    List<DisciplinaDTO> findAllDisciplina();
    DisciplinaDTO findDisciplinaById(Long id);
    DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO);
    DisciplinaDTO updateDisciplina(Long id, DisciplinaDTO disciplinaDTO);
    void deleteDisciplina(Long id);
    void addTarifaToDisciplina(Long disciplinaId, TarifaDTO tarifaDTO);
    List<TarifaDTO> getTarifaHistoryByDisciplinaId(Long id);
}
