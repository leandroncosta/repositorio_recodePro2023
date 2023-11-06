package com.leandro.crudmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.leandro.crudmvc.database.DatabaseConnection;
import com.leandro.crudmvc.model.UserModel;


public class UserDAO {
	private static Connection connection = DatabaseConnection.createConnection();
	private static String sql;
	private static ResultSet rset;

	public static void save(UserModel user) {
		sql = "INSERT INTO usuario(id, nome, email, emailSecundario, tipo, imagePath, senha) VALUES (null, ? , ? , ?, ? , ?, ?)";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getEmailSecundario());
			preparedStatement.setString(4, user.getTipo());
			preparedStatement.setString(5, user.getImagePath());
			preparedStatement.setString(6, user.getSenha());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<UserModel> findAll(String search) {
		sql = String.format("SELECT * FROM usuario WHERE nome LIKE '%s%%' OR email LIKE '%s%%'", search, search);
     
		List<UserModel> users = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			rset = statement.executeQuery(sql);

			while (rset.next()) {
				var user = new UserModel();

				user.setId(rset.getLong("id"));
				user.setNome(rset.getString("nome"));
				user.setEmail(rset.getString("email"));
				user.setEmailSecundario(rset.getString("emailSecundario"));
				user.setTipo(rset.getString("tipo"));
				user.setImagePath(rset.getString("imagePath"));
				user.setSenha(rset.getString("senha"));

				users.add(user);
			}

			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static UserModel findById(Long id) {
		sql = String.format("SELECT * FROM usuario where id = %d", id);
		var user = new UserModel();
		
		try (Statement statement = connection.createStatement()) {
			ResultSet rset = statement.executeQuery(sql);
			
			while(rset.next()) {
				user.setId(rset.getLong("id"));
				user.setNome(rset.getString("nome"));
				user.setEmail(rset.getString("email"));
				user.setEmailSecundario(rset.getString("emailSecundario"));
				user.setTipo(rset.getString("tipo"));
				user.setImagePath(rset.getString("imagePath"));
				user.setSenha(rset.getString("senha"));
			}
			
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void update(UserModel user) {
		sql = "UPDATE usuario SET nome = ?, email = ?, emailSecundario = ?, tipo = ? WHERE id  = ? LIMIT 1";

		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getEmailSecundario());
			preparedStatement.setString(4, user.getTipo());
			preparedStatement.setLong(5, user.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteById(Long id) {
		sql = String.format("DELETE FROM usuario WHERE id = %d LIMIT 1", id);

		try (Statement statement = connection.createStatement()) {
			statement.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}