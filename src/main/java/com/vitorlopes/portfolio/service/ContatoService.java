package com.vitorlopes.portfolio.service;

import com.vitorlopes.portfolio.domain.MensagemContato;
import com.vitorlopes.portfolio.repository.MensagemContatoRepository;
import com.vitorlopes.portfolio.web.ContatoForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoService {

    private final MensagemContatoRepository repository;

    public ContatoService(MensagemContatoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MensagemContato registrar(ContatoForm form) {
        MensagemContato mensagem = new MensagemContato(
                form.getNome().trim(),
                form.getEmail().trim(),
                form.getMensagem().trim());
        return repository.save(mensagem);
    }
}
