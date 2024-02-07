package br.com.core;

import org.openqa.selenium.MutableCapabilities;

public class DeviceConfiguration {


    public static MutableCapabilities getBaseOptions() {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-renato.yancovit3-98362");
        sauceOptions.setCapability("accessKey", "22cb612a-0f77-4ec2-9304-a49a40c8f6d0");
        sauceOptions.setCapability("build", "appium-build-DJ39D");
        sauceOptions.setCapability("name",
                String.valueOf(System.currentTimeMillis()));
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);
        return caps;
    }
}
