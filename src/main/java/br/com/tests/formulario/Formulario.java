package br.com.tests.formulario;

import br.com.factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Formulario extends DriverFactory {


    @Test
    public void preencherCampoNomeFormulario() {
        driver.findElement(AppiumBy.accessibilityId("nome")).sendKeys("Xablau");
        Assert.assertEquals(driver.findElement(AppiumBy.accessibilityId("nome")).getText(), "Xablau");

    }

    @Test
    public void clicaValorCombo() {
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        Assert.assertEquals(driver.findElement(AppiumBy.id("android:id/text1")).getText(), "Nintendo Switch");
    }

    @Test
    public void marcarSwitchECheckbox() {

        WebElement checkBox = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"01/01/2000\"]"));
        WebElement switc = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"06:00\"]"));
        checkBox.click();
        switc.click();

        Assert.assertTrue(checkBox.isSelected());
    }
}