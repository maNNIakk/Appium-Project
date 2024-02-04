package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

import static br.com.core.DriverFactory.driver;

public class SwipeListPage extends BasePage {
    public void swipeElementLeft(String identificador) {
        swipeElement(AppiumBy.xpath("//*[@text='" + identificador + "']/.."),
                0.1
                , 0.9);
    }

    public void swipeElementRight(String identificador) {
        swipeElement(AppiumBy.xpath("//*[@text='" + identificador + "']/.."), 0.9
                , 0.1);
    }

    public void clicarBotaoMais() {

        new TouchAction(driver)
                .tap(ElementOption.element(driver.findElement(AppiumBy.xpath("//*[@text='(+)']/..")))).perform();
    }
}
