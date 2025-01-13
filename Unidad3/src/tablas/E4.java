package tablas;

import java.util.Scanner;
import java.util.Random;

public class E4 {

	public static void main(String[] args) {

		System.out.println(" La Camara Secreta  ");
		Scanner sc = new Scanner(System.in);
		Random x = new Random();
		int digits;

		System.out.println(" Dime el numero de digitos para la clave: ");
		digits = sc.nextInt();
		int key[] = new int[digits];// tamaño del usuario

		// insertar numeros random entre 1 y 5 en el array
		for (int i = 0; i < digits; i++) {
			key[i] = x.nextInt(5) + 1;
		}

		boolean acierto = false;

		while (!acierto) {

			System.out.println(" Intenta acertar la clave: ");
			String intento;
			intento = sc.next();

			// no necesito decir el tamaño porque lo hace con toCharArray.
			char[] arreglo = intento.toCharArray();// paso el numero del usuario como String a
			// un array de char para que lo compare con la clave random.
			// ahora los comparo, segun ejercicio 1 a uno.

			acierto = comparaIntconChar(key, arreglo, digits);

			if (!acierto) {//si acierto es falso...
				System.out.println(" \t Uppss...intenta de nuevo  ");

			} else {
				System.out.println(" ¡Has acertado!");

			}

		} // while
		sc.close();
	}

	public static boolean comparaIntconChar(int[] arreglo1, char[] arreglo2, int tamanho) {
		boolean esIgual = true;

		for (int i = 0; i < tamanho; i++) {
			if (Character.getNumericValue(arreglo2[i]) == arreglo1[i]) {
				System.out.println(arreglo2[i] + " es igual");
			} else if (Character.getNumericValue(arreglo2[i]) < arreglo1[i]) {
				System.out.println(arreglo2[i] + " es menor");
				esIgual = false;
			} else if (Character.getNumericValue(arreglo2[i]) > arreglo1[i]) {
				System.out.println(arreglo2[i] + " es mayor");
				esIgual = false;
			}

		}
		// si todos los digitos del arreglo1 y arreglo2 son iguales entonces esIgual=
		// true;

		// como es un boolean al no ser todos true, devuelve un false?
		return esIgual;
	}
}
