package br.com.arneidev.dao.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.arneidev.dao.jdbc.ConnectionFactory;
import br.com.arneidev.domain.Produto;

public class ProdutoDAO implements IProdutoDAO{

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = ("INSERT INTO TB_PRODUTO (ID_PRODUTO, NOME_PRODUTO,QTD_PRODUTO) VALUES (nextval('SQ_TB_PRODUTO'),?,?)");
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getNome_produto());
			stm.setInt(2, produto.getQtd_produto());
			return stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

	@Override
	public Produto consultar(String produto) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto prod = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = ("SELECT * FROM TB_PRODUTO WHERE NOME_PRODUTO = ?");
			stm = con.prepareStatement(sql);
			stm.setString(1, produto);
			rs = stm.executeQuery();
			if(rs.next()) {
				prod = new Produto();
				prod.setId_produto(rs.getLong("id_produto"));
				prod.setNome_produto(rs.getString("nome_produto"));
				prod.setQtd_produto(rs.getInt("qtd_produto"));
			}
			return prod;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

	@Override
	public Integer excluir(Produto prodBD) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = ("DELETE FROM TB_PRODUTO WHERE NOME_PRODUTO = ?");
			stm = con.prepareStatement(sql);
			stm.setString(1, prodBD.getNome_produto());
			return stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
			if(con != null && !con.isClosed()) {
				con.close();
			}
		}
	}

}
