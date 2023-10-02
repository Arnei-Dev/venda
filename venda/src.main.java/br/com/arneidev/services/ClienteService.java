/**
 * 
 */
package br.com.arneidev.services;

import br.com.arneidev.dao.IClienteDAO;
import br.com.arneidev.domain.Cliente;
import br.com.arneidev.exceptions.DAOException;
import br.com.arneidev.exceptions.MaisDeUmRegistroException;
import br.com.arneidev.exceptions.TableException;
import br.com.arneidev.services.generic.GenericService;

/**
 * @author mdias
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService{

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
