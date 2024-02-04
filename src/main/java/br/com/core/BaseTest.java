package br.com.core;

import br.com.page.*;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import static br.com.core.DriverFactory.gerarScreenShot;


public class BaseTest {
    public static AndroidDriver driver;
    public static MenuPage menu;
    public static FormularioPage formulario;
    public static SplashPage splash;
    public static AlertaPage alerta;
    public static AbasPage abas;
    public static AccordionPage accordion;
    public static DriverFactory driverFactory = new DriverFactory();
    public static CliquesPage clique;
    public static SwipeListPage swipeList;
    public static DragDropPage dragDropd;

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void setupAll() {

        driverFactory.setUpFactory();
        driver = driverFactory.driver;
        menu = new MenuPage();
        formulario = new FormularioPage();
        splash = new SplashPage();
        alerta = new AlertaPage();
        abas = new AbasPage();
        accordion = new AccordionPage();
        clique = new CliquesPage();
        swipeList = new SwipeListPage();
        dragDropd = new DragDropPage();
    }

    @AfterClass
    public static void tearDownTest() {
        driverFactory.tearDownAll();

    }

    @After
    public void tearDownAfterTest() {
        gerarScreenShot(getClass().getSimpleName(),
                testName.getMethodName());
    }
}