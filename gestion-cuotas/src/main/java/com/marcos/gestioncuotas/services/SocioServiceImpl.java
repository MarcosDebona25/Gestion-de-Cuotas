package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.SocioDTO;
import com.marcos.gestioncuotas.entities.Socio;
import com.marcos.gestioncuotas.exceptions.SocioAlreadyExistsException;
import com.marcos.gestioncuotas.exceptions.SocioNotActiveException;
import com.marcos.gestioncuotas.exceptions.SocioNotFoundException;
import com.marcos.gestioncuotas.mappers.SocioMapper;
import com.marcos.gestioncuotas.repositories.SocioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Debona
 */

@Service
public class SocioServiceImpl implements SocioService {
    private final SocioRepository socioRepository;
    private final SocioMapper socioMapper;

    public SocioServiceImpl(SocioRepository socioRepository, SocioMapper socioMapper) {
        this.socioRepository = socioRepository;
        this.socioMapper = socioMapper;
    }

    @Override
    public SocioDTO findSocioById(Long id) {
        Socio socioFound = socioRepository.findById(id)
                .orElseThrow(() -> new SocioNotFoundException("Socio no encontrado con id: " + id));
        return socioMapper.entityToDto(socioFound);
    }

    @Override
    public SocioDTO findSocioByNombre(String nombre) {
        Socio socioFound = socioRepository.findSocioByNombreLikeIgnoreCase(nombre);
        if (socioFound == null) throw new SocioNotFoundException("Socio no encontrado con id: " + nombre);
        return socioMapper.entityToDto(socioFound);
    }

    @Override
    public List<SocioDTO> findAllSocio() {
        return socioRepository.findAll()
                .stream()
                .map(socioMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SocioDTO saveSocio(SocioDTO socioDTO) {

        if (socioRepository.findSocioByDni(socioDTO.getDni()) != null) {
            throw new SocioAlreadyExistsException("El socio ya existe");
        }

        Socio entity = socioMapper.dtoToEntity(socioDTO);
        entity.setActivo(true);
        entity.setListaCuotas(new ArrayList<>());

        Socio saved = socioRepository.save(entity);
        return socioMapper.entityToDto(saved);
    }

    @Transactional
    @Override
    public SocioDTO updateSocio(Long id, SocioDTO socioDTO) {
        Socio entity = socioRepository.findById(id)
                .orElseThrow(() -> new SocioNotFoundException("Socio no encontrado con id: " + id));

        if (!entity.isActivo()) throw new SocioNotActiveException("El socio no está activo");
        entity.setDni(socioDTO.getDni());
        entity.setNombre(socioDTO.getNombre());
        entity.setApellido(socioDTO.getApellido());
        entity.setEmail(socioDTO.getEmail());
        entity.setTelefono(socioDTO.getTelefono());
        entity.setFechaAlta(socioDTO.getFechaAlta());

        Socio updated = socioRepository.save(entity);
        return socioMapper.entityToDto(updated);
    }

    @Override
    public void deleteSocio(Long id) {
        Socio entity = socioRepository.findById(id)
                .orElseThrow(() -> new SocioNotFoundException("Socio no encontrado con id: " + id));
        if (!entity.isActivo()) throw new SocioNotActiveException("El socio no está activo");
        entity.setActivo(false);
    }

}