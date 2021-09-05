package vista;

import java.sql.SQLException;
import controlador.Controller;

public class Principal {

	/**
	 * @param args the command line arguments
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Controller ctl = new Controller();
		System.out.println("Bienvenido!");
		int opcion = 0;
		do {
			opcion = ctl.seleccionaOpcion();
			if (opcion < 5) {
				ctl.assignarTipoOperacion(opcion);
				double result = ctl.realizarOperacion();
				if(ctl.resultadoValido(result)) {
					ctl.enviarResultadoBBDD(ctl.getOperador().toString(),result);
					ctl.pintarResultado(result);
				}else {
					System.out.println("Operación no válida!");
				}
			}
		} while (opcion < 5);
		System.out.println("Hasta pronto!");
	}
}
