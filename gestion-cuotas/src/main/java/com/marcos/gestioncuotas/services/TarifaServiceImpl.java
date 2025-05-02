package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.TarifaDTO;
import com.marcos.gestioncuotas.entities.Tarifa;
import com.marcos.gestioncuotas.exceptions.TarifaNotFoundException;
import com.marcos.gestioncuotas.mappers.TarifaMapper;
import com.marcos.gestioncuotas.repositories.TarifaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Debona
 */

@Service
public class TarifaServiceImpl implements TarifaService {
    private final TarifaRepository tarifaRepository;
    private final TarifaMapper tarifaMapper;

    public TarifaServiceImpl(TarifaRepository tarifaRepository, TarifaMapper tarifaMapper) {
        this.tarifaRepository = tarifaRepository;
        this.tarifaMapper = tarifaMapper;
    }

    @Override
    public List<TarifaDTO> findAllTarifas() {
        return tarifaRepository.findAll()
                .stream()
                .map(tarifaMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TarifaDTO findTarifaById(Long id) {
        Tarifa tarifa = tarifaRepository.findById(id)
                        .orElseThrow(() -> new TarifaNotFoundException("Tarifa no encontrada con id: " + id));
        return tarifaMapper.entityToDto(tarifa);
    }
}