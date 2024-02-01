package br.com.tests.splash;

import br.com.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class Splash extends BaseTest {
    @Test
    public void deveAguardarSplashSumir(){
        menu.acessarSplash();

        splash.isTelaSplashVisivel();

        splash.aguardarSplashSumir();

        Assert.assertTrue(splash.existeElementPorTexto("Formulário"));
    }
}
