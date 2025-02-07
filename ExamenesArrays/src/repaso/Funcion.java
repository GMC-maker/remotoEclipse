package repaso;

import java.util.Arrays;

public class Funcion {
	private static final String MAX_PARTIDOS = null;

	// Econtrar el indice en una tabla en el que está el elemento si no -1
	private static int getIndexOf(String[] matriz, int numElementos, String nombre) {
		int indiceBuscado = -1;
		for (int i = 0; i < numElementos && indiceBuscado == -1; i++) {
			if (matriz[i].equals(nombre)) {
				indiceBuscado = i;
			}
		}
		return indiceBuscado;

	} // Función para insertar elemento en una tabla y aumentar el contador del
		// elemento

	private static int inserta(String nombre, int numElements, String[] t) {
		t[numElements] = nombre;
		return numElements++;

	}// funcion para contar los elementos relaes dentro de una tabla sin tener que
		// crear un contador en el codigo

	public static int getCount(String[] partidos) {
		int count = 0;
		for (String partido : partidos) {
			if (partido != null) { // Solo cuenta los partidos que no son null
				count++;
			}
		}
		return count; // Devuelve la cantidad de partidos almacenados

	}
	
	// funcion para copiar tabla con el tamaño declarado y depues ordenar con el
		// tamaño real

//	private static void listarDatosPorPartidos(String[] partidos, String[] localidades, int[][] votos) {
//		String[] partidosOrdenados = Arrays.copyOf(partidos, partidos.length);// puedo poner partidos,
//																				// getCount(partidos))si quiero copiar
//																				// solo los valores reales en la nueva
//																				// tabla
//		Arrays.sort(partidosOrdenados, 0, getCount(partidos));
//		for (String partido : partidosOrdenados) {
//			if (partido != null) {
//				int indicePartido = getIndex(partidos, partido, MAX_PARTIDOS);
//				System.out.println("\nPartido: " + partido);
//				for (int i = 0; i < localidades.length; i++) {
//					if (localidades[i] != null && votos[i][indicePartido] != -1) {
//						System.out.println("  Localidad: " + localidades[i] + " - Votos: " + votos[i][indicePartido]);
//					}
//				}
//			}
//		}
//	}

	// funcion para copiar tabla con el tamaño real y luego ordenar
	private static void listarDatosPorPartidos2(String[] partidos, String[] localidades, int[][] votos) {
		// Crear una copia del array partidos solo con los valores reales (no nulos)
		String[] partidosOrdenados = Arrays.copyOf(partidos, getCount(partidos));

		// Ordenar la copia alfabéticamente
		Arrays.sort(partidosOrdenados);

		// Recorrer los partidos ordenados y mostrar la información correspondiente
		for (String partido : partidosOrdenados) {
			if (partido != null) { // Precaución en caso de valores inesperados
				int indicePartido = getIndex(partidos, partido, partidos.length); // Obtener el índice real del partido
				System.out.println("\nPartido: " + partido);
				for (int i = 0; i < localidades.length; i++) {
					if (localidades[i] != null && votos[i][indicePartido] != -1) {
						System.out.println("  Localidad: " + localidades[i] + " - Votos: " + votos[i][indicePartido]);
					}
				}
			}
		}
	}

//busca el nombre o elemento si lo encuentra te devuelve el indice donde está, si no está lo inserta en la siguiente disponible
	private static int getIndex(String[] array, String value, int length) {
		for (int i = 0; i < length; i++) {
			if (array[i] == null) {
				array[i] = value;
				return i;
			}
			if (array[i].equals(value)) {
				return i;
			}
		}
		throw new IllegalStateException("Se alcanzó el límite máximo.");
	}
//REllenar matriz -1
private static void fill(float[][] matriz, int valor) {
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[0].length; j++) {
			matriz[i][j] = valor;
		}
	}

}
//Ordenar la tabla String
	public static String[] getSortedTabla(String tabla[], int num) {
		String[] copyTabla = Arrays.copyOf(tabla, num);
		Arrays.sort(copyTabla);
		return copyTabla;
	}
	//imprimir matriz
	public static void imprimirMatriz(int[][] matriz) {
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            System.out.print(matriz[i][j] + " ");
	        }
	        System.out.println(); // Salto de línea al terminar una fila
	    }
	}
	//encontrar el maximo
	public static int encontrarMaximo(int[][] matriz) {
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            if (matriz[i][j] > max) {
	                max = matriz[i][j];
	            }
	        }
	    }
	    return max;
	}
	//encontrar valor minimo
	public static int encontrarMinimo(int[][] matriz) {
	    int min = Integer.MAX_VALUE;
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[i].length; j++) {
	            if (matriz[i][j] < min) {
	                min = matriz[i][j];
	            }
	        }
	    }
	    return min;
	}
//ordena fila
	public static void ordenarFilas(int[][] matriz) {
	    for (int i = 0; i < matriz.length; i++) {
	        Arrays.sort(matriz[i]); // Ordena cada fila de menor a mayor
	    }
	}
	//imprimir array
	public static void imprimirArray(String tabla []) {
		for (int i =0; i<tabla.length;i++) {
			System.out.println(tabla[i]);
		}
	}
	
	
	
}


