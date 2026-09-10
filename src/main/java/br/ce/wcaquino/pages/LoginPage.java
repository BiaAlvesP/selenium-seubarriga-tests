package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;
import br.ce.wcaquino.core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    public void acessarTelaInicial() {
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    public void setEmail(String email) {
        escrever(By.id("email"), email);
    }

    public void setSenha(String senha) {
        escrever(By.id("senha"), senha);
    }

    public void entrar() {
        clicarBotaoPorTexto("Entrar");
    }

    public void Logar(String email, String senha){
        setEmail(email);
        setSenha(senha);
    }
}
