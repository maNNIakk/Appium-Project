package br.com.tests.aplicacao;

import br.com.core.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeuBarrigaNativoTest extends BaseTest {
    @BeforeClass
    public static void setup() {
        menu.acessarSBNativo();
        barrigaNativo.login();
    }

    @AfterClass
    public static void tearDown() {
        barrigaNativo.irParaHomePage();
        barrigaNativo.resetaConta();
        driver.navigate().back();
    }


    @Test
    public void inserirConta() {
        barrigaNativo.insereConta();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Conta adicionada com sucesso"));
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Conta do Xablau"));


    }

    @Test
    public void excluirConta() {
        barrigaNativo.insereConta();
        barrigaNativo.excluiConta();
        Assert.assertFalse(barrigaNativo.existeElementPorTexto("Conta para " +
                "excluir"));
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
        barrigaNativo.salvar();
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Movimentação " +
                "cadastrada com sucesso"));


    }

    @Test
    public void excluiMovimentacaoEVerificaSaldo() {
        Assert.assertEquals("534.00", barrigaNativo.obterSaldoConta("Conta " +
                "para saldo"));
        barrigaNativo.clicarPorTexto("Resumo");
        barrigaNativo.excluiMovimentacao("Movimentacao 3, calculo saldo");
        Assert.assertTrue(barrigaNativo.existeElementPorTexto("Movimentação " +
                "removida com sucesso!"));
        barrigaNativo.irParaHomePage();
        barrigaNativo.scrollScreen(0.2,0.9);
        Assert.assertEquals("-1000.00",barrigaNativo.obterSaldoConta("Conta " +
                "para saldo"));

    }

}
