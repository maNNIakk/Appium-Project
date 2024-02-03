package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;

public class CliquesPage extends BasePage {
    public void cliquesLongo(){
cliqueLongo(AppiumBy.xpath("//*[@text='Clique Longo']"));
    }

    public String obterTextoCampoClicado(){
        return obterTexto(AppiumBy.xpath("(//android.widget.TextView)[3]"));
    }
}
