package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// Criar conexão
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String dburl = props.getProperty("dburl");
				conn = DriverManager.getConnection(dburl, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

		return conn;
	}

	// Fechar conexão

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// Carregar dados da conexão
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}
	
	public static void closeStatement(Statement consulta) {
		if (consulta != null) {
			try {
				consulta.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());			}
		}
	}
	
	public static void closeResultSet(ResultSet resultado) {
		if (resultado != null) {
			try {
				resultado.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());			}
		}
	}

}
