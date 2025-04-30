package com.marcos.gestioncuotas.repositories;

import com.marcos.gestioncuotas.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marcos Debona
 */

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
