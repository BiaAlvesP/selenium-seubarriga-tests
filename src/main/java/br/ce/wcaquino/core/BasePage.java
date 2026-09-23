package br.ce.wcaquino.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private WebDriverWait wait;


    public BasePage() {
        DriverFactory.getDriver();
        this.wait = new WebDriverWait(DriverFactory.getDriver(), java.time.Duration.ofSeconds(5));
    }


    public void escrever(By by, String text) {
        WebElement elemento = DriverFactory.getDriver().findElement(by);
        executarJS("arguments[0].value = arguments[1];", elemento, text);
        executarJS("arguments[0].dispatchEvent(new Event('input', {bubbles:true}));", elemento);
        executarJS("arguments[0].dispatchEvent(new Event('change', {bubbles:true}));", elemento);
    }


    public String obterValorCampo(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
    }


    public void clicarBotao(By by) {
        WebElement elemento = DriverFactory.getDriver().findElement(by);
        try {
            elemento.click();
        } catch (Exception e) {
            executarJS("arguments[0].click();", elemento);
        }
    }

    public void clicar(String id) {

        clicarBotao(By.id(id));
    }

    public void clicarBotaoPorTexto(String texto) {
        clicarBotao(By.xpath("//button[.='" + texto + "']"));
    }

    public Boolean checarClick(String id) {

        return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        // combo.selectByIndex(4); // por index
//          combo.selectByValue("superior"); // pelo value
        combo.selectByVisibleText(valor);      // mais legal usar esse, porque é como o usuário visualiza

    }

    public void deSelecionarCombo(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);

    }

    public String obterValorCombo(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);

        return combo.getFirstSelectedOption().getText();

    }

    public List<String> obterValoresCombo(String id) {

        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();

        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }

        return valores;
    }


    public int obterQtdOpcaoCombo(String id) {

        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();

        return options.size();
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {

        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();

        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }

        }

        return false;
    }

    public void clicarLink(String link) {
        int tentativas = 0;
        while (tentativas < 5) {
            try {
                esperarElemento(By.linkText(link));
                DriverFactory.getDriver().findElement(By.linkText(link)).click();
                return;
            } catch (StaleElementReferenceException | TimeoutException e) {
                tentativas++;
            }
        }
    }

    public void esperarPaginaCarregada() {
        WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
        espera.until(driver -> executarJS("return document.readyState").equals("complete"));
    }

    public String obterText(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).getText();
    }


    public String obterTexto(By by) {
        return DriverFactory.getDriver().findElement(by).getText();
    }


    public String obterValueElemento(String id) {
        WebElement button = DriverFactory.getDriver().findElement(By.id(id));
        return button.getAttribute("value");
    }


    ////////////////Alertas///////////////////////////

    public String alertaObterTexto() {
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        return alerta.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        String texto = alerta.getText();
        alerta.accept();
        return texto;
    }

    public String alertaObterTextoENega() {
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        String texto = alerta.getText();
        alerta.dismiss();
        return texto;
    }

    public void alertaEscrever(String valor) {
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
        alerta.sendKeys(valor);
        alerta.accept();
    }

    ////////////////Frames///////////////////////////

    public void entrarFrame(String id) {

        DriverFactory.getDriver().switchTo().frame(id);
    }

    public void sairFrame() {

        DriverFactory.getDriver().switchTo().defaultContent();
    }


    public void fecharFrame() {

        DriverFactory.getDriver().close();    }

    public void mudarJanela(String id) {

        DriverFactory.getDriver().switchTo().window(id);// nem todos os popup tem indentificados
    }


    // Tabela
    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='" + idTabela + "']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
        WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();
    }

    private int obterIndiceColuna(String colunaBusca, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        for (int i = 0; i < colunas.size(); i++) {
            if (colunas.get(i).getText().equals(colunaBusca)) {
                return i + 1; // XPath começa em 1
            }
        }
        return -1;
    }

    private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath(".//tbody//tr"));
        for (int i = 0; i < linhas.size(); i++) {
            WebElement celula = linhas.get(i).findElements(By.xpath(".//td")).get(idColuna - 1);
            if (celula.getText().equals(valor)) {
                return i + 1; // XPath começa em 1
            }
        }
        return -1;
    }

    public void esperarCampoPreenchido(By by) {
        WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        espera.until(driver -> !driver.findElement(by).getAttribute("value").isEmpty());
    }


    //Wait
    public void esperarElemento(By by){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /************JS*******************/

    public Object executarJS(String cmd, Object... param){
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        return js.executeScript(cmd,param);
    }

    public void esperarJQueryPronto() {
        WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        espera.until(driver -> {
            Object resultado = executarJS(
                    "return (typeof jQuery !== 'undefined') ? jQuery.active === 0 : true;"
            );
            return Boolean.TRUE.equals(resultado);
        });
    }


}
