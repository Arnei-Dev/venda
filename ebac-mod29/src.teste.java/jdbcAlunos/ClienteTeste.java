package jdbcAlunos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.arneidev.dao.jdbc.dao.ClienteDao;
import br.com.arneidev.dao.jdbc.dao.IClienteDao;
import br.com.arneidev.domain.Cliente;

public class ClienteTeste {
	
	@Test
	public void cadastrarTeste() throws Exception {
		IClienteDao dao = new ClienteDao();
		
		Cliente cliente = new Cliente();
		cliente.setCodigo("03");
		cliente.setNome("M Diaz");
		//Cadastra cliente
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		//Consulta cliente
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		//Exclui cliente do BD
		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
		
	}
}
