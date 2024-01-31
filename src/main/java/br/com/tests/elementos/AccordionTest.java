package br.com.tests.elementos;

import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends DriverFactory {

    @Test
    public void deveInteragirComAccordion(){
        menu.acessarAccordion();

        accordion.selecionarOp1();

        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", accordion.obterValorOp1());
    }
}
