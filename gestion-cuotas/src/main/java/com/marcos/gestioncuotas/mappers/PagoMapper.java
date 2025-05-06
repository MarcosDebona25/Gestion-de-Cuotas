package com.marcos.gestioncuotas.mappers;

import com.marcos.gestioncuotas.dtos.PagoDTO;
import com.marcos.gestioncuotas.entities.Pago;
import org.mapstruct.Mapper;

/**
 * @author Marcos Debona
 */

@Mapper(componentModel = "spring")
public interface PagoMapper {
    Pago dtoToEntity(PagoDTO pagoDTO);
    PagoDTO entityToDto(Pago pago);
}
