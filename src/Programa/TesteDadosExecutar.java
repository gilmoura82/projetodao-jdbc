package Programa;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class TesteDadosExecutar {

	public static void main(String[] args) {

		/*
		 * // Recuperação de dados no banco de dados Connection conn = null; // Conexão
		 * Statement consulta = null; // Consulta ResultSet resultado = null; //
		 * Resultado
		 * 
		 * try { conn = DB.getConnection();
		 * 
		 * consulta = conn.createStatement();
		 * 
		 * resultado = consulta.executeQuery("select * from departamento");
		 * 
		 * while (resultado.next()) { System.out.println("Código: " +
		 * resultado.getInt("Id") + " || " + "Nome: " + resultado.getString("Nome")); }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally {
		 * DB.closeResultSet(resultado); DB.closeStatement(consulta);
		 * DB.closeConnection(); }
		 * 
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * // Inserir dados Connection conn = null;
		 * 
		 * PreparedStatement st = null; try { conn = DB.getConnection();
		 * 
		 * st = conn.prepareStatement("INSERT INTO VENDEDOR " +
		 * " (nome, email, datanascimento, salariobase, departamentoid) " + "VALUES " +
		 * "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		 * 
		 * st.setString(1, "Roberto Santos"); st.setString(2, "rsantos@email.com");
		 * st.setDate(3, new java.sql.Date(sdf.parse("22/10/1985").getTime()));
		 * st.setDouble(4, 3000.0); st.setInt(5, 2);
		 * 
		 * int linhasAfetadas = st.executeUpdate();
		 * 
		 * if (linhasAfetadas > 0) { ResultSet rs = st.getGeneratedKeys(); while
		 * (rs.next()) { int id = rs.getInt(1); System.out.println("Pronto! Id = " +
		 * id); } } else { System.out.println("Nenhuma linha foi alterada"); }
		 * 
		 * //System.out.println("Pronto! Linhas Afetadas: " + linhasAfetadas); } catch
		 * (SQLException e) { e.printStackTrace(); } catch (ParseException e) {
		 * e.printStackTrace(); } finally { DB.closeStatement(st); DB.closeConnection();
		 * }
		 * 
		 * 
		 * // Atualizar dados Connection conn = null; PreparedStatement st = null; try {
		 * conn = DB.getConnection();
		 * 
		 * st = conn.prepareStatement( "UPDATE vendedor " +
		 * "set salariobase = salariobase + ?  " + "WHERE " + "(departamentoid = ?)");
		 * 
		 * st.setDouble(1, 200.0); st.setInt(2, 2);
		 * 
		 * int linhasAfetadas = st.executeUpdate();
		 * 
		 * System.out.println("Feito! linhas afetadas " + linhasAfetadas ); } catch
		 * (SQLException e) { e.printStackTrace(); } finally { DB.closeStatement(st);
		 * DB.closeConnection(); }
		 * 
		 * // Deletar dados
		 * 
		 * Connection conn = null; PreparedStatement st = null; try { conn =
		 * DB.getConnection();
		 * 
		 * st = conn.prepareStatement( "DELETE from vendedor " + "WHERE " + "id = ?");
		 * 
		 * st.setInt(1, 7);
		 * 
		 * int linhasAfetadas = st.executeUpdate();
		 * 
		 * System.out.println("Feito! linhas afetadas " + linhasAfetadas); } catch
		 * (SQLException e) { throw new DbIntegrityException(e.getMessage()); } finally
		 * { DB.closeStatement(st); DB.closeConnection(); }
		 
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);

			st = conn.createStatement();

			int linhas1 = st.executeUpdate("update vendedor set salariobase = 2090 " + "where departamentoid = 1 ");
			
			// Erro Falso
			/*int x = 1;
			if (x < 2) {
				throw new SQLException("Teste Erro falso");
			}
			
			
			int linhas2 = st.executeUpdate("update vendedor set salariobase = 3100 " + "where departamentoid = 2 ");

			conn.commit(); // confirmação do fim da transação

			System.out.println("Linhas 1: " + linhas1);
			System.out.println("Linhas 2: " + linhas2);

		} catch (SQLException e) {
			try {
				conn.rollback(); // retorna ao estado original do banco
				throw new DbException("Transação retornou (rollback) motivo: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro ao tentar voltar a transação, causa: " + e.getMessage());
			}
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		*/
	}

}
