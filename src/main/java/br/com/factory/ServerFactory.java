package br.com.factory;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class ServerFactory {

    private static AppiumDriverLocalService appiumService;

    public static void startAppiumServer() {
        String appiumMainJsPath = "C:\\Users\\renat\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File(appiumMainJsPath))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);

        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();

        System.out.println("Appium server started successfully.");
    }

    public static void stopAppiumServer() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
            System.out.println("Appium server stopped.");
        }
    }
}