package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.BaseTest;
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
        contasPage.clicarAlterarConta(nomeOriginal);
        contasPage.esperarElemento(By.id("nome"));
        contasPage.setNome("Conta editada " + System.currentTimeMillis());
        contasPage.salvar();

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
