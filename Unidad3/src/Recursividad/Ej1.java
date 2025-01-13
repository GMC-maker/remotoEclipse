package Recursividad;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, b;
		System.out.println("Multiplicacion 2 numeros: ");
		System.out.println("Dime el primer numero: ");
		a = sc.nextInt();
		System.out.println("Dime el segundo numero: ");
		b = sc.nextInt();
		sc.close();

		System.out.println("El resultado de " + a + " x " + b + " = " + multiplicar(a, b));

	}

	private static int multiplicar(int a, int b) {

		int resultado=1;

		if (b == 0) {
			return resultado = 0;
		}

		if (b > 0) {
			resultado = a + multiplicar(a, b - 1);
		}

		return resultado;
	}

}
