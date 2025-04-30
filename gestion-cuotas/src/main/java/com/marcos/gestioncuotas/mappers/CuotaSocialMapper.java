package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.CuotaSocialDTO;
import com.marcos.gestioncuotas.entities.CuotaSocial;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper
public interface CuotaSocialMapper {
    CuotaSocial dtoToEntity(CuotaSocialDTO cuotaSocialDTO);
    CuotaSocialDTO entityToDto(CuotaSocial cuotaSocial);
}
