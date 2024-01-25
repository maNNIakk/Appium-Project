package br.com.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static AndroidDriver driver;

    public DriverFactory() {
    }

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        ServerFactory.startAppiumServer();

        var options = new BaseOptions()
                .amend("appium:deviceMetrics.width", 1080)
                .amend("appium:deviceMetrics.height", 1920)
                .amend("appium:deviceMetrics.pixelRatio", 3.0)
                .amend("appium:udid", "RQ8M90M4B4X")
                .amend("appium:app", "src//main//resources//CTAppium_2_0.apk")
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:appPackage", "com.ctappium")
                .amend("appium:appActivity", "com.ctappium.MainActivity")
                .amend("appium:noReset", false)
                .amend("appium:fullReset", true)
                .amend("appium:autoGrantPermissions", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 6500)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:unlockType", "pin")
                .amend("appium:unlockKey", "6210");

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        driver.unlockDevice();
        //       Apenas para a versão 1.2
//        driver.findElement(AppiumBy.id("android:id/button1")).click();

    }


    @AfterClass
    public static void tearDownAll() {
        driver.lockDevice();
        driver.quit();
        ServerFactory.stopAppiumServer();
    }


}
