package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {
    public void setDataPagamento(String data) {

        escrever(By.id("data_pagamento"), data);

    }


    public void setDataMovimentacao(String data) {

        escrever(By.id("data_transacao"), data);
    }

    public void setDescricao(String descricao) {

        escrever(By.id("descricao"), descricao);
    }


    public void setInteressado(String interessado) {

        escrever(By.id("interessado"), interessado);
    }

    public void setValor(String valor) {

        escrever(By.id("valor"), valor);
    }

    public void setConta(String conta) {

        selecionarCombo("conta", conta);
    }

    public void setStatusPago() {

        clicar("status_pago");
    }

    public void salvar() {

        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        esperarElemento(By.xpath("//div[@class='alert alert-success']"));
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
