package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agencia.database.Database;
import com.agencia.model.Cliente;
import com.agencia.utils.Colors;

public class ClienteDAO {

	private static Connection conn;
	// private static Connection conn = Database.createConnection();
	private static String sql;
	private static ResultSet rset = null;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}

	public static void create(Cliente cliente) {
		sql = "INSERT INTO cliente(id, nome, email, telefone, passaporte, cpf ) VALUES(null, ?, ?, ?, ?, ?);";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getPassaporte());
			stmt.setString(5, cliente.getCpf());

			stmt.executeUpdate();

			System.out.println(Colors.GREEN + "\n [log] Cliente criado com sucesso." + " \n" + Colors.RESET);
		} catch (SQLException e) {
			System.out.println("\n [log] Erro ao criar cliente, Mensagem: \n" + e.getMessage());
		} finally {

		}
	}

	public static List<Cliente> read(String pesquisa) {
		sql = String.format("SELECT * FROM cliente WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%'", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();

		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setPassaporte(resultSet.getString("passaporte"));
				cliente.setCpf(resultSet.getString("cpf"));

				clientes.add(cliente);
			}

			System.out.println(Colors.GREEN + "\n [log] Resultado retornado com sucesso." + Colors.RESET);
			System.out.println("");
			return clientes;
		} catch (SQLException e) {
			System.out
					.println("\n [log] Não foi possíevl ler os dados da tabela cliente. Message: \n" + e.getMessage());
			return null;
		}
	}

	public static void update(Cliente cliente) {
		sql = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, passaporte = ?, cpf = ? WHERE id = ? LIMIT 1";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCpf());
			stmt.setInt(6, cliente.getId());

			stmt.executeUpdate();

			System.out.printf(Colors.GREEN + "\n [log] Cliente atualizado. \n" + Colors.RESET);

		} catch (SQLException e) {
			System.out.printf(Colors.RED + "%n [log] Erro ao atualizar cliente com o id: %d, Mensagem: %s %n", cliente.getId(),
					e.getMessage());

		} finally {

		}
	}

	public static void delete(int id) {
		sql = "DELETE FROM cliente WHERE id = ? LIMIT 1";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();

			System.out.println(Colors.GREEN + "\n [log] Cliente foi deletado com sucesso. \n" + Colors.RESET);

		} catch (SQLException e) {
			System.out.printf(Colors.RED + "%n [log] Erro ao deletar cliente com o id : %d, Mensagem: %n", id,
					e.getMessage() + Colors.RED);

		} finally {

		}
	}

	public static Cliente findBy(int clienteId) {
		sql = String.format("SELECT * FROM cliente WHERE id = %d or cpf = %s", clienteId, clienteId);
		Cliente cliente = new Cliente();

		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setPassaporte(resultSet.getString("passaporte"));
				cliente.setCpf(resultSet.getString("cpf"));
			}

			System.out.println(Colors.GREEN + "\n [log] Encontrado cliente com sucesso. \n" + Colors.RESET);

			return cliente;
		} catch (SQLException e) {
			System.out.println(
					"\n [log] Não foi possível encontrar o cliente informado. Message: " + e.getMessage() + ". \n");
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