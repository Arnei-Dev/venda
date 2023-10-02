/**
 * 
 */
package br.com.arneidev.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import br.com.arneidev.dao.Persistente;

/**
 * @author mdias
 *
 */
public class Venda implements Persistente{
	
	public enum Status {
		INICIADA, CONCLUIDA, CANCELADA;
		
		public static Status getByName(String value) {
			for (Status status : Status.values()) {
				if(status.name().equals(value)) {
					return status;
				}
			}
			return null;
		}
	}
	private Long id;
	private String codigo;
	private Cliente cliente;
	private Set<ProdutoQuantidade> produtos;
	private BigDecimal valorTotal;
	private Instant dataVenda;
	private Status status;
	
	public Venda() {
		produtos = new HashSet<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoQuantidade> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoQuantidade> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void adicionarProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op =
				produtos.stream()
				.filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if(op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			produtpQtd.adicionar(quantidade);
		}else {
			//Fabrica criar produtoQuantidade
			ProdutoQuantidade prod = new ProdutoQuantidade();
			prod.setProduto(produto);
			prod.adicionar(quantidade);
			produtos.add(prod);
		}
		recalcularValorTotalVenda();
	}

	private void validarStatus() {
		if(this.status == Status.CONCLUIDA) {
			throw new UnsupportedOperationException("IMPOSSÍVEL ALTERAR VENDA FINALIZADA");
		}
	}
	
	public void removerProduto(Produto produto, Integer quantidade) {
		validarStatus();
		Optional<ProdutoQuantidade> op =
				produtos.stream()
				.filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
		if(op.isPresent()) {
			ProdutoQuantidade produtpQtd = op.get();
			if(produtpQtd.getQuantidade() > quantidade) {
				produtpQtd.remover(quantidade);
				recalcularValorTotalVenda();
			}else {
				produtos.remove(op.get());
				recalcularValorTotalVenda();
			}
			
		}
	}
	
	public void removerTodosProdutos() {
		validarStatus();
		produtos.clear();
		valorTotal = BigDecimal.ZERO;
	}
	
	public Integer getQuantidadeTotalProdutos() {
		// Soma a quantidade getQuantidade() de todos os objetos ProdutoQuantidade
		int result = produtos.stream()
				.reduce(0, (partialCountResult, prod)-> partialCountResult + prod.getQuantidade(), Integer::sum);
		return result;
	}
	
	
	public void recalcularValorTotalVenda() {
		BigDecimal valorTotal = BigDecimal.ZERO;
		for (ProdutoQuantidade prod : this.produtos) {
			valorTotal = valorTotal.add(prod.getValorTotal());
		}
		this.valorTotal = valorTotal;
	}
}
