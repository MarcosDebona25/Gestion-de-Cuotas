package com.marcos.gestioncuotas.controllers;

import com.marcos.gestioncuotas.dtos.SocioDTO;
import com.marcos.gestioncuotas.exceptions.SocioAlreadyExistsException;
import com.marcos.gestioncuotas.mappers.SocioMapper;
import com.marcos.gestioncuotas.repositories.SocioRepository;
import com.marcos.gestioncuotas.services.SocioService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marcos.gestioncuotas.utils.ApiPaths.BASE_API;
import static com.marcos.gestioncuotas.utils.ApiPaths.SOCIOS;

/**
 * @author Marcos Debona
 */

@RequestMapping(BASE_API)
@RestController
public class SocioController {
    private final SocioService socioService;
    private final SocioMapper socioMapper;

    public SocioController(SocioService socioService, SocioMapper socioMapper) {
        this.socioService = socioService;
        this.socioMapper = socioMapper;
    }

    @GetMapping(SOCIOS + "/{id}")
    public ResponseEntity<SocioDTO> getSocioById(Long id){
        SocioDTO response = socioService.findSocioById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(SOCIOS + "/{nombre}")
    public ResponseEntity<SocioDTO> getSocioByNombre(@PathVariable String nombre){
        SocioDTO response = socioService.findSocioByNombre(nombre);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(SOCIOS)
    public List<SocioDTO> getAllSocio(){
        return socioService.findAllSocio();
    }

    @PostMapping(SOCIOS)
    public ResponseEntity<SocioDTO> createSocio(@RequestBody SocioDTO socioDTO){
        SocioDTO saved = socioService.saveSocio(socioDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping(SOCIOS + "/{id}")
    public ResponseEntity<SocioDTO> updateSocio(@PathVariable Long id,@RequestBody SocioDTO socioDTO){
        SocioDTO response = socioService.updateSocio(id, socioDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void deleteSocio(Long id){
        socioService.deleteSocio(id);
    }
}