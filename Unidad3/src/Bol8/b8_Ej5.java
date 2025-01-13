package Bol8;

import java.util.Scanner;

public class b8_Ej5 {

	public static void main(String[] args) {
		/*  Repetir el ejercicio anterior con una versión que calcule el máximo de 3 números
		 * Piensa un poco, no hagas el algoritmo de comparación de los 3 números desde cero.
		 
		 **/ 
		Scanner sc = new Scanner(System.in);
		
		int num1, num2,num3;
		
		System.out.println("Dime el 3 números: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		 sc.close();
		
		 
		System.out.println(" El Mayor de los 3 es:   "+ b8_Ej4.CompareMax(num1, b8_Ej4.CompareMax(num2, num3)));
		//utilizando el algoritmo de comparar el Maximo de 2, se llama otra vez en el segundo parametro.
		// Asi devuelve un numero máximo de 2 y luego compara el resultado con el que falta.
	}
	
}
