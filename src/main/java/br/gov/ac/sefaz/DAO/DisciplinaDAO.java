package br.gov.ac.sefaz.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.gov.ac.sefaz.entidade.Disciplina;
import br.gov.ac.sefaz.modelo.Connexao;

public class DisciplinaDAO {
	private static Connection conn;

	public static void create(Disciplina disciplina) {
		try {
			conn = Connexao.criarConexao();

			String sql = "INSERT INTO `faculdade`.`disciplina` ( `NOME`, `DESCRICAO`)\r\n" + 
					"VALUES\r\n" + 
					"  ( ?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, disciplina.getNome());
			ps.setString(2, disciplina.getDescricao());

			ps.execute();

			System.out.println("Disciplina Inserido com Sucesso => [" + disciplina.toString() + "]");

		} catch (Exception e) {
			System.out.println("Error na Inserção do Disciplina => " + disciplina.getNome() + ":");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}
	}

	public static List<Disciplina> read() {

		List<Disciplina> disciplinas = new ArrayList<Disciplina>();

		try {
			conn = Connexao.criarConexao();

			String sql = "SELECT\r\n" + 
					"  `ID`,\r\n" + 
					"  `NOME`,\r\n" + 
					"  `DESCRICAO`\r\n" + 
					"FROM\r\n" + 
					"  `faculdade`.`disciplina`\r\n" + 
					"LIMIT 0, 1000;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Disciplina disciplina = new Disciplina();

				disciplina.setDescricao(rs.getString("descricao"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setId(rs.getInt("id"));

				disciplinas.add(disciplina);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na Busca de Disciplina:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

		return disciplinas;

	}

	public static Disciplina readOne(int id) {

		Disciplina disciplina = new Disciplina();

		try {
			conn = Connexao.criarConexao();

			String sql = "SELECT\r\n" + 
					"  `ID`,\r\n" + 
					"  `NOME`,\r\n" + 
					"  `DESCRICAO`\r\n" + 
					"FROM\r\n" + 
					"  `faculdade`.`disciplina`\r\n" + 
					"where id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				disciplina.setDescricao(rs.getString("descricao"));
				disciplina.setNome(rs.getString("nome"));
				disciplina.setId(rs.getInt("id"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro na Busca de Disciplina:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

		return disciplina;

	}

	public static void update(Disciplina disciplina) {

		try {

			conn = Connexao.criarConexao();

			String sql = "UPDATE\r\n" + 
					"  `faculdade`.`disciplina`\r\n" + 
					"SET\r\n" + 
					"  `NOME` = ?,\r\n" + 
					"  `DESCRICAO` = ?\r\n" + 
					"WHERE `ID` = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, disciplina.getNome());
			ps.setString(2, disciplina.getDescricao());
			ps.setInt(3, disciplina.getId());

			ps.executeUpdate();

			System.out.println("Update Disciplina com Sucesso => [" + disciplina.toString() + "]");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Update Disciplina => [" + disciplina.toString() + "]:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

	}

	public static void delete(int id) {

		try {
			conn = Connexao.criarConexao();

			String sql = "DELETE\r\n" + 
					"FROM\r\n" + 
					"  `faculdade`.`disciplina`\r\n" + 
					"WHERE `ID` = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			
			ps.execute();
			
			System.out.println("Delete Disciplina com Sucesso => id = " + id);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Delete Disciplina:");
			e.printStackTrace();
		} finally {
			Connexao.fecharConexao(conn);
		}

	}

	public static void main(String[] args) {
		
		delete(2);
		
	}
}
