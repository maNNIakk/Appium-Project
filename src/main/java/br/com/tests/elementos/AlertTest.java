package br.com.tests.elementos;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlertTest extends BaseTest {

    @BeforeClass
    public static void setupTeste(){
        menu.acessarAlertas();
    }
    @Test
    public void deveConfirmarAlert(){

        alerta.clicarAlertaConfirm();

        Assert.assertEquals("Info", alerta.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());

        alerta.confirmar();

        Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());

        alerta.sair();
    }

    @Test
    public void deveClicarForaAlerta(){

        alerta.clicarAlertaSimples();

        DriverFactory.esperar(2000);

        alerta.clicarForaCaixa();

        Assert.assertFalse(alerta.existeElementPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
