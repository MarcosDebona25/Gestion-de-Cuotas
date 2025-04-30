package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.TarifaDTO;
import com.marcos.gestioncuotas.entities.Tarifa;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper
public interface TarifaMapper {
    Tarifa dtoToEntity(TarifaDTO tarifaDTO);
    TarifaDTO entityToDto(Tarifa tarifa);
}
