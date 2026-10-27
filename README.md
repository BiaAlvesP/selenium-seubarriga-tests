# 🧪 Automação de Testes — Seu Barriga

Automação de testes funcionais da aplicação **Seu Barriga**, desenvolvida com Java e Selenium WebDriver, com foco na validação de funcionalidades financeiras, regras de negócio e comportamento da interface.

[![Java](https://img.shields.io/badge/Java-23-orange?logo=openjdk)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Selenium-4.44.0-43B02A?logo=selenium)](https://www.selenium.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-4.13.1-25A162?logo=junit5)](https://junit.org/junit4/)
[![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven)](https://maven.apache.org/)

---

## 🎯 Objetivo do projeto

Automatizar os principais fluxos funcionais da aplicação, garantindo a validação de operações financeiras, mensagens de retorno e regras de negócio, aplicando boas práticas de desenvolvimento de testes automatizados.

## 🛠️ Tecnologias e ferramentas

| Ferramenta | Versão | Aplicação no projeto |
|:--|:--:|:--|
| ☕ **Java** | 23 | Linguagem utilizada no desenvolvimento dos testes. |
| 🌐 **Selenium WebDriver** | 4.44.0 | Automação das interações com o navegador. |
| 🧪 **JUnit** | 4.13.1 | Execução dos testes e validação dos resultados. |
| 📦 **Apache Maven** | — | Gerenciamento de dependências e execução do projeto. |
| ⚙️ **Maven Surefire** | 3.2.5 | Execução e geração de relatórios da suíte de testes. |
| 📸 **Apache Commons IO** | 2.16.1 | Manipulação de arquivos e evidências de execução. |
| 🧭 **Chrome / Firefox** | — | Navegadores utilizados na automação. |
| 🖥️ **Selenium Grid** | — | Suporte à execução remota dos testes. |

## 🏗️ Arquitetura

O projeto utiliza o padrão **Page Object Model (POM)**, promovendo a separação entre os cenários de teste e os elementos e ações das páginas da aplicação.

| Camada | Responsabilidade |
|:--|:--|
| `core` | Gerenciamento do WebDriver, ações reutilizáveis e ciclo de vida dos testes. |
| `pages` | Representação das páginas e encapsulamento das interações com a interface. |
| `tests` | Implementação dos cenários automatizados e suas validações. |
| `suites` | Organização e execução conjunta dos testes automatizados. |

## 📁 Estrutura do projeto

```text
src/main/java/br/ce/wcaquino/
├── core/
│   ├── BasePage.java
│   ├── BaseTest.java
│   ├── DriverFactory.java
│   └── Propriedades.java
├── pages/
│   ├── ContasPage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── MenuPage.java
│   ├── MovimentacaoPage.java
│   └── ResumoPage.java
├── suites/
│   └── SuiteGeral.java
└── tests/
    ├── ContaTest.java
    ├── MovimentacaoTest.java
    ├── RemoverMovimentacaoContaTest.java
    ├── ResumoTest.java
    ├── SaldoTest.java
    └── utils/
        └── DataUtils.java
```

## ✅ Cenários automatizados

<details>
<summary><strong>🏦 Gestão de contas</strong></summary>

- Cadastro de contas.
- Edição de contas existentes.
- Validação de mensagens de sucesso.
- Validação de restrições para nomes duplicados.

</details>

<details>
<summary><strong>💳 Movimentações financeiras</strong></summary>

- Cadastro de movimentações.
- Validação de campos obrigatórios.
- Validação de regras de negócio relacionadas às datas.
- Verificação de mensagens de validação.

</details>

<details>
<summary><strong>🗑️ Exclusão de contas e movimentações</strong></summary>

- Validação do bloqueio de exclusão de contas com movimentações vinculadas.
- Exclusão de movimentações pelo resumo mensal.
- Verificação de mensagens de retorno.

</details>

<details>
<summary><strong>📊 Resumo mensal e saldo</strong></summary>

- Consulta do resumo mensal.
- Consulta do extrato por período.
- Validação do saldo apresentado na página inicial.

</details>

## 🚀 Como executar

### Pré-requisitos

- Java JDK 23.
- Apache Maven.
- Google Chrome ou Mozilla Firefox, para execução local, ou Selenium Grid disponível para execução remota.
- Acesso à aplicação [Seu Barriga](https://seubarriga.wcaquino.me) e uma conta de teste válida.

### Executar os testes

Na raiz do projeto, execute:

```bash
mvn clean test
```

A execução utiliza a suíte `SuiteGeral`, responsável por reunir os cenários automatizados configurados no projeto.

## 📸 Evidências e relatórios

| Artefato | Localização |
|:--|:--|
| Screenshots dos testes | `target/screenshot/` |
| Relatórios do Maven Surefire | `target/surefire-reports/` |

Esses artefatos auxiliam na análise dos resultados e na identificação de falhas durante a execução.

## 🏁 Status

**Projeto concluído** — implementação de testes funcionais automatizados para os principais fluxos definidos no escopo, utilizando Java, Selenium WebDriver, JUnit, Maven e o padrão Page Object Model.

## 👩‍💻 Autoria

**Bianca Alves Pinheiro**

*QA Automation | Em transição de QA Manual para QA Automation*

