package repaso;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class lluvias {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int opcion;
		String[] tCiudades = new String[20];// no se van a manejar mas de 20 ciudades.
		String nomCiudad;
		double[][] lluvias = new double[12][20];
		int contCiudades = 0;
		int posActualCiudad;

		do {// menu
			System.out.print("\n1. Introducir dato." + "\n2. Listar todos los datos. "
					+ "\n3. Mostrar la media de lluvias anual en una ciudad dada"
					+ "\n4. Listado alfabético por ciudades y su cantidad de lluvia anual."
					+ "\n5. Listado (ordenado por cantidad de lluvia) de ciudades y su lluvia en un mes dado.");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:

				System.out.println(" Nombre de la Ciudad: ");
				nomCiudad = sc.next();

				System.out.println(" Dime el mes en numeros [1 al 12]: ");
				int mes = sc.nextInt();

				System.out.println("Cantidad de lluvia en litros");
				double litros = sc.nextDouble();

				posActualCiudad = getIndexOf(tCiudades, nomCiudad);
				if (posActualCiudad == -1) {
					posActualCiudad = contCiudades;
					tCiudades[contCiudades] = nomCiudad;
					contCiudades++;
				}

				// ya tenemos el indice de la Ciudad ->j y del mes -> i;
				lluvias[mes - 1][posActualCiudad] = litros;

				break;
			case 2:
				//mostrarArray(tCiudades);
				//verMatriz(lluvias);
				verOrdenadoPorCiudad(tCiudades, contCiudades, lluvias);
				break;
			case 3:
				System.out.println("Dime la Ciudad: ");
				nomCiudad = sc.next();
				
				posActualCiudad = getIndexOf(tCiudades,nomCiudad);
				double suma = 0; 
				int contElem = 0;
				
				for(int i = 0; i<lluvias.length; i++) {
					if(lluvias[i][posActualCiudad]>0) {
					suma += lluvias[i][posActualCiudad];
					contElem ++; 
					}
				}
				
				System.out.println(" Para " + nomCiudad + " Media de lluvias anual: "+ (suma/contElem));

				break;
			case 4:
				ciudadLluviaAnual(tCiudades, contCiudades, lluvias);
				break;
			case 5:
				//listado ordenado creciente por cantidad de lluvia.
				System.out.println(" Para el mes: (1-12)");
				mes = sc.nextInt()-1;
				
				verOrdenCreciente(mes, tCiudades, lluvias, contCiudades);
				
				break;

			}

		} while (opcion != 6);

	}
	private static void verOrdenCreciente(int numMes, String[] ciudades, double[][] lluvias, int contCiudades) {
	    // Crear una lista para almacenar ciudades y lluvias
	    String[] ciudadesMes = new String[contCiudades];
	    double[] lluviasMes = new double[contCiudades];

	    // Rellenar las listas con las lluvias del mes especificado
	    for (int j = 0; j < contCiudades; j++) {
	        ciudadesMes[j] = ciudades[j];
	        lluviasMes[j] = lluvias[numMes][j];
	    }

	    // Ordenar las ciudades por lluvias  
	    for (int i = 0; i < lluviasMes.length - 1; i++) {
	        for (int j = i + 1; j < lluviasMes.length; j++) {
	            if (lluviasMes[i] > lluviasMes[j]) {
	                // Intercambiar lluvias
	                double tempLluvia = lluviasMes[i];
	                lluviasMes[i] = lluviasMes[j];
	                lluviasMes[j] = tempLluvia;

	                // Intercambiar ciudades
	                String tempCiudad = ciudadesMes[i];
	                ciudadesMes[i] = ciudadesMes[j];
	                ciudadesMes[j] = tempCiudad;
	            }
	        }
	    }

	    // Imprimir el resultado
	    System.out.println("Ciudades ordenadas por lluvias en el mes " + (numMes + 1) + ":");
	    for (int i = 0; i < ciudadesMes.length; i++) {
	        if (ciudadesMes[i] != null && lluviasMes[i] > 0) {
	            System.out.println(ciudadesMes[i] + " lluvias en el mes: " + lluviasMes[i]);
	        }
	    }
	}
	private static void ciudadLluviaAnual(String[] tablaC, int contC, double[][] matrizLluvias) {
		String[] copiaCiudadesOrdenado = Arrays.copyOf(tablaC, contC);
		Arrays.sort(copiaCiudadesOrdenado);
		

		for (int j = 0; j < contC; j++) { //para iterar sobre Ciudades
			System.out.print(copiaCiudadesOrdenado[j]);
			double suma = 0;
			int indiceOrdenado = getIndexOf(tablaC, copiaCiudadesOrdenado[j]);
			
			for (int i = 0; i < matrizLluvias.length; i++) {
				if (matrizLluvias[i][indiceOrdenado] > 0) {
					suma +=matrizLluvias[i][indiceOrdenado];
				}
			}
			System.out.print("\tlitros:  " + suma +"\n");
		}
	}

	private static void verOrdenadoPorCiudad(String[] tabla, int contador, double[][] matrizLluvias) {
		String[] copiaCiudadesOrdenado = Arrays.copyOf(tabla, contador);
		Arrays.sort(copiaCiudadesOrdenado);

		for (int j = 0; j < contador; j++) {
			System.out.println(copiaCiudadesOrdenado[j]);

			int indiceOrdenado = getIndexOf(tabla, copiaCiudadesOrdenado[j]);
			for (int i = 0; i < matrizLluvias.length; i++) {
				if (matrizLluvias[i][indiceOrdenado] > 0) {
					System.out.println(" mes: " + (i + 1) + "\t litros:  " + matrizLluvias[i][indiceOrdenado]);
				}

			}

		}

	}

	private static void mostrarMatriz(double[][] matrizString) {

		for (int i = 0; i < matrizString.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matrizString[i].length; j++) {
				System.out.print(matrizString[i][j] + "   ");
			}
			System.out.print(" ]");
			System.out.println();
		}
	}

	private static void mostrarArray(String[] tablaString) {
		System.out.print("[  ");
		for (int i = 0; i < tablaString.length; i++) {
			System.out.print(tablaString[i] + " ");
		}
		System.out.println(" ]");
	}

	private static int getIndexOf(String[] tablaString, String nomBuscado) {
		int index = -1;

		for (int i = 0; i < tablaString.length; i++) {
			if (nomBuscado.equals(tablaString[i]) && tablaString[i] != null) {
				index = i;
			}
		}

		return index;
	}
}
