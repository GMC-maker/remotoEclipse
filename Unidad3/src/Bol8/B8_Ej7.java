package Bol8;

public class B8_Ej7 {

	public static void main(String[] args) {
		
		
		if (esPrimo(15)) {
			System.out.println(15 + " es primo");
		} else {
			System.out.println(15 + " no es primo");
		}
	}

	public static boolean esPrimo(int n) {
		boolean esPrim = true;

		if (n <= 1) {
			esPrim = false;
		} else {
			for (int i = 2; i < n; i++) {
				// i son los posibles divisores
				if (n % i == 0) {
					esPrim = false;
				}

			}

		}
		return esPrim;
	}

}
