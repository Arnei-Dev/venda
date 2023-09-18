package br.com.arneidev.dao.jdbc.dao;

import br.com.arneidev.domain.Cliente;

public interface IClienteDao {
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;
}
