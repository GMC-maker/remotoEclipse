package scripts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma() {
		Calculadora c = new Calculadora(20,10);
		Assertions.assertEquals(30,c.suma(),0);
		
	}

	@Test
	void testResta() {
		Calculadora c = new Calculadora(20,10);
		Assertions.assertEquals(10,c.resta(),0);
		
	}

	@Test
	void testMultiplica() {
		Calculadora c = new Calculadora(20,10);
		Assertions.assertEquals(200,c.multiplica(),0);
		
	}

	@Test
	void testDivide() {
		Calculadora c = new Calculadora(20,10);
		Assertions.assertEquals(20,c.divide(),0);
		
	}

}
