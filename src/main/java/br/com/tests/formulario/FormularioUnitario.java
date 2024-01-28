package br.com.tests.formulario;

import br.com.core.DriverFactory;
import br.com.page.MenuPage;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FormularioUnitario extends DriverFactory {

    private MenuPage menu = new MenuPage();

    @Before
    public void setupEach() {
        menu.acessarFormulario();
    }

    @After
    public void tearDownEach() {
        driver.navigate().back();
    }


    @Test
    public void preencherCampoNomeFormulario() {
        cmd.escrever(AppiumBy.accessibilityId("nome"), "Xablau");
        Assert.assertEquals(cmd.obterTexto(AppiumBy.accessibilityId("nome")), "Xablau");

    }

    @Test
    public void clicaValorCombo() {
        cmd.selecionarCombo(AppiumBy.accessibilityId("console"), "Nintendo " +
                "Switch");

        Assert.assertEquals(cmd.obterTexto(AppiumBy.id("android:id/text1")), "Nintendo Switch");
    }

    @Test
    public void marcarSwitchECheckbox() {

        Assert.assertFalse(cmd.isChecked(AppiumBy.className("android.widget" +
                ".CheckBox")));
        Assert.assertTrue(cmd.isChecked(AppiumBy.className("android.widget" +
                ".Switch")));

        cmd.clica(AppiumBy.className("android.widget" +
                ".CheckBox"));
        cmd.clica(AppiumBy.className("android.widget" +
                ".Switch"));

        Assert.assertTrue(cmd.isChecked(AppiumBy.className("android.widget" +
                ".CheckBox")));
        Assert.assertFalse(cmd.isChecked(AppiumBy.className("android.widget" +
                ".Switch")));
    }


}