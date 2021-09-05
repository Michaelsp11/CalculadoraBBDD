package calculadoraTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import modelo.Calculadora;
import modelo.Operador;

public class CalculadoraTest {
	Calculadora calculadora; 
	List<Double> listaReal = new ArrayList<Double>();
	List<Double> listaEsperada = new ArrayList<Double>();

	@Before
	public void setListas() throws Exception {
		// setear lista real
		calculadora = new Calculadora(Operador.SUMA);
		listaReal.add(calculadora.realizarOperacion(2, 1));
		listaReal.add(calculadora.realizarOperacion(-1, 2));
		listaReal.add(calculadora.realizarOperacion(2, -1));
		calculadora = new Calculadora(Operador.RESTA);
		listaReal.add(calculadora.realizarOperacion(2, 1));
		listaReal.add(calculadora.realizarOperacion(1, 2));
		listaReal.add(calculadora.realizarOperacion(2, -1));
		calculadora = new Calculadora(Operador.MULTIPLICACION);
		listaReal.add(calculadora.realizarOperacion(2, 1));
		listaReal.add(calculadora.realizarOperacion(-1, 2));
		listaReal.add(calculadora.realizarOperacion(1, -2));
		calculadora = new Calculadora(Operador.DIVISION);
		listaReal.add(calculadora.realizarOperacion(2, 1));
		listaReal.add(calculadora.realizarOperacion(-2, 1));
		listaReal.add(calculadora.realizarOperacion(2, -1));
		listaReal.add(calculadora.realizarOperacion(0, 2));
		listaReal.add(calculadora.realizarOperacion(2, 0));
		// setear lista esperada
		listaEsperada.add(3.0);
		listaEsperada.add(1.0);
		listaEsperada.add(1.0);
		listaEsperada.add(1.0);
		listaEsperada.add(-1.0);
		listaEsperada.add(3.0);
		listaEsperada.add(2.0);
		listaEsperada.add(-2.0);
		listaEsperada.add(-2.0);
		listaEsperada.add(2.0);
		listaEsperada.add(2.0);
		listaEsperada.add(2.0);
		listaEsperada.add(0.0);
		listaEsperada.add(0.0);
	}

	@Test
	public void testOperaciones() {
		try {
		assertEquals(listaReal, listaEsperada);
		}catch(AssertionError e) {
			throw new AssertionError("El resultado de la lista, es diferente del esperado. " + e);
		}
	}

}
