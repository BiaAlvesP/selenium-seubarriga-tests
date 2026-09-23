package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends BasePage {
    public void acessarTelaInserirConta(){
        esperarPaginaCarregada();
        esperarJQueryPronto();
        clicarLinkComActions("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        esperarPaginaCarregada();
        esperarJQueryPronto();
        clicarLinkComActions("Contas");
        clicarLink("Listar");
    }

    public void clicarLinkComActions(String link) {
        WebElement elemento = DriverFactory.getDriver().findElement(By.linkText(link));
        new Actions(DriverFactory.getDriver()).moveToElement(elemento).click().perform();
    }

    public void acessarTelaCriarMovimentacao(){
        esperarPaginaCarregada();
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumoMensal(){
        esperarPaginaCarregada();
        clicarLink("Resumo Mensal");
    }

}
