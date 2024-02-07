package br.com.core;

import br.com.tests.aplicacao.SeuBarrigaNativoTest;
import br.com.tests.elementos.*;
import br.com.tests.formulario.FormularioCompleto;
import br.com.tests.formulario.FormularioPicker;
import br.com.tests.outros.WebViewTest;
import br.com.tests.splash.Splash;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SeuBarrigaNativoTest.class, AbasTest.class,
        AccordionTest.class, AlertTest.class, CliquesTest.class,
        DragDropTest.class, ScrollSwipeTest.class, FormularioCompleto.class,
        FormularioPicker.class, FormularioCompleto.class, WebViewTest.class,
        Splash.class})
public class TestSuite {
}
