package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classe.Livro;

public class LivroDAO {

	public void salvar(Livro a) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("call salvar_livro(?,?,?,?)");

		Connection conexao = ConexaoBanco.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, a.getNome());
		comando.setString(2, a.getAutor());
		comando.setInt(3, a.getPaginas());
		comando.setInt(4, a.getAno_publicacao());

		try {
			comando.executeUpdate();
			System.out.println("Livro Cadastardo!");
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

	public void listar() throws SQLException {
		ResultSet resultado = null;
		StringBuilder sql = new StringBuilder();
		sql.append("call lista_livro()");

		Connection conexao = ConexaoBanco.conectar();

		PreparedStatement comando = conexao.prepareCall(sql.toString());

		resultado = comando.executeQuery();

		try {
			while (resultado.next()) {
				System.out.println("ID: " + resultado.getInt("idinventario") + " Nome: "
						+ resultado.getString("nome_livro") + " Autor: " + resultado.getString("autor_livro")
						+ " Num. Págs: " + resultado.getInt("paginas") + " Ano de Publicação: "
						+ resultado.getInt("ano_publicacao"));
			}
		} catch (SQLException e) {
			System.out.println("ERRO NA CONSULTA");
			e.printStackTrace();
		}

	}

	public void editar(Livro a) throws SQLException {
		StringBuilder sql = new StringBuilder();
		Connection conexao = ConexaoBanco.conectar();
		sql.append("call update_livro(?,?,?,?,?)");

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, a.getId_livro());
		comando.setString(2, a.getNome());
		comando.setString(3, a.getAutor());
		comando.setInt(4, a.getPaginas());
		comando.setInt(5, a.getAno_publicacao());

		try {
			comando.executeUpdate();
			System.out.println("Livro Editado!");
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	
	public void excluir(Livro a) throws SQLException {
		StringBuilder sql = new StringBuilder();
		
		sql.append("call delete_livro(?)");

		Connection conexao = ConexaoBanco.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, a.getId_livro());
		
		try {
			comando.executeUpdate();
			System.out.println("Livro Excluido!");
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	
	public void filtrar_id(Livro a) throws SQLException {
		ResultSet resultado = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("call filtrar_id(?)");

		Connection conexao = ConexaoBanco.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, a.getId_livro());

		resultado = comando.executeQuery();
		
		try {
			while (resultado.next()) {
				System.out.println("ID: " + resultado.getInt("idinventario") + " Nome: "
						+ resultado.getString("nome_livro") + " Autor: " + resultado.getString("autor_livro")
						+ " Num. Págs: " + resultado.getInt("paginas") + " Ano de Publicação: "
						+ resultado.getInt("ano_publicacao"));
			}
		} catch (SQLException e) {
			System.out.println("ERRO NA CONSULTA");
			e.printStackTrace();
		}
	}
	
	public void filtrar_nome(Livro a) throws SQLException {
		ResultSet resultado = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("call filtrar_nome(?)");

		Connection conexao = ConexaoBanco.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, a.getNome());

		resultado = comando.executeQuery();
		
		try {
			while (resultado.next()) {
				System.out.println("ID: " + resultado.getInt("idinventario") + " Nome: "
						+ resultado.getString("nome_livro") + " Autor: " + resultado.getString("autor_livro")
						+ " Num. Págs: " + resultado.getInt("paginas") + " Ano de Publicação: "
						+ resultado.getInt("ano_publicacao"));
			}
		} catch (SQLException e) {
			System.out.println("ERRO NA CONSULTA");
			e.printStackTrace();
		}
	}
}
