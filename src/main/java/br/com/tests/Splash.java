package br.com.tests;

import br.com.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;

public class Splash extends DriverFactory {
    @Test
    public void deveAguardarSplashSumir(){
        menu.acessarSplash();

        splash.isTelaSplashVisivel();

        splash.aguardarSplashSumir();

        Assert.assertTrue(splash.existeElementPorTexto("Formulário"));
    }
}
