package br.com.tests.formulario;

import br.com.core.DriverFactory;
import br.com.page.MenuPage;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FormularioCompleto extends DriverFactory {

    MenuPage menu = new MenuPage();

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
        cmd.escrever(AppiumBy.accessibilityId("nome"),"Xablau");
        cmd.selecionarCombo(AppiumBy.accessibilityId("console"),"Nintendo " +
                "Switch");
        //Começa desmarcado
        cmd.clica(AppiumBy.className("android.widget.CheckBox"));
        //Começa marcado
        cmd.clica(AppiumBy.className("android.widget.Switch"));
        cmd.clica(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\"]"));


        Assert.assertEquals("Nome: Xablau",cmd.obterTexto(AppiumBy.xpath("//android" +
                ".widget.TextView[@text=\"Nome: Xablau\"]")));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[starts-with(@text, 'Console')]")).getText().contains("switch"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget" +
                ".TextView[@text=\"Switch: Off\"]")).getText().endsWith("Off"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkbox: Marcado\"]")).isDisplayed());
    }
}
