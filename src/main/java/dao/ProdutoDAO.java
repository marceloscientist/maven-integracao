package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoMySql;
import domain.Produto;

public class ProdutoDAO {
	
	public void salvar(Produto produto) {
		 
		Connection conexao = ConexaoMySql.iniciarConexao(); 
		PreparedStatement instrucao = null;
		
		try {
			instrucao = conexao
					 .prepareStatement("INSERT INTO produto "
					 		+ "(nome, preco, quantidadeEstoque) "
					 		+ "VALUES (?,?,?)");  
			
			instrucao.setString(1, produto.getNome());
			instrucao.setDouble(2, produto.getPreco());
			instrucao.setInt(3, produto.getQuantidadeEstoque());
			
			instrucao.executeUpdate();

		} catch(SQLException ex) {
			System.err.println(ex.getMessage());		
		} finally {
			ConexaoMySql.encerrarConexao(conexao, instrucao);
		}
	}
		
	public List<Produto> listar() {
		 
		Connection conexao = ConexaoMySql.iniciarConexao(); 
		PreparedStatement instrucao = null;
		ResultSet resultado = null;
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		try {
			instrucao = conexao
					 .prepareStatement("SELECT * FROM produto");  
			
			resultado = instrucao.executeQuery();
			
			while (resultado.next()){ 
		           Produto produto = new Produto(); 
		           produto.setId(resultado.getInt("id"));
		           produto.setNome(resultado.getString("nome")); 
		           produto.setPreco(resultado.getDouble("preco")); 
		           produto.setQuantidadeEstoque(resultado.getInt("quantidadeEstoque"));
		           listaProdutos.add(produto); //Por fim ao jogar os valores para os atributos do objeto, adiciona ele na lista
		    }
			
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());		
		} finally {
			ConexaoMySql.encerrarConexao(conexao, instrucao, resultado);
		}
		
		return listaProdutos;
	}

	// atualizar
	public void atualizar(Produto produto, int idProduto) {
		Connection conexao = ConexaoMySql.iniciarConexao(); 
		PreparedStatement instrucao = null;
		
		try {
			instrucao = conexao
					 .prepareStatement(" UPDATE produto "
					 		+ " SET nome = ? "
					 		+ " WHERE id = ? ");  
			
			instrucao.setString(1, produto.getNome());
			instrucao.setInt(2, idProduto);
			instrucao.executeUpdate();

		} catch(SQLException ex) {
			System.err.println(ex.getMessage());		
		} finally {
			ConexaoMySql.encerrarConexao(conexao, instrucao);
		}
	}
	
	// deletar
	public void deletar(int idProduto) {
		Connection conexao = ConexaoMySql.iniciarConexao(); 
		PreparedStatement instrucao = null;
		
		try {
			instrucao = conexao
					 .prepareStatement(" DELETE FROM produto "
					 		+ " WHERE id = ? ");  
			
			instrucao.setInt(1, idProduto);
			instrucao.executeUpdate();

		} catch(SQLException ex) {
			System.err.println(ex.getMessage());		
		} finally {
			ConexaoMySql.encerrarConexao(conexao, instrucao);
		} 
	}
	
	// buscarProduto
	public Produto buscarProduto(int idProduto) {
		Connection conexao = ConexaoMySql.iniciarConexao(); 
		PreparedStatement instrucao = null;
		ResultSet resultado = null;
		Produto produto = new Produto();
		
		try {
			instrucao = conexao
					 .prepareStatement("SELECT * FROM produto "
					 		+ "WHERE id = ? ");
			
			
			instrucao.setInt(1, idProduto);
			
			resultado = instrucao.executeQuery();
			
			while (resultado.next()){ 
		           produto.setId(resultado.getInt("id"));
		           produto.setNome(resultado.getString("nome")); 
		           produto.setPreco(resultado.getDouble("preco")); 
		           produto.setQuantidadeEstoque(resultado.getInt("quantidadeEstoque"));
		    }
			
		} catch(SQLException ex) {
			System.err.println(ex.getMessage());		
		} finally {
			ConexaoMySql.encerrarConexao(conexao, instrucao, resultado);
		}
		 
		return produto;
	}
	
}
