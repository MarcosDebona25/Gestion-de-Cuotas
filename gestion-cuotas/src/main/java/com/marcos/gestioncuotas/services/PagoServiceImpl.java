package com.marcos.gestioncuotas.services;

import com.marcos.gestioncuotas.dtos.PagoDTO;
import com.marcos.gestioncuotas.entities.Cuota;
import com.marcos.gestioncuotas.entities.EstadoCuota;
import com.marcos.gestioncuotas.entities.Pago;
import com.marcos.gestioncuotas.exceptions.CuotaNotFoundException;
import com.marcos.gestioncuotas.exceptions.PagoInvalidoException;
import com.marcos.gestioncuotas.exceptions.PagoNotFoundException;
import com.marcos.gestioncuotas.mappers.PagoMapper;
import com.marcos.gestioncuotas.repositories.CuotaRepository;
import com.marcos.gestioncuotas.repositories.PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marcos Debona
 */

@Service
public class PagoServiceImpl implements PagoService {
    private final PagoRepository pagoRepository;
    private final CuotaRepository cuotaRepository;
    private final PagoMapper pagoMapper;

    public PagoServiceImpl(PagoRepository pagoRepository, PagoMapper pagoMapper, CuotaRepository cuotaRepository) {
        this.pagoRepository = pagoRepository;
        this.pagoMapper = pagoMapper;
        this.cuotaRepository = cuotaRepository;
    }

    @Transactional
    @Override
    public PagoDTO savePago(PagoDTO pagoDTO) {
        Cuota cuotaArg = cuotaRepository.findById(pagoDTO.getCuotaId())
                .orElseThrow(() -> new CuotaNotFoundException("Cuota no encontrada con id: " + pagoDTO.getCuotaId()));

        if (!EstadoCuota.PENDIENTE.equals(cuotaArg.getEstado())) {
            throw new PagoInvalidoException("La cuota no está en estado PENDIENTE");
        }

        double montoEsperado = cuotaArg.calcularMontoCuota();
        if (pagoDTO.getMontoPagado() != montoEsperado) {
            throw new PagoInvalidoException("El monto pagado (" + pagoDTO.getMontoPagado() +
                    ") no coincide con el monto esperado (" + montoEsperado + ")");
        }

        Pago pagoEntity = pagoMapper.dtoToEntity(pagoDTO);
        pagoEntity.setCuota(cuotaArg);
        cuotaArg.setEstado(EstadoCuota.PAGADA);
        cuotaArg.setPago(pagoEntity);

        Pago savedPago = pagoRepository.save(pagoEntity);
        return pagoMapper.entityToDto(savedPago);
    }

    @Override
    public PagoDTO findPagoById(Long id){
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new PagoNotFoundException("Cuota no encontrada con id: " + id));
        return pagoMapper.entityToDto(pago);
    }

    @Override
    public List<PagoDTO> findAllPago() {
        return pagoRepository.findAll()
                .stream()
                .map(pagoMapper::entityToDto)
                .collect(Collectors.toList());
    }
}