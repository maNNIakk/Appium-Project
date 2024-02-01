package br.com.tests.elementos;

import br.com.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    @Test
    public void deveInteragirComAbas(){
        menu.acessarAbas();

        Assert.assertTrue(abas.isAba1());

        abas.selecionarAba2();

        Assert.assertTrue(abas.isAba2());
    }
}
