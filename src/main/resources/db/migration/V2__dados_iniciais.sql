-- Habilidades
INSERT INTO habilidade (categoria, nome, ordem) VALUES
    ('Linguagens',      'Java',                           1),
    ('Linguagens',      'Python',                         2),
    ('Frameworks',      'Spring',                         3),
    ('Banco de dados',  'MySQL',                          4),
    ('Cloud',           'Conceitos e serviços de nuvem',  5),
    ('Ferramentas',     'Git',                            6),
    ('Ferramentas',     'GitHub',                         7);

-- Experiência atual em redes
INSERT INTO experiencia (id, cargo, area, empresa, atual, tecnologias, ordem) VALUES
    (1, 'Técnico de Redes', 'Infraestrutura e redes', NULL, TRUE, 'Cisco, H3C, Fortinet', 1);

INSERT INTO experiencia_atividade (experiencia_id, posicao, descricao) VALUES
    (1, 0, 'Configuração lógica de redes TCP/IP, com endereçamento IP, sub-redes e VLANs'),
    (1, 1, 'Configuração e gerenciamento de serviços de rede, como DHCP e DNS'),
    (1, 2, 'Configuração lógica de access points e switches'),
    (1, 3, 'Diagnóstico e solução de problemas de conectividade'),
    (1, 4, 'Monitoramento da rede e suporte aos usuários'),
    (1, 5, 'Boas práticas de segurança lógica, como controle de acesso');

-- Certificações
INSERT INTO certificacao (nome, emissor, url, ordem) VALUES
    ('AWS Certified Cloud Practitioner', 'Amazon Web Services', NULL, 1);

-- Projetos
INSERT INTO projeto (nome, descricao, tecnologias, url, ordem) VALUES
    ('Portfólio Pessoal',
     'Este site. Aplicação web em camadas (controller, service, repository) com páginas renderizadas no servidor, formulário de contato com validação e banco versionado com Flyway.',
     'Java, Spring Boot, Spring Data JPA, Thymeleaf, MySQL, Flyway, Docker',
     'https://github.com/vitorknoown/portfoliopessoal',
     1);
