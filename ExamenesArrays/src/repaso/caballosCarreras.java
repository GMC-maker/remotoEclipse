package repaso;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class caballosCarreras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		int opcion;

		String[] tCaballos = new String[15];
		String[] tCiudades = new String[10];

		double[][] matrizVelocidad = new double[10][15];
		int posCiudad = 0;
		int numCaballos = 0;

		do {

			System.out.println(" \n 1. Introducir caballo, carrera, ciudad y velocidad."
					+ "\n 2. Listar todos los datos" + "\n 3. Indicar en que ciudad ha habido mas carreras"
					+ "\n 4. Listado de carreras junto con el caballo ha quedado en última posición. "
					+ "\n 5. Listado -ordenado por caballo- de velocidades medias" + "\n 6. FIN");

			opcion = sc.nextInt();

			String nombreCaballo = " ";
			String nombreCiudad = " ";
			int carrera;

			switch (opcion) {
			case 1:
				System.out.println(" Nombre del Caballo: ");
				nombreCaballo = sc.next();
				sc.nextLine();
				System.out.println(" No. de Carrera: ");
				carrera = sc.nextInt()-1;
				posCiudad = carrera;
				// si la carrera no se ha registrado antes, se pedira la ciudad.

				if (tCiudades[posCiudad] == null) {
					System.out.println(" Dime el nombre de la ciudad: ");
					nombreCiudad = sc.next();
					tCiudades[posCiudad] = nombreCiudad;
				}

				int posActual = getIndexOf(tCaballos, nombreCaballo); // obtener la posicion de Caballo para poder
																		// guardar datos en la matriz.
				if (posActual == -1) {
					posActual = numCaballos;
					tCaballos[posActual] = nombreCaballo;
					numCaballos++;
				}

				// ahora guardaremos la velocidad media.
				System.out.println("Dime la velocidad media del caballo " + nombreCaballo);
				matrizVelocidad[carrera][posActual] = sc.nextDouble();

				break;

			case 2:
				System.out.println(Arrays.toString(tCaballos));
				System.out.println(Arrays.toString(tCiudades));
				verMatriz(matrizVelocidad);
				verMatrizF(matrizVelocidad, tCaballos, tCiudades);

				break;
			case 3:
				ciudadMaxCarrera(tCiudades);
				break;
			case 4:
				ultimoCaballo(matrizVelocidad, tCaballos);

				break;
			case 5:
				// listado Ordenado por Caballo
				porCaballo(tCaballos, numCaballos, matrizVelocidad);

				break;
			}

		} while (opcion != 6);

	}

	private static void porCaballo(String[] tCabal, int posCabal, double[][] matrizV) {

		String[] copiaCabal = Arrays.copyOf(tCabal, posCabal);
		Arrays.sort(copiaCabal);

		for (int j = 0; j < posCabal; j++) {
			for (int i = 0; i < matrizV[j].length; i++) {

			}
		}

	}

	private static void ultimoCaballo(double[][] matriz, String[] tCabal) {

		for (int i = 0; i < matriz.length; i++) {

			String caballoMasLento = " ";
			double minVelocidad = Double.MAX_VALUE;

			for (int j = 0; j < matriz[i].length; j++) {// recorro la matriz de velocidades
				if (matriz[i][j] < minVelocidad && matriz[i][j] != 0) {
					minVelocidad = matriz[i][j];
					caballoMasLento = tCabal[j];// asignamos valores
				}
			}

			if (!caballoMasLento.equals(" ")) { // ignoramos los que esten vacios
				System.out.println(" Carrera " + (i + 1) + "-> " + caballoMasLento);
			}
		}

	}

	private static void ciudadMaxCarrera(String[] tabla) {
		int max = Integer.MIN_VALUE;

		String ciudadMax = " ";
		String nomReferencia = " ";

		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] != null) {
				nomReferencia = tabla[i]; // asignamos el primer valor
				int contadorCiudad = 0; // iniciamos un contador para ver cuantas veces se repite cada ciudad

				for (int j = 0; j < tabla.length; j++) { // iniciamos recorrido por la tabla
					if (tabla[j] != null && nomReferencia.equals(tabla[j])) { // compara con el nombre en la referencia
						contadorCiudad++; // suma
					}
				}

				if (contadorCiudad > max) { // si el contador es mayor, guarda el nombre de la ciudad.
					max = contadorCiudad;
					ciudadMax = nomReferencia;
				}
			}

		}
		System.out.println(" La Ciudad con más Carreras " + ciudadMax);
	}

	private static void verMatrizF(double[][] matriz, String[] tCaballos, String[] tCiudades) {

		for (int i = 0; i < tCaballos.length; i++) {
			if (tCaballos[i] != null) {
				System.out.println("Caballo: " + tCaballos[i]);

				for (int j = 0; j < 10; j++) {
					if (matriz[j][i] > 0) { //de j i porque estoy saltando hacia abajo en las lineas
						System.out.println("Carrera " + j + "(" + tCiudades[j] + "): " + matriz[j][i]);
					}
				}

			}

		}
	}

	private static void verMatriz(double[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.print(" ]\n");
		}

	}

	private static int getIndexOf(String[] tablaString, String nomBuscado) {
		int index = -1;

		for (int i = 0; i < tablaString.length; i++) {
			if (tablaString[i] == nomBuscado && tablaString[i] != null) {
				index = i;
			}
		}

		return index;
	}
}
