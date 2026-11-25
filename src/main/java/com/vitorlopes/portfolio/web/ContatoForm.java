package com.vitorlopes.portfolio.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Dados enviados pelo formulário de contato.
 * Usa getters/setters (e não record) porque o th:field do Thymeleaf
 * acessa as propriedades no padrão JavaBean.
 */
public class ContatoForm {

    @NotBlank(message = "Informe seu nome")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "Informe seu e-mail")
    @Email(message = "Informe um e-mail válido")
    @Size(max = 150, message = "O e-mail deve ter no máximo 150 caracteres")
    private String email;

    @NotBlank(message = "Escreva uma mensagem")
    @Size(max = 2000, message = "A mensagem deve ter no máximo 2000 caracteres")
    private String mensagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
