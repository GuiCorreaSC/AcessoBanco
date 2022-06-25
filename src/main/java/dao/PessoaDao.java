package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.Pessoa;

public class PessoaDao {
	
	private String driver="org.postgresql.Driver";
	private String user="postgres";
	private String senha="admin";
	private String url="jdbc:postgresql://localhost:5432/postgres";
	private String sqlSelect="SELECT * FROM pessoas order by id";
	private String sqlInsert="insert into pessoas "
			+ "(id, nome, endereco, cidade, profissao) "
			+ "values (?, ?, ?, ?, ?)";
	
	public void inserir (Pessoa p1) {
		try {
			Class.forName(driver);
			Connection con = (Connection) DriverManager.getConnection(url, user, senha);
			PreparedStatement stmt = con.prepareStatement(sqlInsert);
			
			stmt.setInt    (1, p1.getId());
			stmt.setString (2, p1.getNome());
			stmt.setString (3, p1.getEndereco());
			stmt.setString (4, p1.getCidade());
			stmt.setString (5, p1.getProfissao());
			
			stmt.execute();
			
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}	
	}
	
	public void alterar(Pessoa p) {
		
	}
	
	public void excluir(Integer id) {
		
	}

}
