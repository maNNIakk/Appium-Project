package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.util.List;

import static br.com.core.DriverFactory.driver;

public class DragDropPage extends BasePage {

    public void arrastar(String origem,String destino){
        WebElement inicio =
                driver.findElement(AppiumBy.xpath("//*[@text='"+origem+"']"));
        WebElement fim =
                driver.findElement(AppiumBy.xpath("//*[@text='"+destino+"']"));

        new TouchAction(driver)
                .longPress(ElementOption.element(inicio))
                .moveTo(ElementOption.element(fim))
                .release()
                .perform();
    }

    public String[] obterLista(){
    List<WebElement> elements =     driver.findElements(AppiumBy.className(
            "android.widget" +
            ".TextView"));
    String[] retorno = new String[elements.size()];
    for(int i = 0;i < elements.size(); i++){
        retorno[i] = elements.get(i).getText();
        System.out.print("\"" + retorno[i] + "\",");
    }
    return retorno;
    }
}
