package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaMovimentacao(){
        menuPage.acessarTelaListarConta();
        contasPage.excluirConta("Conta do Teste");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }


}
