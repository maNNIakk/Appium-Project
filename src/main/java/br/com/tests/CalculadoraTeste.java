package br.com.tests;

import br.com.factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.junit.Test;


public class CalculadoraTeste extends DriverFactory {

    @Test
    public void deveSomarDoisValores() {
        var el1 = driver.findElement(AppiumBy.accessibilityId("1"));
        el1.click();
        var el2 = driver.findElement(AppiumBy.accessibilityId("Mais"));
        el2.click();
        var el3 = driver.findElement(AppiumBy.accessibilityId("8"));
        el3.click();
        var el4 = driver.findElement(AppiumBy.accessibilityId("Igual"));
        el4.click();
        var el5 = driver.findElement(AppiumBy.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        el5.click();
    Assert.assertTrue(el5.getText().contains("9"));
        Assert.assertEquals("9",el5.getText().replaceAll("[^0-9]",""));

    }
}