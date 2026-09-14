package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever(By.id("nome"), nome);
    }

    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        esperarElemento(By.xpath("//div[@class='alert alert-success']"));
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro() {
        esperarElemento(By.xpath("//div[@class='alert alert-danger']"));
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }


    public void clicarAlterarConta(String nomeConta) {
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas")
                .findElement(By.xpath(".//a[contains(@href, 'editarConta')]")).click();

        System.out.println("URL atual: " + DriverFactory.getDriver().getCurrentUrl());
        System.out.println("Quantidade de janelas abertas: " + DriverFactory.getDriver().getWindowHandles().size());
    }

    public void excluirConta(String nomeConta) {
        obterCelula("Conta", nomeConta, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
