package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculadoraDAO extends BaseDAO {
	public CalculadoraDAO() {
		connect();
	}

	public void insertarCalculo(String tipo,double resultado) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO operacion (tipo, resultado) VALUES (?,?)");
		stmt.setString(1,tipo);
		stmt.setDouble(2, resultado);
		int count = stmt.executeUpdate();
		System.out.println("Inserted Calculo count: " + count);
		stmt.close();
	}
}
