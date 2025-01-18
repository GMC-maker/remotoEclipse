package repaso;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class Examen2009 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int option;

		String tablaConcesionario[] = new String[10];
		String tablaModelo[] = new String[5];
		int matrizCochesVendidos[][] = new int[tablaConcesionario.length][tablaModelo.length];

		int numConcesionario = 0;
		int numModelo = 0;

		matriz_fill(matrizCochesVendidos);

		do {
			System.out.println("\n1. Introducir datos de la Venta. " + "\n2. Modelo Más Vendido."
					+ "\n3. Lista de Concesionarios que venden un modelo."
					+ "\n4. Lista de Consesionarios que superan 1 dado en un modelo."
					+ "\n5. Lista de concesionario por debajo de una cantidad en un modelo" + "\n6. FIN");
			option = sc.nextInt();

			String nombreConcesionario;
			String nombreModelo;
			int cantidadVendida;
			int posConcesionario;
			int posModelo;

			switch (option) {
			case 1:

				System.out.println(" Nombre del Concesionario: ");
				nombreConcesionario = sc.next();
				sc.nextLine();

				// buscar si ya existe el nombre. Sino lo guarda en la posicion del contador.

				if (getIndexOf(tablaConcesionario, nombreConcesionario, numConcesionario) != -1) {
					posConcesionario = getIndexOf(tablaConcesionario, nombreConcesionario, numConcesionario);
				} else {
					posConcesionario = numConcesionario;
					tablaConcesionario[numConcesionario++] = nombreConcesionario;

				}

				System.out.println(" Nombre del Modelo: ");
				nombreModelo = sc.next();
				sc.nextLine();

				if (getIndexOf(tablaModelo, nombreModelo, numModelo) != -1) {
					posModelo = getIndexOf(tablaModelo, nombreModelo, numModelo);
				} else {
					posModelo = numModelo;
					tablaModelo[numModelo++] = nombreModelo;

				}

				System.out.println(" Cantidad Vendida: ");
				matrizCochesVendidos[posConcesionario][posModelo] = sc.nextInt();

				mostrarMatriz(matrizCochesVendidos);
				mostrarArray(tablaConcesionario);
				mostrarArray(tablaModelo);

				break;
			case 2:
				modeloMasVendido(matrizCochesVendidos, tablaConcesionario, tablaModelo);

				break;

			case 3:
				
				System.out.println("Dime el Modelo: ");
				nombreModelo = sc.next();
				sc.nextLine();
				
				mostrarTablaPorConcesionario(matrizCochesVendidos,tablaConcesionario,tablaModelo,nombreModelo, posConcesionario,posModelo);
				break;
				
			case 4:
				break;
			case 5:
				break;

			}

		} while (option != 6);

	}

	private static void mostrarTablaPorConcesionario(int[][] matriz, String[] tablaCon, String[] tablaMod, String elemBuscado,int posC, int posM ) {
		
		//busco elemento y que me devuelva el indice? por ejemplo Mercedes.
		System.out.println(" Modelo : " + tablaMod[getIndexOf(tablaMod,elemBuscado, posM)]);
		
		for(int i = 0; i<matriz.length; i++) {
			for (int j = 0; j<matriz[i].length; j++) {
				if()
				System.out.print(" "+ matriz[i][j]);
				
			}
			System.out.println();
		}
			
	}

	private static void modeloMasVendido(int[][] matriz, String[] tablaCon, String[] tablaMod) {

		int maxVendido = Integer.MIN_VALUE;// le doy un valor inicial, siempre y cuando no sea -1; 0 es un dato valido.
		int posModelo = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {

				if (matriz[i][j]!=-1 && matriz[i][j] >= maxVendido) {  //compara las cantidades y devuelve la posicion
					maxVendido = matriz[i][j];
					posModelo = j;
				}
				
			}
		
		}
		System.out.println(" El modelo más Vendido es: "+ tablaMod[posModelo]);
	}

	private static void mostrarArray(String[] tabla) {
		System.out.print("[ ");
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i] + " ");
		}
		System.out.println(" ]");
	}

	private static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.print(" ]");
			System.out.println();
		}

	}

	private static int getIndexOf(String[] tabla, String nom, int numElem) {
		int index = -1;
		for (int i = 0; i < numElem; i++) {
			if (tabla[i] == nom) {
				index = i;
			}
		}
		return index;
	}

	private static void matriz_fill(int[][] matrizIniciar) {

		for (int i = 0; i < matrizIniciar.length; i++) {
			for (int j = 0; j < matrizIniciar[i].length; j++) {
				matrizIniciar[i][j] = -1;
			}
		}

	}

}
