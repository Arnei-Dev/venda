package br.com.arneidev.dao.jdbc.dao;

import br.com.arneidev.domain.Produto;

public interface IProdutoDAO {
	public Integer cadastrar(Produto produto) throws Exception;
	
	public Produto consultar(String produto) throws Exception;

	public Integer excluir(Produto prodBD) throws Exception;
}
