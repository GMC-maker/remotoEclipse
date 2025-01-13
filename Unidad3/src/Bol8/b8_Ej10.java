package Bol8;

public class b8_Ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 220, num2 = 284;
		System.out.println(" los numeros " + num1 + " y " + num2 + " ¿son amigos?" + sonAmigos(num1, num2));
	}

	public static boolean sonAmigos(int n1, int n2) {
		boolean amicci = false;

		amicci = (sumaDivisores(n1) == n2 && sumaDivisores(n2) == n1);

		return amicci;
	}

	public static int sumaDivisores(int n) {
		int sumaD = 0;
		// obtener la suma de sus divisores, ¿como?

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sumaD += i; // suma el divisor del numero
			}

		}
		return sumaD;
	}

}
