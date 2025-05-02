    package com.marcos.gestioncuotas.services;

    import com.marcos.gestioncuotas.dtos.DisciplinaDTO;
    import com.marcos.gestioncuotas.dtos.TarifaDTO;
    import com.marcos.gestioncuotas.entities.Disciplina;
    import com.marcos.gestioncuotas.entities.Tarifa;
    import com.marcos.gestioncuotas.exceptions.DisciplinaNotFoundException;
    import com.marcos.gestioncuotas.mappers.DisciplinaMapper;
    import com.marcos.gestioncuotas.mappers.TarifaMapper;
    import com.marcos.gestioncuotas.repositories.DisciplinaRepository;
    import jakarta.transaction.Transactional;
    import org.springframework.stereotype.Service;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;

    /**
     * @author Marcos Debona
     */

    @Service
    public class DisciplinaServiceImpl implements DisciplinaService {
        private final DisciplinaRepository disciplinaRepository;
        private final DisciplinaMapper disciplinaMapper;
        private final TarifaMapper tarifaMapper;

        public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository, DisciplinaMapper disciplinaMapper, TarifaMapper tarifaMapper) {
            this.disciplinaRepository = disciplinaRepository;
            this.disciplinaMapper = disciplinaMapper;
            this.tarifaMapper = tarifaMapper;
        }

        @Override
        public List<DisciplinaDTO> findAllDisciplina() {
            return disciplinaRepository.findAll()
                    .stream()
                    .map(disciplinaMapper::entityToDto)
                    .collect(Collectors.toList());
        }

        @Override
        public DisciplinaDTO findDisciplinaById(Long id) {
            Disciplina foundDisciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina no encontrada con id: " + id));
            return disciplinaMapper.entityToDto(foundDisciplina);
        }

        @Transactional
        @Override
        public DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO) {
            Disciplina disciplina = disciplinaMapper.dtoToEntity(disciplinaDTO);
            Tarifa tarifa = tarifaMapper.dtoToEntity(disciplinaDTO.getTarifaDTO());

            tarifa.setDisciplina(disciplina);
            tarifa.setFecha(LocalDate.now());
            disciplina.setListaTarifas(new ArrayList<>());
            disciplina.getListaTarifas().add(tarifa);

            Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
            DisciplinaDTO savedDisciplinaDTO = disciplinaMapper.entityToDto(savedDisciplina);
            TarifaDTO lastTarifaDTO = tarifaMapper.entityToDto(savedDisciplina.getListaTarifas().getLast());
            savedDisciplinaDTO.setTarifaDTO(lastTarifaDTO);

            return savedDisciplinaDTO;
        }

        @Transactional
        @Override
        public DisciplinaDTO updateDisciplina(Long id, DisciplinaDTO disciplinaDTO) {
            Disciplina foundDisciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina no encontrada con id: " + id));
            Tarifa tarifa = tarifaMapper.dtoToEntity(disciplinaDTO.getTarifaDTO());

            foundDisciplina.setNombre(disciplinaDTO.getNombre());
            foundDisciplina.setDescripcion(disciplinaDTO.getDescripcion());

            tarifa.setDisciplina(foundDisciplina);
            tarifa.setFecha(LocalDate.now());
            foundDisciplina.getListaTarifas().add(tarifa);

            Disciplina updatedDisciplina = disciplinaRepository.save(foundDisciplina);
            DisciplinaDTO updatedDisciplinaDTO = disciplinaMapper.entityToDto(updatedDisciplina);
            TarifaDTO lastTarifaDTO = tarifaMapper.entityToDto(updatedDisciplina.getListaTarifas().getLast());
            updatedDisciplinaDTO.setTarifaDTO(lastTarifaDTO);

            return updatedDisciplinaDTO;
        }

        @Override
        public void deleteDisciplina(Long id) {
            Disciplina foundDisciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina no encontrada con id: " + id));
            disciplinaRepository.deleteById(id);
        }

        @Transactional
        @Override
        public void addTarifaToDisciplina(Long disciplinaId, TarifaDTO tarifaDTO) {
            Disciplina disciplina = disciplinaRepository.findById(disciplinaId)
                    .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina no encontrada con id: " + disciplinaId));

            Tarifa tarifa = tarifaMapper.dtoToEntity(tarifaDTO);
            tarifa.setDisciplina(disciplina);
            disciplina.getListaTarifas().add(tarifa);
            disciplinaRepository.save(disciplina);
        }

        @Override
        @Transactional
        public List<TarifaDTO> getTarifaHistoryByDisciplinaId(Long id) {
            Disciplina disciplina = disciplinaRepository.findById(id)
                    .orElseThrow(() -> new DisciplinaNotFoundException("Disciplina no encontrada con id: " + id));
            return disciplina.getListaTarifas()
                    .stream()
                    .map(tarifaMapper::entityToDto)
                    .collect(Collectors.toList());
        }
    }