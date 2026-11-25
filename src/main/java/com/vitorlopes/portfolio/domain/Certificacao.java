package com.vitorlopes.portfolio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificacao")
public class Certificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 100)
    private String emissor;

    /** Link de validação da credencial (opcional). */
    @Column(length = 255)
    private String url;

    @Column(nullable = false)
    private int ordem;

    protected Certificacao() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmissor() {
        return emissor;
    }

    public String getUrl() {
        return url;
    }

    public int getOrdem() {
        return ordem;
    }
}
