package com.marcos.gestioncuotas.controllers;

import com.marcos.gestioncuotas.dtos.CuotaSocialDTO;
import com.marcos.gestioncuotas.mappers.CuotaSocialMapper;
import com.marcos.gestioncuotas.services.CuotaSocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marcos.gestioncuotas.utils.ApiPaths.BASE_API;
import static com.marcos.gestioncuotas.utils.ApiPaths.CUOTA_SOCIAL;

/**
 * @author Marcos Debona
 */

@RestController
@RequestMapping(BASE_API)
public class CuotaSocialController {
    private final CuotaSocialService cuotaSocialService;
    private final CuotaSocialMapper cuotaSocialMapper;

    public CuotaSocialController(CuotaSocialService cuotaSocialService, CuotaSocialMapper cuotaSocialMapper) {
        this.cuotaSocialService = cuotaSocialService;
        this.cuotaSocialMapper = cuotaSocialMapper;
    }

    @GetMapping(CUOTA_SOCIAL + "/{activa}")
    public ResponseEntity<CuotaSocialDTO> getCuotaSocialActiva(){
        CuotaSocialDTO response = cuotaSocialService.findCuotaSocialActivo();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(CUOTA_SOCIAL)
    public List<CuotaSocialDTO> getAllCuotaSocial(){
        return this.cuotaSocialService.findAllCuotaSocial();
    }

    @PostMapping(CUOTA_SOCIAL)
    public ResponseEntity<CuotaSocialDTO> createCuotaSocial(@RequestBody CuotaSocialDTO cuotaSocialDTO){
        CuotaSocialDTO savedCuotaSocial = this.cuotaSocialService.saveCuotaSocial(cuotaSocialDTO);
        return new ResponseEntity<>(savedCuotaSocial, HttpStatus.CREATED);
    }

    @DeleteMapping(CUOTA_SOCIAL + "/{id}")
    public ResponseEntity<CuotaSocialDTO> deleteCuotaSocial(@PathVariable Long id){
        this.cuotaSocialService.deleteCuotaSocial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}