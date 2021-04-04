package br.gov.ac.sefaz.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexao {

	private static final String USUARIO_DB = "root";

	private static final String SENHA_DB = "";

	private static final String URL_DB = "jdbc:mysql://localhost:3306/Faculdade";

	public static Connection criarConexao() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL_DB, USUARIO_DB, SENHA_DB);
		System.out.println("Conexao aberta com sucesso!");
		return conn;
	}

	public static void fecharConexao(Connection conn) {
		try {
			conn.close();
			System.out.println("Conexao fechada com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}