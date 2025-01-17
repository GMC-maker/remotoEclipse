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
				modeloMasVendido(matrizCochesVendidos, tablaConcesionario, tablaModelo, numConcesionario, numModelo);

				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

		} while (option != 6);

	}

	private static void modeloMasVendido(int[][] matrizCochesVendidos, String[] tablaConcesionario,
			String[] tablaModelo, int numConcesionario, int numModelo) {

		for (int i = 0; i < matrizCochesVendidos.length; i++) {
			for (int j = 0; j < matrizCochesVendidos[i].length; j++) {
				//debe comparar las cantidades y devolver la posicion
			}
		}

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
