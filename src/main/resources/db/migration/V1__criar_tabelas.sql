CREATE TABLE habilidade (
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    categoria VARCHAR(50)  NOT NULL,
    nome      VARCHAR(100) NOT NULL,
    ordem     INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE experiencia (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    cargo       VARCHAR(100) NOT NULL,
    area        VARCHAR(100) NOT NULL,
    empresa     VARCHAR(100),
    atual       BOOLEAN      NOT NULL,
    tecnologias VARCHAR(255),
    ordem       INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE experiencia_atividade (
    experiencia_id BIGINT       NOT NULL,
    posicao        INT          NOT NULL,
    descricao      VARCHAR(255) NOT NULL,
    PRIMARY KEY (experiencia_id, posicao),
    CONSTRAINT fk_atividade_experiencia FOREIGN KEY (experiencia_id) REFERENCES experiencia (id)
);

CREATE TABLE certificacao (
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    nome    VARCHAR(150) NOT NULL,
    emissor VARCHAR(100) NOT NULL,
    url     VARCHAR(255),
    ordem   INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE projeto (
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(100)  NOT NULL,
    descricao   VARCHAR(1000) NOT NULL,
    tecnologias VARCHAR(255),
    url         VARCHAR(255),
    ordem       INT           NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE mensagem_contato (
    id        BIGINT        NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(100)  NOT NULL,
    email     VARCHAR(150)  NOT NULL,
    mensagem  VARCHAR(2000) NOT NULL,
    enviada_em TIMESTAMP(6) NOT NULL,
    PRIMARY KEY (id)
);
