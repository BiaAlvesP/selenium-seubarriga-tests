package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

    HomePage page = new HomePage();

    @Test
    public void testSaldoConta() {
        Assert.assertEquals("100.00",page.obterSaldoConta("Conta do Teste"));
    }
}
