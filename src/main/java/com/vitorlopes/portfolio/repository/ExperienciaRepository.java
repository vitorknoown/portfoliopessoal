package com.vitorlopes.portfolio.repository;

import com.vitorlopes.portfolio.domain.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    List<Experiencia> findAllByOrderByOrdemAsc();
}
