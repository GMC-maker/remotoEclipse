package tablas;

import java.util.Scanner;

public class E3 {
	public static void main(String[] args) {
		// E2.pideDatos(n,sc);
		int n;
		
		float sumaPos = 0, sumaNeg = 0;
		int contCero = 0, contPos = 0, contNeg = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("¿Cuantos números quieres ingresar?");
		n = sc.nextInt();

		float tabla[] = new float[n];// float tabla = nuevo Float de X tamaño
		System.out.println(" Ingresa los datos: ");

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = sc.nextFloat();

			if (tabla[i] >= 0) {
				sumaPos += tabla[i];
				contPos++;
				if (tabla[i] == 0) {
					contCero++;
				}
			} else if (tabla[i] < 0) {
				sumaNeg = sumaNeg + tabla[i];
				contNeg++;
			}
		}
		
		sc.close();
		
		System.out.println(" La media de numeros positivos es: " + media(sumaPos, contPos));
		System.out.println(" La media de numeros negativos es: " + media(sumaNeg, contNeg));
		System.out.println(" La cantidad de ceros introducidos es: " + contCero);
	}

	public static float media(float x1, int x2) {

		float resultado;
	
		resultado = x1 / x2;

		return resultado;

	}
}
