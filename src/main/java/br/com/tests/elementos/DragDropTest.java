package br.com.tests.elementos;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DragDropTest extends BaseTest {

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag " +
            "em Drop!", "Faça um clique longo,", "e arraste para", "qualquer " +
            "local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista",
            "Drag " +
                    "em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer " +
            "local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,","é " +
            "uma lista",
            "Drag " +
                    "em Drop!", "e arraste para", "Esta", "qualquer " +
            "local desejado."};

    @Before
    public void setup() {
        menu.acessarDragDrop();
    }

    @After
    public void tearDown() {
        driver.navigate().back();
    }

    @Test
    public void deveEfetuarDragNDrop() {
        DriverFactory.esperar(1000);
        Assert.assertArrayEquals(estadoInicial, dragDropd.obterLista());
        dragDropd.arrastar("Esta", "e arraste para");
        Assert.assertArrayEquals(estadoIntermediario, dragDropd.obterLista());
        dragDropd.arrastar("Faça um clique longo,", "é uma lista");
        Assert.assertArrayEquals(estadoFinal, dragDropd.obterLista());

    }
}
