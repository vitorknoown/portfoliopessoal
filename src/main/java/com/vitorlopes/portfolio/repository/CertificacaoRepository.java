package com.vitorlopes.portfolio.repository;

import com.vitorlopes.portfolio.domain.Certificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificacaoRepository extends JpaRepository<Certificacao, Long> {

    List<Certificacao> findAllByOrderByOrdemAsc();
}
