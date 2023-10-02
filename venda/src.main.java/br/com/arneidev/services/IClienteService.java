/**
 * 
 */
package br.com.arneidev.services;

import br.com.arneidev.domain.Cliente;
import br.com.arneidev.exceptions.DAOException;

/**
 * @author mdias
 *
 */
public interface IClienteService {

	Cliente buscarPorCPF(Long cpf) throws DAOException;
}
