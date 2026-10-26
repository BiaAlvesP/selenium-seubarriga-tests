package br.ce.wcaquino.core;

import br.ce.wcaquino.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {


    @Rule
    public TestName testName = new TestName();

    private static LoginPage page = new LoginPage();

    @Before
    public  void inicializa() {
        page.acessarTelaInicial();
        page.setEmail("bia2@gmail.com");
        page.setSenha("Chobia2501@");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        try {
            TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
            File arquivo = ss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
        } finally {
            if (Propriedades.FECHAR_BROWSER) {
                DriverFactory.killDriver();
            }
        }
    }
}
