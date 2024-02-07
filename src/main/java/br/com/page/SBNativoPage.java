package br.com.page;

import br.com.core.BasePage;
import br.com.core.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

public class SBNativoPage extends BasePage {
    public void login() {
        escrever(AppiumBy.xpath("//android.widget.EditText[@text=\"Nome\"]"),
                "cba@cba");
        escrever(AppiumBy.xpath("//android.widget.EditText[@text=\"Senha\"]")
                , "teste321");
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"ENTRAR\"]"));
    }

    public void resetaConta() {
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"RESET\"]"));
    }

    public void insereConta() {
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"Contas\"]"));
        escrever(AppiumBy.xpath("//android.widget" +
                ".EditText[@text=\"Conta\"]"), "Conta do Xablau");
        salvar();
    }

    public void excluiConta() {
        cliqueLongo(AppiumBy.xpath("//android.widget.TextView[@text=\"Conta do Xablau\"]"));
        clica(AppiumBy.xpath("//android.widget" +
                ".TextView[@text=\"EXCLUIR\"]"));
        DriverFactory.esperar(2000);
    }

    public void preencheConta(String contaText) {
        clica(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Selecione uma conta...\"]"));
        clicarPorTexto(contaText);

    }


    public void irParaHomePage() {
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"Home\"]"));
    }

    public void preencheFormulario() {

    }


    public void preencheDescricao(String descricao) {
        escrever(AppiumBy.xpath("//android.widget.EditText[@text=\"Descrição\"]"), descricao);
    }

    public void preencheInteressado(String interessado) {
        escrever(AppiumBy.xpath("//android.widget" +
                ".EditText[@text=\"Interessado\"]"), interessado);
    }

    public void preencheValor(int valor) {
        escrever(AppiumBy.xpath("//android.widget.EditText[@text=\"Valor\"]")
                , String.valueOf(valor));
    }


    public void salvar() {
        clica(AppiumBy.xpath("//android.widget.TextView[@text=\"SALVAR\"]"));
    }

    public String obterSaldoConta(String conta) {
        return obterTexto(AppiumBy.xpath("//*[@text='" + conta + "']/following" +
                "-sibling::android.widget.TextView"));
    }

    public void excluiMovimentacao(String desc){
        WebElement el = DriverFactory.driver.findElement(AppiumBy.xpath(
                "//*[@text='" + desc + "']/.."));
        swipeElement(AppiumBy.xpath("//*[@text='" + desc + "']/../.."),0.9,0.1);
        clicarPorTexto("Del");

    }
}
