package br.com.core;

import br.com.page.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class BaseTest {
    public static AndroidDriver driver;
    public static MenuPage menu;
    public static FormularioPage formulario;
    public static SplashPage splash;
    public static AlertaPage alerta;
    public static AbasPage abas;
    public static AccordionPage accordion;
    public static DriverFactory driverFactory = new DriverFactory();


    @BeforeClass
    public static void setup() {

        driverFactory.setUpFactory();
        driver = driverFactory.driver;
        menu = new MenuPage();
        formulario = new FormularioPage();
        splash = new SplashPage();
        alerta = new AlertaPage();
        abas = new AbasPage();
        accordion = new AccordionPage();
    }

    @AfterClass
    public static void tearDownTest() {
        driverFactory.tearDownAll();
    }

    @After
    public void tearDownAfterTest() {
        driverFactory.tearDownFactory();
    }


}