package br.com.core;

import br.com.page.FormularioPage;
import br.com.page.MenuPage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static AndroidDriver driver;
    public static MenuPage menu;
    public static FormularioPage formulario;

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void setUpFactory() {
        ServerFactory.startAppiumServer();

        var options = DeviceConfiguration.getBaseOptions();
        menu = new MenuPage();
        formulario = new FormularioPage();

        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.unlockDevice();
        //       Apenas para a versão 1.2
        //        driver.findElement(AppiumBy.id("android:id/button1"))
        //        .click();

    }


    @AfterClass
    public static void tearDownAllFactory() {
        driver.lockDevice();
        driver.quit();
        ServerFactory.stopAppiumServer();
    }

    @After
    public void tearDownFactory() {
        DriverFactory.gerarScreenShot(getClass().getSimpleName() ,
                testName.getMethodName());
    }

    public static void gerarScreenShot(String methodClass, String methodName) {
        try {
            FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("target/screenshots/" + methodClass + "/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void esperar(long tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
