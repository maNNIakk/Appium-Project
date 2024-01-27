package br.com.properties;

import io.appium.java_client.remote.options.BaseOptions;
public class DeviceConfiguration {

    public static BaseOptions getBaseOptions() {
        return new BaseOptions()
                .amend("appium:deviceMetrics.width", 1080)
                .amend("appium:deviceMetrics.height", 1920)
                .amend("appium:deviceMetrics.pixelRatio", 3.0)
                .amend("appium:udid", "emulator-5554")
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
//                .amend("appium:unlockType", "pin")
//                .amend("appium:unlockKey", "6210")
                ;
    }
}
