package br.com.tests.formulario;

import br.com.factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Formulario extends DriverFactory {

    @Before
    public void setup(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SeuBarriga Nativo\"]")).click();
    }


    @Test
    public void preencherCampoNomeFormulario() {
        driver.findElement(AppiumBy.accessibilityId("nome")).sendKeys("Xablau");
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("nome")).getText(),"Xablau");
        driver.navigate().back();
    }

    @Test
    public void clicaValorCombo() {
        driver.findElement(AppiumBy.accessibilityId("slid")).click();
        List<WebElement> listaCombo = driver.findElements(AppiumBy.className("android.widget.CheckedTextView"));
        for (WebElement itemCombo : listaCombo) {
            if (itemCombo.getText().contains("XBox")) {
                itemCombo.click();
            }
        }
        Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/text1")).getText(),"XBox One");
    }

    @Test
    @Ignore
    public void marcarSwitchECheckbox(){

    }
}