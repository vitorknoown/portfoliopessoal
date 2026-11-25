package com.vitorlopes.portfolio.service;

import com.vitorlopes.portfolio.domain.Certificacao;
import com.vitorlopes.portfolio.domain.Experiencia;
import com.vitorlopes.portfolio.domain.Habilidade;
import com.vitorlopes.portfolio.domain.Projeto;
import com.vitorlopes.portfolio.repository.CertificacaoRepository;
import com.vitorlopes.portfolio.repository.ExperienciaRepository;
import com.vitorlopes.portfolio.repository.HabilidadeRepository;
import com.vitorlopes.portfolio.repository.ProjetoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class PortfolioService {

    private final HabilidadeRepository habilidadeRepository;
    private final ExperienciaRepository experienciaRepository;
    private final CertificacaoRepository certificacaoRepository;
    private final ProjetoRepository projetoRepository;

    public PortfolioService(HabilidadeRepository habilidadeRepository,
                            ExperienciaRepository experienciaRepository,
                            CertificacaoRepository certificacaoRepository,
                            ProjetoRepository projetoRepository) {
        this.habilidadeRepository = habilidadeRepository;
        this.experienciaRepository = experienciaRepository;
        this.certificacaoRepository = certificacaoRepository;
        this.projetoRepository = projetoRepository;
    }

    /**
     * Agrupa as habilidades por categoria, mantendo a ordem cadastrada.
     * Exemplo: {"Linguagens" -> [Java, Python], "Frameworks" -> [Spring]}.
     */
    public Map<String, List<Habilidade>> habilidadesPorCategoria() {
        return habilidadeRepository.findAllByOrderByOrdemAsc().stream()
                .collect(Collectors.groupingBy(
                        Habilidade::getCategoria,
                        LinkedHashMap::new,
                        Collectors.toList()));
    }

    public List<Experiencia> experiencias() {
        return experienciaRepository.findAllByOrderByOrdemAsc();
    }

    public List<Certificacao> certificacoes() {
        return certificacaoRepository.findAllByOrderByOrdemAsc();
    }

    public List<Projeto> projetos() {
        return projetoRepository.findAllByOrderByOrdemAsc();
    }
}
