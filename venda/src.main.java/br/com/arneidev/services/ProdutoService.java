/**
 * 
 */
package br.com.arneidev.services;

import br.com.arneidev.dao.IProdutoDAO;
import br.com.arneidev.domain.Produto;
import br.com.arneidev.services.generic.GenericService;

/**
 * @author mdias
 *
 */
public class ProdutoService extends GenericService<Produto, String> {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}
}
