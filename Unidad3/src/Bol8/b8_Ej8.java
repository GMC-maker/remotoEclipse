package Bol8;

public class b8_Ej8 {

	public static void main(String[] args) {

		System.out.println(divisoresPrimos(15));
		
		System.out.println(divisoresPrimos(83));
		
		
	}

	public static int divisoresPrimos(int n) {
		int contadorDivPrimos = 0;

		for (int i = 1; i <= n; i++) {
			// i son los posibles divisores
			if (n % i == 0 && B8_Ej7.esPrimo(i)) {
				contadorDivPrimos++;
			}
		}

		return contadorDivPrimos;
	}

}
