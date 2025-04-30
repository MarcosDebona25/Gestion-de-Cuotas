package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.DisciplinaDTO;
import com.marcos.gestioncuotas.entities.Disciplina;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper
public interface DisciplinaMapper {
    Disciplina dtoToEntity(DisciplinaDTO disciplinaDTO);
    DisciplinaDTO entityToDto(Disciplina disciplina);
}
