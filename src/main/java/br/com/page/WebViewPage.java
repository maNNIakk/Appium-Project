package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;

import static br.com.core.DriverFactory.driver;

public class WebViewPage extends BasePage {


    public void setEmail(String valor) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"email\"]")).sendKeys(valor);
    }

    public void setSenha(String valor) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"senha\"]")).sendKeys(valor);
    }

    public boolean isTelaLogada(){
       return driver.findElement(AppiumBy.xpath("//android.view" +
                ".View[@text=\"Bem " +
                "vindo, renato!\"]")).isDisplayed();
    }

}
