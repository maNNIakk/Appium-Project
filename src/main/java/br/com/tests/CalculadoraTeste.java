package br.com.tests;

import br.com.factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CalculadoraTeste extends DriverFactory {

    @Test
    public void deveSomarDoisValores() {
        List<WebElement> elementosEncontrados = driver.findElements(AppiumBy.className("android.widget.TextView"));
        for(var elemento: elementosEncontrados){
            System.out.println(elemento.getText());
        }
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Formulário\"]")).click();


    }


}