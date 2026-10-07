package br.ce.wcaquino.suites;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.tests.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class

})
public class SuiteGeral {

    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("bia2@gmail.com");
        page.setSenha("Chobia2501@");
        page.entrar();
    }

    @AfterClass
    public static void finaliza() {
        DriverFactory.killDriver();
    }
}
