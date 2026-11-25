package com.vitorlopes.portfolio.domain;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String cargo;

    @Column(nullable = false, length = 100)
    private String area;

    @Column(length = 100)
    private String empresa;

    @Column(nullable = false)
    private boolean atual;

    /** Lista separada por vírgula, por exemplo "Cisco, H3C, Fortinet". */
    @Column(length = 255)
    private String tecnologias;

    @Column(nullable = false)
    private int ordem;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "experiencia_atividade", joinColumns = @JoinColumn(name = "experiencia_id"))
    @OrderColumn(name = "posicao")
    @Column(name = "descricao", nullable = false, length = 255)
    private List<String> atividades = new ArrayList<>();

    protected Experiencia() {
    }

    public Long getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public String getArea() {
        return area;
    }

    public String getEmpresa() {
        return empresa;
    }

    public boolean isAtual() {
        return atual;
    }

    public int getOrdem() {
        return ordem;
    }

    public List<String> getAtividades() {
        return atividades;
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
