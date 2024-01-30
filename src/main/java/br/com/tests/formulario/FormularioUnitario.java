package br.com.tests.formulario;

import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FormularioUnitario extends DriverFactory {

    @BeforeClass
    public static void setupEach() {
        menu.acessarFormulario();
    }


    @Test
    public void preencherCampoNomeFormulario() {
        formulario.preencheNome("Xablau");
        Assert.assertEquals(formulario.obterNome(), "Xablau");

    }

    @Test
    public void clicaValorCombo() {
        formulario.selecionarCombo("Nintendo Switch");

        Assert.assertEquals(formulario.obterValorCombo(), "Nintendo Switch");
    }

    @Test
    public void marcarSwitchECheckbox() {

        Assert.assertFalse(formulario.isCheckMarcado());
        Assert.assertTrue(formulario.isSwitchMarcado());

        formulario.clicarCheck();
        formulario.clicarSwitch();

        Assert.assertTrue(formulario.isCheckMarcado());
        Assert.assertFalse(formulario.isSwitchMarcado());
    }


}