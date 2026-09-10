package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;

public class ResumoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void testRemoverMovimentacao() {
        menuPage.acessarTelaResumoMensal();
        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

    }

}
