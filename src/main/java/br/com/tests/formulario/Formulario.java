package br.com.tests.formulario;

import br.com.factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Formulario extends DriverFactory {

    @Before
    public void setupEach(){
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Formulário\"]")).click();
    }

    @After
    public void tearDownEach(){
        driver.navigate().back();
    }


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

        WebElement checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        WebElement switc = driver.findElement(AppiumBy.className("android.widget.Switch"));

        Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));

        checkBox.click();
        switc.click();

        Assert.assertTrue(checkBox.getAttribute("checked").equals("true"));
        Assert.assertTrue(switc.getAttribute("checked").equals("false"));
    }
}