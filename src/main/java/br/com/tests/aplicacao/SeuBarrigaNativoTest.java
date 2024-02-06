package br.com.tests.aplicacao;

import br.com.core.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeuBarrigaNativoTest extends BaseTest {
    @BeforeClass
    public static void setup() {
        menu.acessarSBNativo();
        barrigaNativo.login();
    }


    @Test
    public void inserirConta() {
        barrigaNativo.insereConta();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Conta adicionada com sucesso"));
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Conta do Xablau"));
        barrigaNativo.irParaHomePage();
        barrigaNativo.resetaConta();

    }

    @Test
    public void excluirConta() {
        barrigaNativo.insereConta();
        barrigaNativo.excluiConta();
        Assert.assertFalse(barrigaNativo.existeElementPorTexto("Conta do " +
                "Xablau"));
    }

    @Test
    public void validaInclusaoMovimentacao() {
        barrigaNativo.clicarPorTexto("Mov...");
        barrigaNativo.salvar();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Descrição é um campo obrigatório"));
        barrigaNativo.preencheDescricao("Descriçao Braba");
        barrigaNativo.salvar();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Interessado é um campo obrigatório"));
        barrigaNativo.preencheInteressado("Joel");
        barrigaNativo.salvar();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Valor é um " +
                "campo obrigatório"));
        barrigaNativo.preencheValor(50);
        barrigaNativo.salvar();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Conta é um " +
                "campo obrigatório"));
        barrigaNativo.preencheConta("Conta para movimentacoes");

    }

}
