package br.com.arneidev.dao.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.arneidev.dao.jdbc.ConnectionFactory;
import br.com.arneidev.domain.Cliente;

public class ClienteDao implements IClienteDao{

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CADASTRO_CLIENTE (ID_CLIENTE,NOME,CODIGO) VALUES (nextval('SQ_TB_CADASTRO_CLIENTE'),?,?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
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
	public Cliente consultar(String codigo) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_CADASTRO_CLIENTE WHERE CODIGO = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNome(rs.getString("nome"));
			}
			return cliente;
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
	public Integer excluir(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_CADASTRO_CLIENTE WHERE CODIGO = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
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
