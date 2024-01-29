package br.com.tests.formulario;

import br.com.core.DriverFactory;
import br.com.page.MenuPage;
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