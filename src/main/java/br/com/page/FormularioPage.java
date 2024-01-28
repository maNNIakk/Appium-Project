package br.com.page;

import io.appium.java_client.AppiumBy;

import static br.com.core.DriverFactory.cmd;

public class FormularioPage {



    public void preencheNome(String nome){
        cmd.escrever(AppiumBy.accessibilityId("nome"),"Xablau");
    }
}
