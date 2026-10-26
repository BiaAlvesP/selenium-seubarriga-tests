
package br.ce.wcaquino.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver =
            ThreadLocal.withInitial(DriverFactory::initDriver);

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver;

        if (Propriedades.TIPO_EXECUCAO
                == Propriedades.TipoExecucao.LOCAL) {

            switch (Propriedades.browser) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;

                case CHROME:
                    driver = new ChromeDriver();
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Browser não suportado: " + Propriedades.browser
                    );
            }

        } else if (Propriedades.TIPO_EXECUCAO
                == Propriedades.TipoExecucao.GRID) {

            try {
                URL gridUrl = new URL("http://localhost:4444");

                switch (Propriedades.browser) {
                    case FIREFOX:
                        driver = new RemoteWebDriver(
                                gridUrl,
                                new FirefoxOptions()
                        );
                        break;

                    case CHROME:
                        driver = new RemoteWebDriver(
                                gridUrl,
                                new ChromeOptions()
                        );
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Browser não suportado: " + Propriedades.browser
                        );
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(
                        "URL inválida do Selenium Grid", e
                );
            }

        } else {
            throw new IllegalStateException(
                    "Tipo de execução não configurado"
            );
        }

        driver.manage().window().maximize();

        return driver;
    }

    public static void killDriver() {
        WebDriver driver = threadDriver.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            threadDriver.remove();
        }
    }
}
