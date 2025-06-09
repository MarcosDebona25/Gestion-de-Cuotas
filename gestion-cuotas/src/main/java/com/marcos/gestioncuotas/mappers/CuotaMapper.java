package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.CuotaDTO;
import com.marcos.gestioncuotas.entities.Cuota;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper(componentModel = "spring")
public interface CuotaMapper {
    Cuota dtoToEntity (CuotaDTO cuotaDTO);
    CuotaDTO entityToDto (Cuota cuota);
}
