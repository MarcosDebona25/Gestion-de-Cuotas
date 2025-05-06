package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.SocioDTO;
import com.marcos.gestioncuotas.entities.Socio;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper(componentModel = "spring")
public interface SocioMapper {
    Socio dtoToEntity(SocioDTO socioDTO);
    SocioDTO entityToDto(Socio socio);
}
