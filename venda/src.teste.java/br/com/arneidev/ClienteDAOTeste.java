/**
 * 
 */
package br.com.arneidev;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.arneidev.dao.ClienteDAO;
import br.com.arneidev.dao.IClienteDAO;
import br.com.arneidev.domain.Cliente;
import br.com.arneidev.exceptions.DAOException;
import br.com.arneidev.exceptions.MaisDeUmRegistroException;
import br.com.arneidev.exceptions.TableException;
import br.com.arneidev.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author mdias
 *
 */
public class ClienteDAOTeste {
	
	private IClienteDAO clienteDAO;
	public ClienteDAOTeste() {
		clienteDAO = new ClienteDAO();
	}
	/*
	@After
	public void end() throws DAOException {
		Collection<Cliente> list = clienteDAO.buscarTodos();
		list.forEach(e -> {
			try {
				clienteDAO.excluir(e.getCpf());
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
*/
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		Cliente cliente = new Cliente();
		cliente.setNome("Mário Dias");
		cliente.setCpf(14333787L);
		cliente.setIdade(36);
		cliente.setCidade("São Paulo");
		cliente.setEndereco("Rua Conselheiro Ramalho");
		cliente.setEstado("SP");
		cliente.setNumero(1002);
		cliente.setTel(11945024577L);
		clienteDAO.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
		
		//clienteDAO.excluir(cliente.getCpf());
	}
}
