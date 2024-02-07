package br.com.core;

import br.com.page.*;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
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
    public static SplashPage splash;
    public static AlertaPage alerta;
    public static AbasPage abas;
    public static AccordionPage accordion;

    public static AndroidDriver getDriver(){
        if (driver == null){
            throw new IllegalStateException("Driver has not been initialized " +
                    "porra");
        }
        return driver;
    }

    public static void setUpFactory() {
//        ServerFactory.startAppiumServer();

        var options = DeviceConfiguration.getBaseOptions();
        menu = new MenuPage();
        formulario = new FormularioPage();
        splash = new SplashPage();
        alerta = new AlertaPage();
        abas = new AbasPage();
        accordion = new AccordionPage();

        try {
            if (driver == null) {
                driver = new AndroidDriver(new URL("https" +
                        "://ondemand" +
                        ".us-west-1.saucelabs.com:443/wd/hub"),
                        options);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.unlockDevice();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //       Apenas para a versão 1.2
        //        driver.findElement(AppiumBy.id("android:id/button1"))
        //        .click();

    }


//    @AfterClass
//    public static void tearDownAll() {
//        if (driver != null) {
//            driver.lockDevice();
//
//            driver.quit();
//            driver = null;
//        }
////        ServerFactory.stopAppiumServer();
//
//    }


    public static void gerarScreenShot(String methodClass, String methodName) {
        try {
            FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("target/screenshots/" + methodClass + "/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
