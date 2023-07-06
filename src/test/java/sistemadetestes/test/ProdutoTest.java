package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de teste criada para verificar coberturas sobre a página de produtos
 * 
 * @author Miguel Rosa e Júlio Perota
 * @date 05/07/2023
 * 
 */

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {
	
	private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void beforeClass() {
		produtoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC01_testarCriacaoProdutoEmBranco() {
		
		produtoPage.cadastrarProduto("", "", "", "", "");		
		
		String mensagem = produtoPage.getMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");	
	}
	
	@Test
	public void TC02_testarCriacaoProduto() {
		
		produtoPage.cadastrarProduto("123", "Sempiternal", "1", "50,00", "2013-04-01");
		produtoPage.buttonSair.click();
	
		String codigo = produtoPage.getCodigo();
		
		assertEquals(codigo, "123");
		
	}
	
	@Test
	public void TC03_testarCriacaoProdutoIncompleto() {
		
		produtoPage.cadastrarProduto("", "That's The Spirit", "1", "40,00", "2015-09-11");
		
		String mensagem = produtoPage.getMensagem();
		
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}

}