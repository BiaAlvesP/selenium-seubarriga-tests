package br.ce.wcaquino.tests;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();

    @Test
    public void testInserirMovimentacao() {
        menuPage.acessarTelaCriarMovimentacao();
        movPage.setDataMovimentacao("10/06/2024");
        movPage.setDataPagamento("11/06/2024");
        movPage.setDescricao("Descrição da movimentação");
        movPage.setInteressado("Interessado da movimentação");
        movPage.setValor("100.00");
        movPage.setConta("Conta do Teste");
        movPage.setStatusPago();
        movPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }

}
