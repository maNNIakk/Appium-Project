package br.com.tests.formulario;

import br.com.core.DriverFactory;
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


        Assert.assertEquals("Nome: Xablau",formulario.obtemNomeCadastrado());
        Assert.assertTrue(formulario.obtemConsoleCadastrado().contains("switch"));
        Assert.assertTrue(formulario.obtemSwitchCadastrado().endsWith("Off"));
        Assert.assertTrue(formulario.obterCheckboxCadastrado().endsWith(
                "Marcado"));
    }
}
