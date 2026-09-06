package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome){
        escrever(By.id("nome"), nome);
    }

    public void salvar(){
        clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso(){
        esperarElemento(By.xpath("//div[@class='alert alert-success']"));
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
