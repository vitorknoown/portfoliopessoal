package com.vitorlopes.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 1000)
    private String descricao;

    /** Lista separada por vírgula, por exemplo "Java, Spring Boot, MySQL". */
    @Column(length = 255)
    private String tecnologias;

    @Column(length = 255)
    private String url;

    @Column(nullable = false)
    private int ordem;

    protected Projeto() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public int getOrdem() {
        return ordem;
    }

    public List<String> getListaTecnologias() {
        if (tecnologias == null || tecnologias.isBlank()) {
            return List.of();
        }
        return Arrays.stream(tecnologias.split(","))
                .map(String::trim)
                .filter(t -> !t.isEmpty())
                .toList();
    }
}
