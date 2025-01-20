	package repaso;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class Examen2024_CancionesLikes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int option;
		String[] listaCanciones = new String[10];
		int[][] numeroLikes = new int[12][10];

		matriz_fill(numeroLikes, -1);

		int numCancion = 0;

		do {
			System.out.println(" *********MENU***********");
			System.out.println(" 1.-Introducir dato. " + "\n 2.-Listar todos los datos "
					+ "\n 3.-Mostrar las canciones ordenadas alfabeticamente "
					+ "\n 4.-Mostrar el promedio de likes de un mes concreto "
					+ "\n 5.-Mostrar si hay alguna canción con datos para todos los meses. " + "\n 6.-FIN");
			option = sc.nextInt();

			switch (option) {

			case 1:
				// introducirDatos(numeroLikes, listaCanciones, sc);

				String cancion;
				int mes, numLikes;
				int posActualCancion;

				System.out.println(" Nombre de la canción:  ");
				cancion = sc.next();

				System.out.println(" Indica el mes 1-12:    ");
				mes = sc.nextInt();
				while (mes < 1 && mes > 12) {
					System.out.println("Ups.. Indica el mes 1-12:    ");
					mes = sc.nextInt();
				}

				System.out.println(" número de likes:    ");
				numLikes = sc.nextInt();

				// aqui me devuelve la posicion actual de la cancion.
				if (getIndexOf(listaCanciones, cancion, numCancion) != -1) {
					posActualCancion = getIndexOf(listaCanciones, cancion, numCancion);
				} else {
					// guardo el nombre de la cancion nueva en la lista e indico la posicion
					posActualCancion = numCancion;
					listaCanciones[posActualCancion] = cancion;
					numCancion++;
				}

				// ahora que tengo el indice de la cancion, con el numero de mes ya tengo el 2do
				// indice.
				// mes es i-> fila 0-11, cancion es j->columna 0-9.

				// introduce el dato en la matriz, no la recorro porque guardo un dato a la vez.
				// pero si ya hay likes tengo que sumar, con lo cual ahora si busco si numeroLikes>0 lo suma.
				
				if (numeroLikes[mes-1][posActualCancion]>0) {
					numeroLikes[mes - 1][posActualCancion] += numLikes; // lo que hay mas lo nuevo
				} else {
					numeroLikes[mes - 1][posActualCancion] = numLikes;
				}
				System.out.println("DATOS ALMACENADOS \n");

				break;
			case 2:
				verMatriz(numeroLikes);
				salidaConFormato(numeroLikes, listaCanciones, numCancion);
				break;
			case 3:
				// System.out.println(Arrays.toString(listaCanciones));
				System.out.println();

				System.out.println("Listado Ordenado por Orden A-Z ");
				String[] copiaLista = Arrays.copyOf(listaCanciones, numCancion);
				Arrays.sort(copiaLista);
				System.out.println(Arrays.toString(copiaLista));
				System.out.println();

				break;
			case 4:
				System.out.println("Indica el mes para ver el promedio: ");
				int verMes = sc.nextInt();
				System.out.println(nombreMes(verMes) + " " + promedioMes(numeroLikes, verMes));
				break;
			case 5:

				if (topSong(listaCanciones, numCancion, numeroLikes)) {
					System.out.println("Hay al menos una canción con datos para todos los meses.");
				} else {
					System.out.println("No hay ninguna canción con datos para todos los meses.");
				}
				break;

			}

		}

		while (option != 6);
		sc.close();
	}

	private static boolean topSong(String[] listaC, int numC, int[][] likes) {
		boolean completa = false;
		int hayCompleta = 0;

		// asignar el primer valor de la primera cancion:
		for (int z = 0; z < numC; z++) {
			if (completa) {
				hayCompleta++;
			}
			// buscar si tiene likes todos los meses
			for (int mes = 0; mes < 12; mes++)
				if (likes[mes][z] != -1) {
					completa = true;
				}

		}

		if (hayCompleta > 0) {
			completa = true;
		}

		return completa;

	}

	private static float promedioMes(int[][] nL, int xMes) {
		float media;
		int numElem = 0;
		float sumaFila = 0; // en cada vuelta la variable se inicializa y suma fila a fila.
		for (int j = 0; j < nL[0].length; j++) {
			if (nL[xMes - 1][j] != -1) {
				sumaFila += nL[xMes - 1][j];
				numElem++;
			}
		}

		media = sumaFila / numElem;
		return media;
	}

	private static void salidaConFormato(int[][] t, String[] lista, int numElem) {

		for (int i = 0; i < t.length; i++) {
			System.out.println(nombreMes(i) + ": ");
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] != -1) {
					System.out.print(lista[j] + " --->" + t[i][j] + "likes");
					System.out.println();
				}

			}
		}
	}

	private static String nombreMes(int n) {
		String[] month = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		return month[n];
	}

	private static void verMatriz(int[][] numL) {

		for (int i = 0; i < numL.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < numL[i].length; j++) {
				System.out.print(numL[i][j] + " ");
			}
			System.out.print(" ]");
			System.out.println();
		}
	}

	private static int getIndexOf(String[] list, String cancionBusca, int numCanciones) {
		int index = -1;

		for (int i = 0; i < numCanciones && list[i] != null; i++) {
			if (cancionBusca.equals(list[i])) {
				index = i;
			}
		}

		return index;

	}

	private static void matriz_fill(int[][] matriz, int x) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = x;
			}
		}
	}

}
