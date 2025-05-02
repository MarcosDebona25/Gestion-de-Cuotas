package com.marcos.gestioncuotas.controllers;

import com.marcos.gestioncuotas.dtos.DisciplinaDTO;
import com.marcos.gestioncuotas.dtos.TarifaDTO;
import com.marcos.gestioncuotas.services.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marcos.gestioncuotas.utils.ApiPaths.BASE_API;
import static com.marcos.gestioncuotas.utils.ApiPaths.DISCIPLINAS;

/**
 * @author Marcos Debona
 */

@RestController
@RequestMapping(BASE_API)
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping(DISCIPLINAS)
    public List<DisciplinaDTO> getAllDisciplina(){
        return disciplinaService.findAllDisciplina();
    }

    @GetMapping(DISCIPLINAS + "/{id}")
    public ResponseEntity<DisciplinaDTO> getDisciplinaById(@PathVariable Long id){
        DisciplinaDTO disciplinaFound = disciplinaService.findDisciplinaById(id);
        return new ResponseEntity<>(disciplinaFound, HttpStatus.OK);
    }

    @PostMapping(DISCIPLINAS)
    public ResponseEntity<DisciplinaDTO> createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        DisciplinaDTO savedDisciplina = disciplinaService.saveDisciplina(disciplinaDTO);
        return new ResponseEntity<>(savedDisciplina, HttpStatus.CREATED);
    }

    @PutMapping(DISCIPLINAS + "/{id}")
    public ResponseEntity<DisciplinaDTO> updateDisciplina(@RequestBody DisciplinaDTO disciplinaDTO, @PathVariable Long id){
        DisciplinaDTO updatedDisciplina = disciplinaService.updateDisciplina(id, disciplinaDTO);
        return new ResponseEntity<>(updatedDisciplina, HttpStatus.OK);
    }

    @DeleteMapping(DISCIPLINAS + "/{id}")
    public ResponseEntity<DisciplinaDTO> deleteDisciplina(@PathVariable Long id) {
        disciplinaService.deleteDisciplina(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(DISCIPLINAS + "/{id}/tarifas")
    public ResponseEntity<Void> addTarifaToDisciplina(@PathVariable Long id, @RequestBody TarifaDTO tarifaDTO) {
        disciplinaService.addTarifaToDisciplina(id, tarifaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(DISCIPLINAS + "/{id}/tarifas")
    public ResponseEntity<List<TarifaDTO>> getTarifaHistoryByDisciplinaId(@PathVariable Long id) {
        List<TarifaDTO> tarifaHistory = disciplinaService.getTarifaHistoryByDisciplinaId(id);
        return new ResponseEntity<>(tarifaHistory, HttpStatus.OK);
    }
}