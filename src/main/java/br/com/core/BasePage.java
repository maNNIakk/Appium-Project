package br.com.core;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.com.core.DriverFactory.driver;

public class BasePage {
    public void escrever(By by, String texto) {
        driver.findElement(by).sendKeys(texto);
    }

    public void clica(By by) {
        driver.findElement(by).click();
    }

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public void clicarPorTexto(String texto) {
        clica(AppiumBy.xpath("//*[@text='" + texto + "']"));
    }


    public void selecionarCombo(By by, String valor) {
        driver.findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isChecked(By by) {
        return driver.findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementPorTexto(String texto) {
        List<WebElement> elements = driver.findElements(AppiumBy.xpath(
                "//*[@text='" + texto + "']"));
        return elements.size() > 0;
    }

    public void tap(int x, int y) {
        new TouchAction(driver).press(PointOption.point(x, y)).release().perform();
    }

    public void interageComSeekBar(By seekBarLocator,
                                   double posicao) {
        int delta = 20;

        WebElement seekBar = driver.findElement(seekBarLocator);
        int y = seekBar.getLocation().y + (seekBar.getSize().height / 2);
        int xInicial = seekBar.getLocation().x + delta;
        int x =
                (int) (xInicial + ((seekBar.getSize().width - 2 + delta) * posicao));

        tap(x, y);
    }

    public void cliqueLongo(By locator) {
        new TouchAction(driver).longPress(ElementOption.element(driver.findElement(locator))).release().perform();
    }

    public void scrollScreen(double inicio, double fim) {
        Dimension size = driver.manage().window().getSize();

        int x = size.width / 2;
        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);

        new TouchAction(driver).longPress(PointOption.point(x, yInicial)).moveTo(PointOption.point(x, yFinal)).release().perform();
    }

    public void scrollElement(By by ,double inicio, double fim) {
        Dimension size = driver.findElement(by).getSize();
        System.out.println(size);
        int x = size.width / 2;
        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);

        new TouchAction(driver).longPress(PointOption.point(x, yInicial)).moveTo(PointOption.point(x, yFinal)).release().perform();
    }

    public void scrollScreenDown(){
        scrollScreen(0.9,0.1);
    }

    public void scrollScreenUp(){
        scrollScreen(0.1,0.9);
    }
    public void scrollElementDown(By by){
        scrollElement(by,0.1,0.9);
    }

    public void swipeScreen(double inicio, double fim) {
        Dimension size = driver.manage().window().getSize();

        int y = size.height / 2;

        int xInicial = (int) (size.width * inicio);
        int xFinal = (int) (size.width * fim);

        new TouchAction(driver)
                .longPress(PointOption.point(xInicial, y))
                .moveTo(PointOption.point(xFinal, y))
                .release()
                .perform();
    }

    public void swipeElement(By by, double inicio,
                             double fim) {
        WebElement element = driver.findElement(by);

        int y = element.getLocation().y + (element.getSize().height/2);

        int xInicial = (int) (element.getSize().width * inicio);
        int xFinal = (int) (element.getSize().width * fim);

        new TouchAction(driver)
                .longPress(PointOption.point(xInicial, y))
                .moveTo(PointOption.point(xFinal, y))
                .release()
                .perform();
    }

    public void swipeScreenLeft(){
        swipeScreen(0.1,0.9);
    }

    public void swipeScreenRight(){
        swipeScreen(0.9,0.1);
    }

    public String obterTituloAlerta() {
        return obterTexto(AppiumBy.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(AppiumBy.id("android:id/message"));
    }
}
