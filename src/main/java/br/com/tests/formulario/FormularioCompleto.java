package br.com.tests.formulario;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class FormularioCompleto extends BaseTest {


    @BeforeClass
    public static void setupEach() {
        menu.acessarFormulario();
    }

    @After
    public void limpaFormulario(){
        formulario.limparFormulario();
    }

    @Test
    public void realizaCadastroEVerificaValores() {
        formulario.preencheNome("Xablau");
        formulario.selecionarCombo("Nintendo Switch");
        formulario.clicarCheck();
        formulario.clicarSwitch();
        formulario.salvarFormulario();


        Assert.assertEquals("Nome: Xablau", formulario.obtemNomeCadastrado());
        Assert.assertTrue(formulario.obtemConsoleCadastrado().contains("switch"));
        Assert.assertTrue(formulario.obtemSwitchCadastrado().endsWith("Off"));
        Assert.assertTrue(formulario.obterCheckboxCadastrado().endsWith(
                "Marcado"));
    }


    @Test
    public void cadastroDemoradoEsperaEstatica() {
        formulario.preencheNome("Xablau");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        formulario.salvarDemorado();
        DriverFactory.esperar(5000);

        Assert.assertEquals("Nome: Xablau", formulario.obtemNomeCadastrado());
    }

    @Test
    public void cadastroDemoradoEsperaImplicita() {
        formulario.preencheNome("Xablau");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        formulario.salvarDemorado();


        Assert.assertEquals("Nome: Xablau", formulario.obtemNomeCadastrado());
    }

    @Test
    public void cadastroDemoradoEsperaExplicita() {
        formulario.preencheNome("Xablau");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        formulario.salvarDemorado();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@text='Nome: Xablau']")));
        Assert.assertEquals("Nome: Xablau", formulario.obtemNomeCadastrado());
    }
}
