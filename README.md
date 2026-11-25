# Portfólio Pessoal | Vitor Rafael Costa Lopes

Site de portfólio feito com **Java** e **Spring Boot**. Apresenta meu perfil, habilidades, atuação em redes, certificações e projetos, e tem um formulário de contato que grava as mensagens no banco de dados.

## Tecnologias

- Java 25
- Spring Boot 4 (Spring MVC, Spring Data JPA, Bean Validation)
- Thymeleaf (páginas renderizadas no servidor)
- MySQL em produção e H2 em desenvolvimento
- Flyway (versionamento do banco)
- Maven
- Docker e Docker Compose

## Estrutura

```
src/main/java/com/vitorlopes/portfolio
├── config/       # PerfilProperties: nome, título, resumo e links lidos do application.yml
├── domain/       # Entidades JPA: Habilidade, Experiencia, Certificacao, Projeto, MensagemContato
├── repository/   # Interfaces Spring Data JPA
├── service/      # Regras de negócio (PortfolioService, ContatoService)
└── web/          # HomeController e ContatoForm (validação do formulário)

src/main/resources
├── application.yml               # Configuração e perfis dev/prod
├── db/migration/                 # Scripts Flyway (tabelas e dados iniciais)
├── templates/index.html          # Página Thymeleaf
└── static/css/style.css          # Estilos
```

O conteúdo do site (habilidades, experiência, certificações e projetos) fica no banco e é carregado pelo script `V2__dados_iniciais.sql`. Para alterar o conteúdo, crie uma nova migração (por exemplo `V3__novo_projeto.sql`) em vez de editar as antigas.

## Como rodar

### Desenvolvimento (H2 em memória, sem instalar banco)

Requisito: JDK 25.

```bash
./mvnw spring-boot:run
```

- Site: http://localhost:8080
- Console do H2 (para ver as mensagens de contato): http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:portfolio`, usuário `sa`, senha em branco

### No navegador (GitHub Codespaces)

Clique em **Code > Codespaces > Create codespace**. O ambiente já vem com Java 25 (configurado em `.devcontainer/devcontainer.json`). Quando o editor abrir, rode `./mvnw spring-boot:run` no terminal e o site abre sozinho na porta 8080.

### Produção com MySQL (Docker Compose)

```bash
cp .env.example .env   # edite as senhas
docker compose up --build
```

Acesse http://localhost:8080.

### Variáveis de ambiente

| Variável | Uso |
|---|---|
| `SPRING_PROFILES_ACTIVE` | `dev` (padrão) ou `prod` |
| `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` | Conexão com o MySQL no perfil `prod` |
| `PORT` | Porta HTTP (padrão 8080) |
| `PORTFOLIO_EMAIL`, `PORTFOLIO_LINKEDIN` | Links opcionais exibidos no topo do site |

## Contato

- GitHub: [vitorknoown](https://github.com/vitorknoown)
