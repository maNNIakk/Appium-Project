package br.com.core;

import br.com.page.FormularioPage;
import br.com.page.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static AndroidDriver driver;
    public static CustomCommands cmd;
    public static MenuPage menu;
    public static FormularioPage formulario;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        ServerFactory.startAppiumServer();

        var options = DeviceConfiguration.getBaseOptions();
        cmd = new CustomCommands();
        menu = new MenuPage();
        formulario = new FormularioPage();

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.unlockDevice();
        //       Apenas para a versão 1.2
        //        driver.findElement(AppiumBy.id("android:id/button1"))
        //        .click();

    }


    @AfterClass
    public static void tearDownAll() {
        driver.lockDevice();
        driver.quit();
        ServerFactory.stopAppiumServer();
    }


}
