package com.marcos.gestioncuotas.controllers;

import com.marcos.gestioncuotas.dtos.PagoDTO;
import com.marcos.gestioncuotas.services.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marcos.gestioncuotas.utils.ApiPaths.BASE_API;
import static com.marcos.gestioncuotas.utils.ApiPaths.PAGOS;

/**
 * @author Marcos Debona
 */

@RestController
@RequestMapping(BASE_API)
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping(PAGOS)
    public ResponseEntity<PagoDTO> createPago(@RequestBody PagoDTO pagoDTO) {
        PagoDTO savedPago = pagoService.savePago(pagoDTO);
        return new ResponseEntity<>(savedPago, HttpStatus.CREATED);
    }


    @GetMapping(PAGOS)
    public List<PagoDTO> getPago(){
        return pagoService.findAllPago();
    }

    @GetMapping(PAGOS + "/{id}")
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable Long id){
        PagoDTO pagoDTO = pagoService.findPagoById(id);
        return new ResponseEntity<>(pagoDTO, HttpStatus.OK);
    }
}