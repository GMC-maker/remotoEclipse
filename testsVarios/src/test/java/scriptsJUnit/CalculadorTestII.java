package scriptsJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadorTestII {

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
		Assertions.assertEquals(2,c.divide(),0);
		
	}

    @Test
    void testValorAbsoluto() {
        // Caso donde num1 > num2
        Calculadora c1 = new Calculadora(20, 10);
        Assertions.assertEquals(10, c1.valorAbsoluto());

        // Caso donde num1 < num2
        Calculadora c2 = new Calculadora(10, 20);
        Assertions.assertEquals(10, c2.valorAbsoluto());
    }

    @Test
    void testRestaPositiva() {
        // Caso donde num1 > num2
        Calculadora c1 = new Calculadora(20, 10);
        Assertions.assertTrue(c1.restaPositiva());

        // Caso donde num1 < num2
        Calculadora c2 = new Calculadora(10, 20);
        Assertions.assertFalse(c2.restaPositiva());

        // Caso donde num1 = num2
        Calculadora c3 = new Calculadora(10, 10);
        Assertions.assertTrue(c3.restaPositiva());
    }

    @Test
    void testDivideAcepta0() {
        // Caso de división normal
        Calculadora c1 = new Calculadora(20, 10);
        Assertions.assertNotNull(c1.divideAcepta0());
        Assertions.assertEquals(2, c1.divideAcepta0());

        // Caso de división por cero
        Calculadora c2 = new Calculadora(20, 0);
        Assertions.assertNull(c2.divideAcepta0());
    }

}
