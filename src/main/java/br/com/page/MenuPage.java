package br.com.page;

import br.com.core.BasePage;


public class MenuPage extends BasePage {

    public void acessarFormulario() {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlertas() {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() {
        clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarCliques() {
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe() {
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList() {
        clicarPorTexto("Swipe List");
    }

    public void acessarDragDrop() {
        scrollScreenDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido() {
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSBNativo() {
        clicarPorTexto("SeuBarriga Nativo");
    }
}
