package Examenes2;

import java.util.Arrays;
import java.util.Scanner;

public class Votos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] datos = new int[20][30];
		String[] partidosPoliticos = new String[20];
		String[] localidades = new String[30];
		int selector;
		int numPartido = 0;
		int numLocalidad = 0;

		do {
			System.out.println("Menú");
			System.out.println("1 -Introducir votos obtenidos en una ciudad por un partido");
			System.out.println("2 -Listado alfabético por partidos de todos los datos introducidos");
			System.out.println("3 -Listado de mejores resultados de cada partido");
			System.out.println("4 -Listado de localidades de menor a mayor participacion");
			System.out.println("5 -Porcentajes de votos obtenidos por cada partido en la comunidad");
			System.out.println("6 -Fin");
			selector = sc.nextInt();
			switch (selector) {
			case 1:
				System.out.println("Localidad");
				String localidad = sc.next();
				System.out.println("Partido politico");
				String partidoPolitico = sc.next();
				int indiceLocalidad = 0;
				int indicePartido = 0;
				if (getIndexOf(localidades, localidad) >= 0) {
					indiceLocalidad = getIndexOf(localidades, localidad);
				} else {
					localidades[numLocalidad] = localidad;
					indiceLocalidad = numLocalidad;
					numLocalidad++;
				}
				if (getIndexOf(partidosPoliticos, partidoPolitico) >= 0) {
					indicePartido = getIndexOf(partidosPoliticos, partidoPolitico);
				} else {
					partidosPoliticos[numPartido] = partidoPolitico;
					indicePartido = numPartido;
					numPartido++;
				}
				System.out.println("Votos");
				datos[indicePartido][indiceLocalidad] = sc.nextInt();
				indiceLocalidad = 0;
				indicePartido = 0;
				break;
			case 2:
				String[] partidoOrdenado1 = getSortedTabla(partidosPoliticos, numPartido);
				String[] localidadOrdenado = getSortedTabla(localidades, numLocalidad);
				for (int i = 0; i < partidoOrdenado1.length; i++) {
					for (int j = 0; j < partidosPoliticos.length && partidosPoliticos[j] != null; j++) {
						if (partidosPoliticos[j].equals(partidoOrdenado1[i])) {
							System.out.println("Partido " + partidoOrdenado1[i]);
							for (int z = 0; z < localidadOrdenado.length; z++) {
								for (int k = 0; k < localidades.length && localidades[k] != null; k++) {
									if (localidadOrdenado[z].equals(localidades[k]) && datos[j][k] > 0) {
										System.out.println("   " + localidades[k] + ":" + datos[j][k]);
									}
								}
							}
						}
					}
				}
				break;
			case 3:
				int numMaxVotos = Integer.MIN_VALUE;
				String localMaxVoto = null;
				String[] partidoOrdenado2 = getSortedTabla(partidosPoliticos, numPartido);
				for (int i = 0; i < partidoOrdenado2.length; i++) {
					for (int j = 0; j < partidosPoliticos.length && partidosPoliticos[j] != null; j++) {
						if (partidosPoliticos[j].equals(partidoOrdenado2[i])) {
							for (int k = 0; k < localidades.length && localidades[k] != null; k++) {
								if (datos[j][k] > numMaxVotos) {
									numMaxVotos = datos[j][k];
									localMaxVoto = localidades[k];
								}
							}
							numMaxVotos = Integer.MIN_VALUE;
							System.out.println(
									"El partido " + partidosPoliticos[j] + " ha obtenido mas votos en " + localMaxVoto);
						}
					}
				}
				break;
			case 4:
				// total votos de cada localidad ordenados de menor a mayor número de votos
				int[] sumaVotosLocalidades = new int[numLocalidad];
				String[] localidadesOrdenadasVotos = new String[numLocalidad];
				int[] sumaVotosLocalidadesOrdenadas = new int[numLocalidad];
				for (int j = 0; j < numLocalidad; j++) {
					for (int i = 0; i < numPartido; i++) {
						sumaVotosLocalidades[j] += datos[i][j];
					}
					// recorro array sumaVotosLocalidadesOrdenadas para ver en qué posición debe ir
					// este total de votaciones
					int pos = Arrays.binarySearch(Arrays.copyOf(sumaVotosLocalidadesOrdenadas, j),
							sumaVotosLocalidades[j]);
					int indiceInsercion = -pos - 1;
					if (pos > 0) {
						indiceInsercion = pos;
					}
					insertarEnPos(sumaVotosLocalidadesOrdenadas, j, indiceInsercion, sumaVotosLocalidades[j]);
					insertarEnPos(localidadesOrdenadasVotos, j, indiceInsercion, localidades[j]);
				}
				for (int j = 0; j < numLocalidad; j++) {
					System.out.println("En la ciudad de " + localidadesOrdenadasVotos[j]
							+ " el número de votos ha sido de: " + sumaVotosLocalidadesOrdenadas[j]);
				}

				break;
			case 5:

				// Suma total Votos
				int totalVotos = sumarTabla(datos, numPartido, numLocalidad);

				for (int i = 0; i < numPartido; i++) {

					System.out.println("Partido: " + partidosPoliticos[i] + ". Porcentaje de votos: "
							+ (float) sumarFila(datos, numLocalidad, i) * 100 / totalVotos + "%");

				}
				break;
			
			}

		} while (selector != 6);

		sc.close();

	}

	private static int sumarTabla(int tablaDatos[][], int filas, int columnas) {
		int totalTabla = 0;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				totalTabla += tablaDatos[i][j];
			}
		}
		return totalTabla;
	}

	private static int sumarFila(int tablaDatos[][], int totalFilas, int numFila) {
		int totalFila = 0;
		for (int i = 0; i < totalFilas; i++) {
			totalFila = totalFila + tablaDatos[numFila][i];
		}
		return totalFila;
	}

	// Buscar si esta un texto en el indice.
	public static int getIndexOf(String tabla[], String texto) {
		int indice = -1;
		for (int i = 0; i < tabla.length && tabla[i] != null; i++) {
			if (tabla[i].equals(texto)) {
				indice = i;
			}
		}
		return indice;
	}

	// Ordenar la tabla String
	public static String[] getSortedTabla(String tabla[], int num) {
		String[] copyTabla = Arrays.copyOf(tabla, num);
		Arrays.sort(copyTabla);
		return copyTabla;
	}

	private static void insertarEnPos(String[] arrayOrdenado, int numElem, int indiceInsercion, String elemAInsertar) {
		for (int i = numElem; i > indiceInsercion; i--) {
			arrayOrdenado[i] = arrayOrdenado[i - 1];
		}
		arrayOrdenado[indiceInsercion] = elemAInsertar;

	}

	private static void insertarEnPos(int[] arrayOrdenado, int numElem, int indiceInsercion, int elemAInsertar) {
		for (int i = numElem; i > indiceInsercion; i--) {
			arrayOrdenado[i] = arrayOrdenado[i - 1];
		}
		arrayOrdenado[indiceInsercion] = elemAInsertar;
	}

}
