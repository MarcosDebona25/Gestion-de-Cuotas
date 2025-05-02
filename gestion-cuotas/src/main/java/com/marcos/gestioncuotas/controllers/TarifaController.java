package com.marcos.gestioncuotas.controllers;

import com.marcos.gestioncuotas.dtos.TarifaDTO;
import com.marcos.gestioncuotas.services.TarifaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.marcos.gestioncuotas.utils.ApiPaths.*;

/**
 * @author Marcos Debona
 */

@RestController
@RequestMapping(BASE_API)
public class TarifaController {
    private final TarifaService tarifaService;

    public TarifaController(TarifaService tarifaService) {
        this.tarifaService = tarifaService;
    }

    @GetMapping(TARIFAS)
    public List<TarifaDTO> getAllTarifa() {
        return tarifaService.findAllTarifas();
    }

    @GetMapping(TARIFAS + "/{id}")
    public ResponseEntity<TarifaDTO> getTarifaById(@PathVariable Long id) {
        TarifaDTO tarifaFound = tarifaService.findTarifaById(id);
        return new ResponseEntity<>(tarifaFound, HttpStatus.OK);
    }
}