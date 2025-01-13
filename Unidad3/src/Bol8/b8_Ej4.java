package Bol8;

import java.util.Scanner;

public class b8_Ej4 {
	/*
	 * Diseñar una función que reciba como parámetros dos números enteros y que
	 * devuelva el mayor de los dos.
	 */

	public static void main(String[] args) {
		int num1, num2;

		Scanner sc = new Scanner(System.in);
		System.out.println(" Dime dos numeros: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		sc.close();

		System.out.println("El Mayor es: " + CompareMax(num1, num2));
	}

	public static Integer CompareMax(int n1, int n2) {
		int elMayorEs;

		if (n1 > n2) {
			elMayorEs = n1;
		} else {
			elMayorEs = n2;
		}

		return elMayorEs;
	}

}
