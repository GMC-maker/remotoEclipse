package tablas2;

import java.util.Scanner;
import java.util.Locale;


public class E12_MatrizMagica {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		int tablaCuadrada[][] = new int[4][4];

		introducirDatos(tablaCuadrada, sc);
		mostrarTabla(tablaCuadrada);
		
		if(matrizMagica(tablaCuadrada)) {
			System.out.println(" La Matriz es Mágica");
		} else {
			System.out.println("La Matriz no es Mágica");
		}
		sc.close();
	}

	private static void mostrarTabla(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println(" ]");
		}
	}

	private static void introducirDatos(int[][] tablaMatriz, Scanner scan) {
		System.out.println(" Introduce los datos de tu matriz: ");
		for (int i = 0; i < tablaMatriz.length; i++) {
			for (int j = 0; j < tablaMatriz[i].length; j++) {
				System.out.print("[" + i + "]" + "[" + j + "]");
				tablaMatriz[i][j] = scan.nextInt();
			}
		}

	}

	private static boolean matrizMagica(int[][] tablaMatriz) {
		int sumaReferencia = 0;//para guardar un valor y comparar con el resto.

		// guardamos el valor de la primera fila como referencia.

		for (int j = 0; j < tablaMatriz.length; j++) {
			sumaReferencia += tablaMatriz[0][j];
		}

		for (int i = 0; i < tablaMatriz.length; i++) {
			int sumaFila = 0; // en cada vuelta la variable se inicializa y suma fila a fila.
			for (int j = 0; j < tablaMatriz[i].length; j++) {
				sumaFila += tablaMatriz[i][j];
				
			}
			
			if (sumaReferencia != sumaFila) {
				return false;
			}
			
		}

		for (int j = 0; j < tablaMatriz.length; j++) {
			int sumaCol = 0;
			for (int i = 0; i < tablaMatriz[j].length; i++) {
				sumaCol += tablaMatriz[j][i];
				
			}
			
			if (sumaReferencia != sumaCol) {
				return false;
			}
			
		}
		return true;

	}

}
