package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;

public class AlertaPage extends BasePage {

    public void clicarAlertaConfirm() {
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta() {
        return obterTexto(AppiumBy.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(AppiumBy.id("android:id/message"));
    }

    public void confirmar(){
        clicarPorTexto("CONFIRMAR");
    }

    public void sair(){
        clicarPorTexto("SAIR");
    }
}
