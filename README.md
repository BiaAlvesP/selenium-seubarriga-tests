# 🧪 Automação de Testes — Seu Barriga (Selenium + Java)

Projeto de automação de testes funcionais sobre uma **aplicação real** (não um ambiente de treino isolado), como parte da minha evolução em automação de testes com Selenium WebDriver.

> **Sobre a aplicação testada:** este projeto executa testes contra o **Seu Barriga** (seubarriga.wcaquino.me), uma aplicação de treinamento criada pelo professor **Walter Cunha** (wcaquino.me) para alunos do curso de Automação de Testes praticarem cenários reais de ponta a ponta. O código-fonte da aplicação **não pertence a este repositório** — aqui está apenas o meu código de automação, escrito para testá-la a partir de fora, via navegador.

---

## 🛠️ Stack Técnica

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 23 | Linguagem principal |
| Selenium WebDriver | 4.44.0 | Automação do navegador |
| JUnit 4 | 4.13.x | Framework de testes |
| Maven | — | Gerenciador de dependências e build |
| Apache Commons IO | 2.16.1 | Manipulação de arquivos (screenshots) |
| IntelliJ IDEA | Community | IDE |

---

## 🏗️ Arquitetura

Diferente do meu primeiro projeto de estudos (Campo de Treinamento), aqui as ações do Selenium foram incorporadas **diretamente na `BasePage`**, sem uma camada de DSL separada — uma variação arquitetural intencional, para praticar outra forma de organizar as mesmas responsabilidades:

```
Teste
  ↓  (extends BaseTest)
Page Object
  ↓  (extends BasePage — herda as ações do Selenium)
DriverFactory
  ↓
WebDriver
  ↓
Navegador (Chrome / Firefox)
```

### Camadas

**`Teste`** — Define o cenário e as validações (ex: `ContaTest`).

**`Page Object`** (`LoginPage`, `MenuPage`, `ContasPage`) — Representa uma tela da aplicação e centraliza as ações específicas dela (ex: `setNome()`, `salvar()`). Sabe *onde* está cada elemento e *o que* fazer com ele.

**`BasePage`** — Classe-mãe de todos os Page Objects. Aqui vivem as ações genéricas do Selenium (`escrever`, `clicarBotao`, `selecionarCombo`, tratamento de alerts, frames, espera explícita, etc). Cada Page Object **herda** esse comportamento (`extends BasePage`).

**`DriverFactory`** — Fábrica centralizada do `WebDriver` (Factory Pattern), com chaveamento entre Chrome e Firefox via `Propriedades`.

**`BaseTest`** — Ciclo de vida comum a todo teste: faz login automaticamente antes de cada cenário (`@Before`), tira screenshot e fecha o navegador ao final (`@After`), com `try/finally` garantindo que o navegador feche mesmo se o screenshot falhar.

---

## 📁 Estrutura de Pacotes

```
src/main/java/br/ce/wcaquino/
├── core/
│   ├── DriverFactory.java   # Factory Pattern + chaveamento de browser
│   ├── BasePage.java        # Ações genéricas do Selenium (herdadas pelos Page Objects)
│   ├── BaseTest.java        # Login automático, screenshot e encerramento do driver
│   └── Propriedades.java    # Configurações estáticas (browser, fechar ao final)
│
├── pages/
│   ├── LoginPage.java       # Tela de login
│   ├── MenuPage.java        # Navegação do menu principal
│   └── ContasPage.java      # Cadastro de contas
│
└── tests/
    └── ContaTest.java       # Cenário: inserir uma nova conta
```

---

## ✅ O que já foi implementado

- [x] Login automatizado no `@Before` de todo teste (`BaseTest`)
- [x] Navegação por menu via `clicarLink`
- [x] Cadastro de conta com validação de mensagem de sucesso
- [x] Espera explícita (`esperarElemento`) para lidar com conteúdo carregado de forma assíncrona
- [x] Driver centralizado (Factory Pattern) com chaveamento Chrome/Firefox
- [x] Screenshot automático ao final de cada teste, com tratamento `try/finally` para garantir o encerramento do navegador mesmo em caso de falha

## 🔜 Próximos passos

- [ ] Ampliar cobertura: edição e exclusão de contas, movimentações, resumo mensal
- [ ] Extrair credenciais de login fixas no `BaseTest` para um arquivo de configuração
- [ ] Suite de testes orquestrada (ainda não criada neste projeto)
- [ ] Execução em paralelo / múltiplos browsers
- [ ] Integração com CI/CD

---

## 🐛 Melhorias conhecidas

- **Credenciais fixas no código:** o `BaseTest` faz login com um e-mail/senha fixos, escritos diretamente na classe. Funciona para o estágio atual, mas o ideal é externalizar isso (variável de ambiente ou arquivo de propriedades) antes de qualquer uso mais sério do projeto.
- **Import não utilizado em `ContaTest`:** `import java.awt.*;` está presente sem uso — resquício de autocomplete, sem efeito no funcionamento, mas vale limpar.

Nota: o bug de chaveamento de browser identificado no projeto anterior (linha residual sobrescrevendo a escolha do `switch` no `DriverFactory`) **já nasceu corrigido neste projeto**.

---

## ▶️ Como rodar

Pré-requisitos: Java 23, Maven, Chrome instalado, conexão com a internet (os testes acessam `seubarriga.wcaquino.me` diretamente).

```bash
mvn test
```

Os screenshots de cada execução são salvos em `target/screenshot/`, nomeados automaticamente com o nome do método de teste.

---

## 🎓 Sobre este projeto

Este repositório faz parte da minha trilha de estudos em automação de testes, dando sequência ao projeto anterior de treino (Page Object + DSL sobre uma aplicação isolada). Aqui o foco passa a ser testar uma aplicação real, publicada e acessada via internet, incluindo lidar com sincronismo real de rede, fluxos de autenticação e uma variação arquitetural (herança direta de `BasePage`, sem camada de DSL separada).

---

## 👩‍💻 Autora

Bianca Alves Pinheiro — em transição de QA Manual para QA Automation.