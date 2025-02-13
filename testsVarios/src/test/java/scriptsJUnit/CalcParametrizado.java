package scriptsJUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalcParametrizado {

	@ParameterizedTest
	@CsvSource({ "10, 5, 15", // num1, num2, resultado esperado
			"0, 0, 0", "-1, 1, 0", "100, 50, 150", "-10, -5, -15" })
	void testSumaParametrized(int num1, int num2, int expectedResult) {
		Calculadora calc = new Calculadora(num1, num2);
		assertEquals(expectedResult, calc.suma(),
				"La suma de " + num1 + " y " + num2 + " debería ser " + expectedResult);
	}

	@ParameterizedTest
	@CsvSource({ "10, 5, 5", // num1, num2, resultado esperado
			"0, 0, 0", "-1, 1, -2", "100, 50, 50", "-10, -5, -5" })
	void testRestaParametrized(int num1, int num2, int expectedResult) {
		Calculadora calc = new Calculadora(num1, num2);
		assertEquals(expectedResult, calc.resta(),
				"La resta de " + num1 + " y " + num2 + " debería ser " + expectedResult);
	}

	@ParameterizedTest
    @CsvSource({
        "10, 5, 50",    // num1, num2, resultado esperado
        "0, 0, 0",
        "-1, 1, -1",
        "100, 50, 5000",
        "-10, -5, 50"
    })
    void testMultiplicaParametrized(int num1, int num2, int expectedResult) {
        Calculadora calc = new Calculadora(num1, num2);
        assertEquals(expectedResult, calc.multiplica(), "La multiplicación de " + num1 + " y " + num2 + " debería ser " + expectedResult);
    }
}
