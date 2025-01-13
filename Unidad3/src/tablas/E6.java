package tablas;

import java.util.Arrays;

public class E6 {

	public static void main(String[] args) {
		// implementar una funcion sinRepetidos()
		// prototipo int[]sinRepetido(int[])

		int[] tabla1 = { 1, 2, 3, 4, 5, 6 };
		int[] tabla2 = { 4, 5, 6, 7, 8, 9 };

		System.out.println("\nTabla 1: ");
		muestreArray(tabla1);
		System.out.println("\nTabla 2: ");
		muestreArray(tabla2);
		// ahora juntamos ambas tablas
		
		int nuevaTabla[] = fusionTablas(tabla1, tabla2);
		System.out.println("\nTabla fusionada: ");
		muestreArray(nuevaTabla);
		// eliminar los repetidos
		System.out.println("\nSin repetidos: ");
		int tablaSinRepetidos[] = sinRepetidos(nuevaTabla);
		muestreArray(tablaSinRepetidos);
	}

	private static int[] sinRepetidos(int[] tabla) {
		int[] temporal = new int[tabla.length];
		int indiceTemp = 0;

		// vamos a recorrer la tabla para ver si existe en la otra.
		for (int i = 0; i < tabla.length; i++) {
			boolean encontrado = false;

			// verificamos si existe
			for (int j = 0; j < indiceTemp; j++) {
				// condicion
				if (tabla[i] == temporal[j]) {
					encontrado = true;
				}
			}

			if (!encontrado) {
				temporal[indiceTemp] = tabla[i];
				indiceTemp++;
			}

		} // cierre for1.
		
		// Crea un nuevo arreglo del tamaño exacto
        int[] tablaFinal = new int[indiceTemp];
        for (int i = 0; i < indiceTemp; i++) {
            tablaFinal[i] = temporal[i];
        }
		return tablaFinal;
	}// cierre metodo

	private static int[] fusionTablas(int[] tabla1, int[] tabla2) {
		int nuevaLongitud = tabla1.length + tabla2.length;
		int tablaFusionada[] = new int[nuevaLongitud];

		System.arraycopy(tabla1, 0, tablaFusionada, 0, tabla1.length);
		System.arraycopy(tabla2, 0, tablaFusionada, tabla1.length, tabla2.length);
		return tablaFusionada;
	}

	private static void muestreArray(int[] tabla) {
		System.out.println(Arrays.toString(tabla));
	}

}
