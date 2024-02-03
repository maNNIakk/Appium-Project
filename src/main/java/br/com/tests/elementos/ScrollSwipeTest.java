package br.com.tests.elementos;

import br.com.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ScrollSwipeTest extends BaseTest {

    @Test
    public void achaOpcaoEscondidaScroll(){
        menu.scroll(0.9,0.1);

        menu.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção",
                alerta.obterMensagemAlerta());
    }

    @Test
    public void utilizaSwipe(){
        menu.acessarSwipe();

        Assert.assertTrue(menu.existeElementPorTexto("a esquerda"));

        menu.swipe(0.9,0.1);

        Assert.assertTrue(menu.existeElementPorTexto("você consegue"));
        menu.clicarPorTexto("›");

        Assert.assertTrue(menu.existeElementPorTexto("Chegar até o fim!"));

        menu.swipe(0.1,0.9);

        Assert.assertTrue(menu.existeElementPorTexto("você consegue"));

        menu.clicarPorTexto("‹");

        Assert.assertTrue(menu.existeElementPorTexto("Mova a tela para"));

    }


}
