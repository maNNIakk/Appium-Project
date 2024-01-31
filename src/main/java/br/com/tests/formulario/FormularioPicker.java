package br.com.tests.formulario;

import br.com.core.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FormularioPicker extends DriverFactory {
    @BeforeClass
    public static void setupEach() {
        menu.acessarFormulario();
    }

    @After
    public void limpaFormulario(){
        formulario.limparFormulario();
    }
    @Test
    public void deveAlterarData() {
        formulario.clicarPorTexto("01/01/2000");
        formulario.clicarPorTexto("20");
        formulario.clicarPorTexto("OK");

        Assert.assertTrue(formulario.existeElementPorTexto("20/01/2000"));
    }

    @Test
    public void deveAlterarHorario(){
        formulario.clicarPorTexto("09:00");
        formulario.clica(AppiumBy.accessibilityId("10"));
        formulario.clica(AppiumBy.accessibilityId("40"));
        formulario.clicarPorTexto("OK");
        Assert.assertTrue(formulario.existeElementPorTexto("10:40"));

    }
}
