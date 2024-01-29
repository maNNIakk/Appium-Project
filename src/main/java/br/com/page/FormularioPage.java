package br.com.page;

import io.appium.java_client.AppiumBy;

import static br.com.core.DriverFactory.cmd;

public class FormularioPage {

    public void preencheNome(String nome) {
        cmd.escrever(AppiumBy.accessibilityId("nome"), nome);
    }

    public String obterNome() {
        return cmd.obterTexto(AppiumBy.accessibilityId("nome"));
    }

    public void selecionarCombo(String valor) {
        cmd.selecionarCombo(AppiumBy.accessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        return cmd.obterTexto(AppiumBy.id("android:id/text1"));
    }

    public void clicarCheck() {
        cmd.clica(AppiumBy.className("android.widget" +
                ".CheckBox"));
    }

    public void clicarSwitch() {
        cmd.clica(AppiumBy.className("android.widget" +
                ".Switch"));
    }

    public boolean isCheckMarcado() {
        return cmd.isChecked(AppiumBy.className("android" +
                ".widget" +
                ".CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return cmd.isChecked(AppiumBy.className("android.widget" +
                ".Switch"));
    }

    public void salvarFormulario(){
        cmd.clica(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\"]"));
    }

    public

}
