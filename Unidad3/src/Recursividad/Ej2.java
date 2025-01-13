package Recursividad;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a, b;
		System.out.println("Multiplicacion 2 numeros: ");
		System.out.println("Dime el primer numero: ");
		a = sc.nextInt();
		System.out.println("Dime el segundo numero: ");
		b = sc.nextInt();
		sc.close();

		System.out.println("El resultado de " + a + " x " + b + " = " + multiplicarIterativo(a, b));

	}

	private static int multiplicarIterativo(int a, int b) {
		int resultado=0;
		for (int i = 0; i < b; i++) {
			resultado += a;
		}

		return resultado;
	}

}
