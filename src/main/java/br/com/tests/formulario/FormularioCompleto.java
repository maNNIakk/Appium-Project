package br.com.tests.formulario;

import br.com.core.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FormularioCompleto extends DriverFactory {


    @Before
    public void setupEach() {
        menu.acessarFormulario();
         }

    @After
    public void tearDownEach() {
        driver.navigate().back();
    }

    @Test
    public void realizaCadastroEVerificaValores() {
        formulario.preencheNome("Xablau");
        formulario.selecionarCombo("Nintendo Switch");
        formulario.clicarCheck();
        formulario.clicarSwitch();
        formulario.salvarFormulario();


        Assert.assertEquals("Nome: Xablau",cmd.obterTexto(AppiumBy.xpath("//android" +
                ".widget.TextView[@text=\"Nome: Xablau\"]")));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Console')]")).getText().contains("switch"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget" +
                ".TextView[@text=\"Switch: Off\"]")).getText().endsWith("Off"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkbox: Marcado\"]")).isDisplayed());
    }
}
