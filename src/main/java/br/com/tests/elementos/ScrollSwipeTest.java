package br.com.tests.elementos;

import br.com.core.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;

public class ScrollSwipeTest extends BaseTest {
    

    @Test
    public void achaOpcaoEscondidaScroll(){
        menu.scrollScreenDown();

        menu.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção",
                alerta.obterMensagemAlerta());

        menu.clica(AppiumBy.id("android:id/button1"));

        menu.scrollScreenUp();

    }

    @Test
    public void utilizaSwipe(){
        menu.acessarSwipe();

        Assert.assertTrue(menu.existeElementPorTexto("a esquerda"));

        menu.swipeScreenRight();

        Assert.assertTrue(menu.existeElementPorTexto("você consegue"));
        menu.clicarPorTexto("›");

        Assert.assertTrue(menu.existeElementPorTexto("Chegar até o fim!"));

        menu.swipeScreenLeft();

        Assert.assertTrue(menu.existeElementPorTexto("você consegue"));

        menu.clicarPorTexto("‹");

        Assert.assertTrue(menu.existeElementPorTexto("Mova a tela para"));
        driver.navigate().back();
    }

    @Test
    public void swipeList(){
        menu.acessarSwipeList();

        swipeList.swipeElementRight("Opção 1");

        swipeList.clicarBotaoMais();

        Assert.assertTrue(swipeList.existeElementPorTexto("Opção 1 (+)"));

        swipeList.swipeElementRight("Opção 4");

        swipeList.clicarPorTexto("(-)");

        Assert.assertTrue(swipeList.existeElementPorTexto("Opção 4 (-)"));

        swipeList.swipeElementLeft("Opção 5 (-)");

        Assert.assertTrue(swipeList.existeElementPorTexto("Opção 5"));

        driver.navigate().back();


    }


}
