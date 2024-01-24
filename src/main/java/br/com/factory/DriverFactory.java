package br.com.factory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory  {
    public static AndroidDriver driver;

    public DriverFactory(){}
    @BeforeClass
    public static void setUp() throws MalformedURLException {
        ServerFactory.startAppiumServer();

        var options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:automationName", "UiAutomator2")
//                .amend("appium:appPackage", "com.sec.android.app.popupcalculator")
//                .amend("appium:noReset", "true")
                .amend("appium:autoGrantPermissions", true)
                .amend("appium:udid", "RQ8M90M4B4X")
//                .amend("appium:appActivity", "com.sec.android.app.popupcalculator.Calculator")
//                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true)
                .amend("appium:app","src/main/resources/CTAppium_2_0.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
    }


    @AfterClass
    public static void tearDown(){
        driver.quit();
        ServerFactory.stopAppiumServer();
    }

}
