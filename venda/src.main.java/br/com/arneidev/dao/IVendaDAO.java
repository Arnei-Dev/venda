/**
 * 
 */
package br.com.arneidev.dao;

import br.com.arneidev.dao.generic.IGenericDAO;
import br.com.arneidev.domain.Venda;
import br.com.arneidev.exceptions.DAOException;
import br.com.arneidev.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author mdias
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String>{
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
