package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nomeConta) {
        esperarElemento(By.id("tabelaSaldo"));
        return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo").getText();
    }
}