package modelo;

public class Calculadora {
	private Operador operador;

	public Calculadora(Operador operador) {
		this.operador = operador;
	}

	public double realizarOperacion(double numero1, double numero2) {
		return operador.operacion(numero1, numero2);
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Operador getOperador() {
		return this.operador;
	}
	
	public void pintarResultado(double resultado) {
		System.out.printf("El resultado final de la operación es %.2f\n", resultado);
	}
}
