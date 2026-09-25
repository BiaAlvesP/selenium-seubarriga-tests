package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class HomePage extends BasePage {

public String obterSaldoConta(String nomeConta) {
    return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo").getText();
}
}
