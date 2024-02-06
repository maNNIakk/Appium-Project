package br.com.tests.outros;

import br.com.core.BaseTest;
import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTest extends BaseTest {
    @Test
    public void deveFazerLogin() {
        menu.acessarSBHibrido();

        DriverFactory.esperar(3000);

        webView.setEmail("renato.yancovit4@gmail.com");
        webView.setSenha("teste321");
        webView.clicarPorTexto("Entrar");
        DriverFactory.esperar(3000);

        Assert.assertTrue(webView.isTelaLogada());
    }

}
