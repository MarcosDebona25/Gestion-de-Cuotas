package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.DisciplinaDTO;
import com.marcos.gestioncuotas.entities.Disciplina;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Marcos Debona
 */

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {
    Disciplina dtoToEntity(DisciplinaDTO disciplinaDTO);
    DisciplinaDTO entityToDto(Disciplina disciplina);
}