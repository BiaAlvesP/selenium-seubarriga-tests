package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {


    public void excluirMovimentacao() {
        clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public String obterMensagemSucesso() {
        esperarElemento(By.xpath("//div[@class='alert alert-success']"));
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

}