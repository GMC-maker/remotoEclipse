package Bol8;

import java.util.Scanner;

public class b8_Ej11 {

	public static void main(String[] args) {
		/*
		 * Realizar una función que calcule a elevado a n , donde a es real, y n entero
		 * no negativo. Realizar una versión iterativa y otra recursiva.
		 */
		int numero, potencia;

		Scanner sc = new Scanner(System.in);

		System.out.println(" Dime un número y la potencia: ");
		numero = sc.nextInt();
		potencia = sc.nextInt();
		sc.close();

		System.out.println(" El resultado es iterativo:  " + elevadoIterativo(numero, potencia));
		System.out.println(" El resultado recursivo:  " + elevadoRecursivo(numero, potencia));
	}

	public static int elevadoIterativo(int a, int n) {
		int resultado = 1;
		if (n >= 0) {
			for (int i = 0; i < n; i++) {
				resultado *= a;
			}
		}
		return resultado;
	}

	public static int elevadoRecursivo(int a, int n) {

		if (n == 0) {
			return 1;
		} else {
			return a * elevadoRecursivo(a, n - 1);
		}

	}

}
