package br.com.page;

import br.com.core.BasePage;
import io.appium.java_client.AppiumBy;

public class FormularioPage extends BasePage {

    public void preencheNome(String nome) {
        escrever(AppiumBy.accessibilityId("nome"), nome);
    }

    public String obterNome() {
        return obterTexto(AppiumBy.accessibilityId("nome"));
    }

    public void selecionarCombo(String valor) {
        selecionarCombo(AppiumBy.accessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        return obterTexto(AppiumBy.id("android:id/text1"));
    }


    public void clicarCheck() {
        clica(AppiumBy.className("android.widget" +
                ".CheckBox"));
    }

    public void clicarSwitch() {
        clica(AppiumBy.className("android.widget" +
                ".Switch"));
    }

    public boolean isCheckMarcado() {
        return isChecked(AppiumBy.className("android" +
                ".widget" +
                ".CheckBox"));
    }

    public boolean isSwitchMarcado() {
        return isChecked(AppiumBy.className("android.widget" +
                ".Switch"));
    }

    public void salvarFormulario(){
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\"]"));
    }

    public void salvarDemorado(){
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR " +
                "DEMORADO\"]"));
    }

    public void limparFormulario(){
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"LIMPAR\"]"));
    }

    public String obtemNomeCadastrado(){
        return obterTexto(AppiumBy.xpath("//android" +
                ".widget.TextView[@text=\"Nome: Xablau\"]"));
    }

    public String obtemConsoleCadastrado(){
        return obterTexto(AppiumBy.xpath("//android.widget" +
                ".TextView[starts-with(@text, 'Console')]"));
    }

    public String obtemSwitchCadastrado(){
        return obterTexto(AppiumBy.xpath("//android.widget" +
                ".TextView[@text=\"Switch: Off\"]") );

    }

    public String obterCheckboxCadastrado(){
        return obterTexto(AppiumBy.xpath("//android.widget" +
                ".TextView[@text=\"Checkbox: Marcado\"]"));
    }


}
