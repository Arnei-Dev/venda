/**
 * 
 */
package br.com.arneidev.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.arneidev.domain.Produto;
import br.com.arneidev.domain.ProdutoQuantidade;


/**
 * @author mdias
 *
 */
public class ProdutoQuantidadeFactory {
	public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
		Produto prod = ProdutoFactory.convert(rs);
		ProdutoQuantidade prodQ = new ProdutoQuantidade();
		prodQ.setProduto(prod);
		prodQ.setId(rs.getLong("ID"));
		prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
		prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodQ;
	}
}
