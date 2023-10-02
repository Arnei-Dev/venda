/**
 * 
 */
package br.com.arneidev.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.arneidev.dao.generic.GenericDAO;
import br.com.arneidev.domain.Produto;

/**
 * @author mdias
 *
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO{

	@Override
	public Class<Produto> getTipoClasse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualiarDados(Produto entity, Produto entityCadastrado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getQueryInsercao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getQueryExclusao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getQueryAtualizacao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Produto entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmDelete, String valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Produto entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmUpdate, String valor) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
