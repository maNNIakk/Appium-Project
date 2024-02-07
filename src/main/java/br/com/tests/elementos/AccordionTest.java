package br.com.tests.elementos;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTest extends BaseTest {

    @AfterClass
    public static void tearDown(){
        driver.navigate().back();
    }

    @Test
    public void deveInteragirComAccordion(){
        menu.acessarAccordion();

        accordion.selecionarOp1();

        DriverFactory.esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", accordion.obterValorOp1());
    }
}
