package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencia.model.Usuario;
import com.agencia.utils.Colors;

public class UsuarioDAO {
	private static Connection conn;
	// private static Connection conn = Database.createConnection();
	private static String sql;
	private static ResultSet rset = null;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}

	public static void create(Usuario usuario) {
		sql = "INSERT INTO usuario(id, email, senha, emailSecundario, tipo) VALUES(null, ?, ?, ?, ?);";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmailSecundario());
			stmt.setString(4, usuario.getTipo());

			stmt.executeUpdate();

			System.out.println(Colors.GREEN + "--Usuario criado com sucesso" + Colors.RESET);
		} catch (SQLException e) {
			System.out.println("--Erro ao criar usuario, Mensagem: " + e.getMessage());
		} finally {

		}
	}

	public static List<Usuario> read(String pesquisa) {
		sql = String.format("SELECT * FROM usuario WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%'", pesquisa, pesquisa);
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Usuario usuario = new Usuario();

				usuario.setId(resultSet.getInt("id"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setEmailSecundario(resultSet.getString("emailSecundario"));
				usuario.setTipo(resultSet.getString("tipo"));

				usuarios.add(usuario);

				// stmt.setTimestamp(3, new
				// java.sql.Timestamp(consulta.getDataConsulta().getTime()));
			}
			System.out.println(Colors.GREEN + "--Resultado retornado com sucesso" + Colors.RESET);
			System.out.println("");
			return usuarios;
		} catch (SQLException e) {
			System.out.println("--Não foi possíevl ler os dados da tabela usuario. Message: " + e.getMessage());
			return null;
		}
	}

	public static void update(Usuario usuario) {
		sql = "UPDATE Usuario SET email = ?, senha = ?, emailSecundario = ?, tipo = ? WHERE id = ? LIMIT 1";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmailSecundario());
			stmt.setString(4, usuario.getTipo());
			stmt.setInt(4, usuario.getId());
			stmt.executeUpdate();

			System.out.printf(Colors.GREEN + "--Usuario atualizada" + Colors.RESET);

		} catch (SQLException e) {
			System.out.printf("--Erro ao atualizar Usuario com o id : %d, Mensagem: %n", usuario.getId(),
					e.getMessage());

		} finally {

		}
	}

	public static void delete(int id) {
		sql = "DELETE FROM usuario WHERE id = ? LIMIT 1";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();

			System.out.println(Colors.GREEN + "--Usuario foi deletado com sucesso." + Colors.RESET);

		} catch (SQLException e) {
			System.out.printf(Colors.RED + "--Erro ao deletar usuario com o id : %d, Mensagem: %n", id,
					e.getMessage() + Colors.RED);

		} finally {

		}
	}

	public static Usuario findBy(int usuarioId) {
		sql = String.format("SELECT * FROM Usuario WHERE id = %d or cpf = %s", usuarioId, usuarioId);
		Usuario usuario = new Usuario();

		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				usuario.setId(resultSet.getInt("id"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setEmailSecundario(resultSet.getString("emailSecundario"));
				usuario.setTipo(resultSet.getString("tipo"));

			}

			System.out.println(Colors.GREEN + "--Encontrado usuario com sucesso" + Colors.RESET);

			return usuario;
		} catch (SQLException e) {
			System.out.println("--Não foi possível encontrar o usuario informado. Message: " + e.getMessage());
			return null;
		}

	}

	public void fecharConexao() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
