package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;

public class AccordionPage extends BasePage {
    public void selecionarOp1(){
        clicarPorTexto("Opção 1");
    }

    public String obterValorOp1(){
        return obterTexto(AppiumBy.xpath("//*[@text='Opção 1']/../." +
                "./following-sibling::android.view.ViewGroup//android.widget" +
                ".TextView"));
    }
}
