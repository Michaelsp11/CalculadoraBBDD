package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	static final String url = "jdbc:mysql://localhost:3306/";
	static final String dbName = "calculadora"; // Nombre de nuestra BBDD
	static final String driver = "com.mysql.cj.jdbc.Driver";
	static final String userName = "root";
	static final String password = "P@ssw0rd";

	protected static Connection conn = null;
	// private static DataSource ds;

	public static void connect() {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName, userName, password);
			} catch (SQLException | ClassNotFoundException ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}

	}

	public static Connection getConn() {
		return conn;
	}

	public static void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		conn = null;
	}

}
