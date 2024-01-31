package br.com.core;

import br.com.properties.Devices;
import io.appium.java_client.remote.options.BaseOptions;

public class DeviceConfiguration {


    public static BaseOptions getBaseOptions() {
        BaseOptions options = new BaseOptions()
                .amend("appium:udid", Devices.EMULATOR)
                .amend("appium:app", "src//main//resources//CTAppium_2_0.apk")
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:appPackage", "com.ctappium")
                .amend("appium:appActivity", "com.ctappium.MainActivity")
                .amend("appium:noReset", false)
                .amend("appium:fullReset", true)
                .amend("appium:autoGrantPermissions", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 6500);
        if (options.getCapability("appium:udid") == Devices.PHYSICAL_DEVICE_UDID) {
            options
                    .amend("appium:unlockType", "pin")
                    .amend("appium:unlockKey", "6210");
            System.out.println("CHEGUEI AQUI PO");
        } else if (options.getCapability("appium:udid") == Devices.EMULATOR){
            options
            .amend("appium:deviceName", "emulator-5554");
        }
        return options;
    }
}
