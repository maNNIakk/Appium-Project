package br.com.tests.elementos;

import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends DriverFactory {
    @Test
    public void deveConfirmarAlert(){
        menu.acessarAlertas();

        alerta.clicarAlertaConfirm();

        Assert.assertEquals("Info", alerta.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());

        alerta.confirmar();

        Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());

        alerta.sair();
    }
}
