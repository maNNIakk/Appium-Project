package br.com.core;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static AndroidDriver driver;
    public static CustomCommands cmd;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        ServerFactory.startAppiumServer();

        var options = DeviceConfiguration.getBaseOptions();
        cmd = new CustomCommands();
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
