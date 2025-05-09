package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.CuotaSocialDTO;
import com.marcos.gestioncuotas.entities.CuotaSocial;
import com.marcos.gestioncuotas.exceptions.CuotaSocialNotFoundException;
import com.marcos.gestioncuotas.mappers.CuotaSocialMapper;
import com.marcos.gestioncuotas.repositories.CuotaSocialRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Debona
 */

@Service
public class CuotaSocialServiceImpl implements CuotaSocialService {
    private final CuotaSocialRepository cuotaSocialRepository;
    private final CuotaSocialMapper cuotaSocialMapper;

    public CuotaSocialServiceImpl(CuotaSocialRepository cuotaSocialRepository, CuotaSocialMapper cuotaSocialMapper) {
        this.cuotaSocialRepository = cuotaSocialRepository;
        this.cuotaSocialMapper = cuotaSocialMapper;
    }

    @Override
    public CuotaSocialDTO findCuotaSocialActivo() {
        CuotaSocial response = cuotaSocialRepository.findCuotaSocialByActivoTrue();
        if (response == null) throw  new CuotaSocialNotFoundException("Cuota Social activa no encontrada");
        return cuotaSocialMapper.entityToDto(response);
    }

    @Override
    public List<CuotaSocialDTO> findAllCuotaSocial() {
        return cuotaSocialRepository.findAll()
                .stream()
                .map(cuotaSocialMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CuotaSocialDTO saveCuotaSocial(CuotaSocialDTO cuotaSocialDTO) {
        CuotaSocial entity = cuotaSocialMapper.dtoToEntity(cuotaSocialDTO);
        cuotaSocialRepository.desactivarCuotasSociales();
        entity.setActivo(true);

        CuotaSocial saved = cuotaSocialRepository.save(entity);
        return cuotaSocialMapper.entityToDto(saved);
    }

    @Transactional
    @Override
    public void deleteCuotaSocial(Long id) {
        CuotaSocial response = cuotaSocialRepository.findCuotaSocialByActivoTrue();
        if (response == null) throw  new CuotaSocialNotFoundException("Cuota Social activa no encontrada");
        response.setActivo(false);
        cuotaSocialRepository.save(response);
    }

}