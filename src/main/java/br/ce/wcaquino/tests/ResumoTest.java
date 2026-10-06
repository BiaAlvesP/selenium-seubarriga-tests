package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1_RemoverMovimentacao() {
        menuPage.acessarTelaResumoMensal();
        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());

    }

    @Test
    public void test2_ResumoMensal() {
        menuPage.acessarTelaResumoMensal();
        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
    }


}