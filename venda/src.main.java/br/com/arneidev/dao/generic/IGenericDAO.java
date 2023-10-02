/**
 * 
 */
package br.com.arneidev.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.arneidev.dao.Persistente;
import br.com.arneidev.exceptions.DAOException;
import br.com.arneidev.exceptions.MaisDeUmRegistroException;
import br.com.arneidev.exceptions.TableException;
import br.com.arneidev.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author mdias
 *
 */
public interface IGenericDAO <T extends Persistente, E extends Serializable> {
	//Método para cadastrar novos registros no banco de dados
	public boolean cadastrar(T entiry) throws TipoChaveNaoEncontradaException, DAOException;
	
	//Método para excluir um registro do banco de dados
	public void excluir(E valor) throws DAOException;
	
	//Método para alterar um registro no bando de dados
	public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
	
	//Método para consultar um registro no banco de dados
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;
	
	//Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
	public Collection<T> buscarTodos() throws DAOException;	
}
