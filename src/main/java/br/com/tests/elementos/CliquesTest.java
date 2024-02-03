package br.com.tests.elementos;

import br.com.core.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CliquesTest extends BaseTest {
    @BeforeClass
    public static void setupEach(){
        menu.acessarCliques();
    }

    @Test
    public void cliqueLongo(){
        clique.cliquesLongo();

        Assert.assertEquals("Clique Longo",clique.obterTextoCampoClicado());
    }

    @Test
    public void cliqueDuplo(){
        clique.clicarPorTexto("Clique duplo");
        clique.clicarPorTexto("Clique duplo");
        Assert.assertEquals("Duplo Clique",clique.obterTextoCampoClicado());
    }


}
