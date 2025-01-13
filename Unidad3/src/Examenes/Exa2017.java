package Examenes;

import java.util.Scanner;
import java.util.Arrays;

public class Exa2017 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		float lluvias[][] = new float[12][20];
		String[] ciudades = new String[20];
		int ciudadesInsertadas = 0;// contador para los indices
		int option;

		do {
			System.out.println("\n1.-Introducir dato \r\n" + "2.-Listar todos los datos \r\n"
					+ "3. Mostrar la media de lluvias anual en una ciudad dada.\r\n"
					+ "4.Listado alfabetico por ciudades y su cantidad de lluvia anual.\r\n"
					+ "5.Listado(ordenado por cantidad de lluvia)de ciudades y su lluvia en un mes dado.\r\n"
					+ "6. FIN");
			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println(" Dime el nombre de la ciudad");
				String nombreCiudad = sc.next();

				// pide el indice para ver si ya existe
				int posCiudad = getIndexOf(ciudades, ciudades.length, nombreCiudad);
				// posicion String Ciudades
				if (posCiudad == -1) {
					posCiudad = ciudadesInsertadas;
					ciudades[ciudadesInsertadas] = nombreCiudad;
					ciudadesInsertadas++;
				}

				System.out.println("Dime el mes: 1-12 ");
				int mes = sc.nextInt();
				int posMes = mes - 1;

				System.out.println(" Dime la cantidad de lluvia: ");
				float cantLluvia = sc.nextFloat();

				// vamos a usar el indice o posicion de la ciudad.
				lluvias[posMes][posCiudad] = cantLluvia;

				muestraMatriz(lluvias);
				break;
			case 2: // listar todos los datos introducidos alfabeticamente por ciudad
				// creamos una copia del mismo tamaño con Arrays.copyOf no se necesita crear otra tabla.
				String [] copiaCiudades = Arrays.copyOf(ciudades, ciudades.length);
				// devuelve la copia sin nulos
				String [] nuevaTordenada = eliminarNulos(copiaCiudades);
				// los ordena sin nulos
				Arrays.sort(nuevaTordenada);
				// muestra el nuevo Array sin nulos para comprobación mía
				System.out.println();
				muestraTabla(nuevaTordenada);
				
				// necesito obtener el indice de la tabla original para imprimir con sus datos del mes.
				
				for (int i = 0; i<12;i++) {
					System.out.println(" Mes "+(i+1)+" ");
					for(int j = 0; j< lluvias[i].length;j++) {
						if (lluvias[i][j]>0) {
							System.out.print(" ");
						}
						
					}
				}
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}

		} while (option !=6);
		sc.close();
	}

	private static String[] eliminarNulos(String[] tabla) {
		// Contar elementos no nulos
		int count = 0;
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] != null) {
				count++;
			}
		}

		// Crear nueva tabla para los no nulos
		String[] sinNulos = new String[count];
		int index = 0;
		for (int i = 0; i < count; i++) {
			if (tabla[i] != null) {
				sinNulos[index] = tabla[i];
				index++;
			}
		}

		// Mostrar la nueva tabla
		System.out.println("Ciudades sin nulos:");
		for (int i = 0; i < sinNulos.length; i++) {
			System.out.print(sinNulos[i] + " ");
		}

		return sinNulos;
	}

	private static void muestraTabla(String[] tString) {
		for (int i = 0; i < tString.length; i++) {
			System.out.print(" " + tString[i] + " ");
		}
	}

	private static void muestraMatriz(float[][] tablaBi) {
		for (int i = 0; i < tablaBi.length; i++) {
			for (int j = 0; j < tablaBi[i].length; j++) {
				System.out.print("  " + tablaBi[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int getIndexOf(String[] tablaString, int numElementos, String ElemBuscar) {
		int indice = -1;
		// aquí recorre la tabla y busca el elemento que buscamos un String OjO null:
		for (int i = 0; i < numElementos && indice == -1; i++) {
			if (tablaString[i] != null && tablaString[i].equalsIgnoreCase(ElemBuscar)) {
				indice = i;
			}
		}
		return indice;
	}

}
