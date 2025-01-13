package Recursividad;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Dime un numero: ");
		int numero = sc.nextInt();

		System.out.println("Tu numero contiene " + digitos(numero) + " digitos");

		sc.close();
	}

	public static int digitos(int x) {

		// convertir un numero en String
		String numCadena = Integer.toString(x);
		int totalDigitos = numCadena.length();
		return totalDigitos;
	}

}
