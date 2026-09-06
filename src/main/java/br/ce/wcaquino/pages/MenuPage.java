package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserir(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

}
