package Bol8;

import java.util.Scanner;

public class b8_Ej5 {

	public static void main(String[] args) {
		/*  Repetir el ejercicio anterior con una versi�n que calcule el m�ximo de 3 n�meros
		 * Piensa un poco, no hagas el algoritmo de comparaci�n de los 3 n�meros desde cero.
		 
		 **/ 
		Scanner sc = new Scanner(System.in);
		
		int num1, num2,num3;
		
		System.out.println("Dime el 3 n�meros: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		 sc.close();
		
		 
		System.out.println(" El Mayor de los 3 es:   "+ b8_Ej4.CompareMax(num1, b8_Ej4.CompareMax(num2, num3)));
		//utilizando el algoritmo de comparar el Maximo de 2, se llama otra vez en el segundo parametro.
		// Asi devuelve un numero m�ximo de 2 y luego compara el resultado con el que falta.
	}
	
}
