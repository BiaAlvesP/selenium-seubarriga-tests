package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {
    public void acessarTelaInserirConta(){
        esperarPaginaCarregada();
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        esperarPaginaCarregada();
        clicarLink("Contas");
        clicarLink("Listar");
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
