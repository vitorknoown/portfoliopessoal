package com.vitorlopes.portfolio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Dados do perfil lidos do application.yml (prefixo "portfolio.perfil").
 * Ficam em configuração porque mudam pouco e não precisam de tabela própria.
 */
@ConfigurationProperties(prefix = "portfolio.perfil")
public record PerfilProperties(
        String nome,
        String titulo,
        String resumo,
        String email,
        String github,
        String linkedin
) {
}
