package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta() {
        String nomeOriginal = "Conta " + System.currentTimeMillis();
        menuPage.acessarTelaInserirConta();
        contasPage.setNome(nomeOriginal);
        contasPage.salvar();
        contasPage.esperarElemento(By.xpath("//div[@class='alert alert-success']"));

        menuPage.acessarTelaListarConta();
        System.out.println("URL depois de listar contas: " + DriverFactory.getDriver().getCurrentUrl());

        contasPage.clicarAlterarConta(nomeOriginal);
        System.out.println("URL depois de clicar em editar: " + DriverFactory.getDriver().getCurrentUrl());

        contasPage.esperarElemento(By.id("nome"));
        String nomeEditado = "Conta editada " + System.currentTimeMillis();
        contasPage.setNome(nomeEditado);
        System.out.println("Valor do campo antes de salvar: " + contasPage.obterValorCampo("nome"));

        contasPage.salvar();
        System.out.println("URL depois de clicar em salvar: " + DriverFactory.getDriver().getCurrentUrl());

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaMesmoNome() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

}
