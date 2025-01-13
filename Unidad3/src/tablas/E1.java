package tablas;

import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		/*
		 * : Diseñar un programa que solicite al usuario 5 números decimales. A
		 * continuación, debe mostrar los números en el mismo orden en que se han
		 * introducido
		 */
		Scanner sc = new Scanner(System.in);

		float num[] = new float[5];

		System.out.println(" Dime 5 numeros decimales: ");
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextFloat();
		}
		sc.close();

		System.out.print(" Estos son los número que has introducido: \n ");

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "  ");
		}

	}

}
