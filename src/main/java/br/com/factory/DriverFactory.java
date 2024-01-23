package br.com.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory  {
    public static AndroidDriver driver;

    static {
        try {
            setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public DriverFactory(){}
    @BeforeClass
    public static void setUp() throws MalformedURLException {
        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:appPackage", "com.sec.android.app.popupcalculator")
                .amend("appium:noReset", "false")
                .amend("appium:autoGrantPermissions", true)
                .amend("appium:udid", "RQ8M90M4B4X")
                .amend("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public static AndroidDriver getDriver(){
        return driver;
    }
}
