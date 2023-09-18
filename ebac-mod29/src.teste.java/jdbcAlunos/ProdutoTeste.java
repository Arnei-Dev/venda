package jdbcAlunos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.arneidev.dao.jdbc.dao.IProdutoDAO;
import br.com.arneidev.dao.jdbc.dao.ProdutoDAO;
import br.com.arneidev.domain.Produto;

public class ProdutoTeste {

	@Test
	public void cadastrarProduto() throws Exception {
		IProdutoDAO prod = new ProdutoDAO();
		Produto produto = new Produto();
		produto.setNome_produto("Queijo");
		produto.setQtd_produto(15);
		Integer inserted = prod.cadastrar(produto);
		assertTrue(inserted == 1);
		//Consultar produto from bd
		Produto produt = prod.consultar(produto.getNome_produto());
		assertNotNull(produt);
		assertNotNull(produt.getId_produto());
		assertEquals(produto.getQtd_produto(),produt.getQtd_produto());
		assertEquals(produto.getNome_produto(),produt.getNome_produto());
		//Excluir cadastro from tbl bd
		Integer isProd = prod.excluir(produt);
		assertNotNull(isProd);
		

	}
}
