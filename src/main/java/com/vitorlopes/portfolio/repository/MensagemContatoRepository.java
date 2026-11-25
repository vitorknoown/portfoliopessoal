package com.vitorlopes.portfolio.repository;

import com.vitorlopes.portfolio.domain.MensagemContato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemContatoRepository extends JpaRepository<MensagemContato, Long> {
}
