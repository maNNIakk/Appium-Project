package br.com.tests.formulario;

import br.com.core.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class FormularioCompleto extends DriverFactory {

    WebElement checkBox;
    WebElement switc;

    @Before
    public void setupEach() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Formulário\"]")).click();
        checkBox = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
        switc = driver.findElement(AppiumBy.className("android.widget.Switch"));
    }

    @After
    public void tearDownEach() {
        driver.navigate().back();
    }

    @Test
    public void realizaCadastroEVerificaValores() {
        driver.findElement(AppiumBy.accessibilityId("nome")).sendKeys("Xablau");
        driver.findElement(AppiumBy.id("android:id/text1")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        //Começa desmarcado
        checkBox.click();
        //Começa marcado
        switc.click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\"]")).click();

        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Nome: Xablau\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Console')]")).getText().contains("switch"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Switch: Off\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkbox: Marcado\"]")).isDisplayed());
    }
}
