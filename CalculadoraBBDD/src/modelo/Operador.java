package modelo;

import java.util.HashMap;
import java.util.Map;

public enum Operador {
	SUMA(1) {
		@Override
		public double operacion(double numero1, double numero2) {
			return numero1 + numero2;
		}
	},
	RESTA(2) {
		@Override
		public double operacion(double numero1, double numero2) {
			return numero2 < 0 ? numero1 + numero2 : numero1 - numero2;
		}
	},
	MULTIPLICACION(3) {
		@Override
		public double operacion(double numero1, double numero2) {
			return numero2 < 0 ? numero1 + numero2 : numero1 * numero2;
		}
	},
	DIVISION(4) {
		@Override
		public double operacion(double numero1, double numero2) {
			return numero2 < 0 ? numero1 + numero2 : numero1 / numero2;
		}
	};

	private int tipo;

	private static Map<Integer, Operador> map = new HashMap<>();

	Operador(int tipo) {
		this.tipo = tipo;
	}

	static {
		for (Operador operador : Operador.values()) {
			map.put(operador.tipo, operador);
		}
	}

	public int getNumeroOperacion() {
		return tipo;
	}

	public static Operador valueOf(int numeroOperador) {
		return (Operador) map.get(numeroOperador);
	}

	public abstract double operacion(double numero1, double numero2);
}
