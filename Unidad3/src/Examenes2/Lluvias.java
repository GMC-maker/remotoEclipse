package Examenes2;

import java.util.Arrays;
import java.util.Scanner;

public class Lluvias {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float[][] datos = new float[20][12];
		String[] ciudad = new String[20];
		int numCiudad = 0;
		fillTwoDimensionalTable(datos, -1);
		int selector;
		do {
			System.out.println("");
			System.out.println("Menú");
			System.out.println("1 -Introducir dato.");
			System.out.println("2 -Listar todos los datos.");
			System.out.println("3 -Mostrar la media de lluvias anual en una cidad dada.");
			System.out.println("4 -Listado alfabético por ciudades y su cantidad de lluvia anual");
			System.out.println("5 -Listado (ordenado por cantidad de lluvia) de ciudades y su lluvia en un mes dado");
			System.out.println("6 -Fin");
			selector = sc.nextInt();
			switch (selector) {
			case 1:
				System.out.println("Ciudad");
				String ciudadLluvia = sc.next();
				int indiceCiudadLluvia = 0;
				if (getIndexOf(ciudad, ciudadLluvia) >= 0) {
					indiceCiudadLluvia = getIndexOf(ciudad, ciudadLluvia);
				} else {
					ciudad[numCiudad] = ciudadLluvia;
					indiceCiudadLluvia = numCiudad;
					numCiudad++;
				}
				System.out.println("Mes");
				int mesLluvia = sc.nextInt();
				System.out.println("Cantidad lluvia");
				datos[indiceCiudadLluvia][mesLluvia - 1] = sc.nextFloat();
				indiceCiudadLluvia = 0;
				break;
			case 2:
				String[] tablaOrdCiudad = getSoftedTabla(ciudad, numCiudad);
				for (int i = 0; i < tablaOrdCiudad.length; i++) {
					// A continuacion buscamos los valores obtenidos anteriormente en la tabla sin
					// ordenar para obtener las filas (1).
					for (int j = 0; j < ciudad.length && ciudad[j] != null; j++) {
						// Ya tenemos el indice del equipo que nos interesa.
						if (tablaOrdCiudad[i].equals(ciudad[j])) {
							System.out.println("");
							System.out.println(ciudad[j] + ":");
							System.out.println("");
							for (int k = 0; k < datos[0].length; k++) {
								if (datos[j][k] != -1) {
									System.out.println("mes: " + (k + 1) + "   litros " + datos[j][k]);
								}
							}
						}
					}
				}
				break;
			case 3:
				System.out.println("Ciudad");
				String ciudadMedia = sc.next();
				float totalLluviasCiudad = 0;
				int numMesLluvia = 0;
				int indiceCiudadMedia = -1;
				for (int i = 0; i < ciudad.length && ciudad[i] != null; i++) {
					if (ciudad[i].equals(ciudadMedia)) {
						indiceCiudadMedia = i;
						for (int j = 0; j < datos[0].length; j++) {
							if (datos[i][j] >= 0) {
								totalLluviasCiudad += datos[i][j];
								numMesLluvia++;
							}
						}
					}
				}
				System.out.println("Para " + ciudad[indiceCiudadMedia]);
				System.out.println("La media anual es " + totalLluviasCiudad / numMesLluvia + " litros.");
				break;
			case 4:
				String[] tablaOrdCiudad2 = getSoftedTabla(ciudad, numCiudad);
				float totalLluviaAnual = 0;
				for (int i = 0; i < tablaOrdCiudad2.length; i++) {
					for (int j = 0; j < ciudad.length && ciudad[j] != null; j++) {
						if (tablaOrdCiudad2[i].equals(ciudad[j])) {
							for (int k = 0; k < datos[0].length; k++) {
								if (datos[j][k] > -1) {
									totalLluviaAnual += datos[j][k];
								}
							}
							System.out.println(ciudad[j] + "  litros......: " + totalLluviaAnual);
						}
					}
					totalLluviaAnual = 0;
				}
				break;
			case 5:
				System.out.print("Mes:");
				int mesUsu = sc.nextInt() - 1;

				// Creamos un contador para obtener la longitud de la tabla de los datos
				int contadorDatos = 0;
				for (int j = 0; j < datos[0].length; j++) {
					if (datos[j][mesUsu] > -1) {
						contadorDatos++;
					}
				}
				// Ahora procedemos a crear la tabla para los datos de lluvias y otra para sus
				// respectivas ciudades
				int numElementosInsertados = 0;
				float[] lluviasMes = new float[contadorDatos];
				String[] ciudadesLluviasMes = new String[contadorDatos];
				// utilizamos un for() para introducir los datos en las tablas anteriores,
				// contando a su vez los elementos insertados
				for (int j = 0; j < datos[0].length; j++) {
					if (datos[j][mesUsu] > -1) {
						lluviasMes[numElementosInsertados] = datos[j][mesUsu];
						ciudadesLluviasMes[numElementosInsertados] = ciudad[j];
						numElementosInsertados++;
					}
				}
				// Creamos las tablas en las cuales vamos a ordenar los datos
				float[] lluviasMesOrdenada = new float[numElementosInsertados];
				String[] ciudadesLluviasOrdenadas = new String[numElementosInsertados];
				for (int i = 0; i < lluviasMes.length; i++) {
					// BinarySearch te devulve un numero positivo si encuentra el valor
					// Si no encuentra un valor te devuelve el lugar que correspode a ese lugar con
					// un numero negativo
					int pos = Arrays.binarySearch(Arrays.copyOf(lluviasMesOrdenada, i), lluviasMes[i]);
					// Cuando te devuelve un numero negativo...
					if (pos < 0) {
						// Utilizamos la siguiente expresion para localizar el indice donde introducir
						// dicho valor.
						pos = -pos - 1;
					}
					//
					insertarEnPosicion(lluviasMesOrdenada, i, lluviasMes[i], pos, ciudadesLluviasOrdenadas,
							ciudadesLluviasMes[i]);
				}
				for (int i = 0; i < lluviasMesOrdenada.length; i++) {
					System.out.println(ciudadesLluviasOrdenadas[i] + ": " + lluviasMesOrdenada[i]);
				}
				break;

			case 6:
				System.out.println("Hasta otra");
				break;
			}
		} while (selector != 6);
		sc.close();

	}

	// Ordenar una tabla:
	// (*1) arraysDondeInsertar, es la tabla donde queremos insertar el valor
	// (*1.2).
	//
	// numElementos, es la longitud de la tabla donde lo insertaresmos
	//
	// (*1.2) float elemAInsertar, es el valor que vamos a insertar en (*1).
	//
	// pos, es la posicion donde introducir el dato.
	//
	// (*2) arrayDondeInsertarStrings, es la tabla donde queremos insertar el valor
	// (*2.1).
	//
	// (*2.1) String cadenaAInsertar, es el valor que vamos a insertar en (*2).
	private static void insertarEnPosicion(float[] arrayDondeInsertar, int numElementos, float elemAInsertar, int pos,
			String[] arrayDondeInsertarStrings, String cadenaAInsertar) {
		// muevo
		for (int i = numElementos; i > pos; i--) {
			arrayDondeInsertar[i] = arrayDondeInsertar[i - 1];
			arrayDondeInsertarStrings[i] = arrayDondeInsertarStrings[i - 1];
		}

		arrayDondeInsertar[pos] = elemAInsertar;
		arrayDondeInsertarStrings[pos] = cadenaAInsertar;
	}

	// Rellenar la tabla de un caracter dado
	public static void fillTwoDimensionalTable(float tabla[][], float caracterNumero) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				tabla[i][j] = caracterNumero;
			}
		}
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

	public static String[] getSoftedTabla(String tabla[], int num) {
		String[] copyTabla = Arrays.copyOf(tabla, num);
		Arrays.sort(copyTabla);
		return copyTabla;
	}
}
