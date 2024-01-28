package br.com.core;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static br.com.core.DriverFactory.driver;

public class CustomCommands {
    public void escrever(By by, String texto) {
        driver.findElement(by).sendKeys(texto);
    }

    public void clica(By by) {
        driver.findElement(by).click();
    }

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public void clicarPorTexto(String texto) {
        clica(AppiumBy.xpath("//*[@text='" + texto + "']"));
    }

    public void selecionarCombo(By by, String valor) {
        driver.findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isChecked(By by){
        return driver.findElement(by).getAttribute("checked").equals("true");
    }

}
