package controlador;

import java.sql.SQLException;

import Util.Util;
import modelo.*;
import persistencia.CalculadoraDAO;

public class Controller {
	Calculadora calculadora;
	CalculadoraDAO calculadoraDAO = new CalculadoraDAO();

	public Controller() {

	}

	public int seleccionaOpcion() {
		int opcion = 0;
		do {
			System.out.println("Que operación desea realizar?");
			for (int i = 1; i <= Operador.values().length; i++) {
				System.out.println(i + ". " + Operador.valueOf(i));
			}
			System.out.println("5. Salir");
			opcion = Util.pedirInt("Escoge una opción: ");
			if (opcion < 1 || opcion > 5) {
				System.out.println("Opción erronia!!");
			}
		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	public void assignarTipoOperacion(int tipo) {
		calculadora = new Calculadora(Operador.valueOf(tipo));
	}

	public Operador getOperador() {
		return calculadora.getOperador();
	}

	public double realizarOperacion() {
		return calculadora.realizarOperacion(Util.pedirDouble("Primer número de la operación: "),
				Util.pedirDouble("Segundo número de la operación: "));
	}

	public boolean resultadoValido(double result) {
		return !Double.isInfinite(result) && !Double.isNaN(result);
	}

	public void enviarResultadoBBDD(String tipo, double resultado) throws SQLException {
		calculadoraDAO.insertarCalculo(tipo, resultado);
	}

	public void pintarResultado(double resultado) {
		calculadora.pintarResultado(resultado);
	}
}
