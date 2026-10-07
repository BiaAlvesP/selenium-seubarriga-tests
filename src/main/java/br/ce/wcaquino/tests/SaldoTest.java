package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

    HomePage page = new HomePage();
    private MenuPage menuPage = new MenuPage();

    @Test
    public void testSaldoConta() {
        menuPage.acessarTelaHome();
        Assert.assertEquals("100.00",page.obterSaldoConta("Conta do Teste"));
    }
}
