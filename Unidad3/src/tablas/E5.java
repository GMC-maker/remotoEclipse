package tablas;

import java.util.Scanner;
import java.util.Arrays;

public class E5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int tabla[] = { 5, 6, 2, 4, 3, 1 };

		// ordenar una tabla
		System.out.println(" \nTabla1 ");
		muestraArray(tabla);

		System.out.println(" \nTabla Ordenada ");
		Arrays.sort(tabla);
		muestraArray(tabla);

		int tabla2[] = { 12, 9, 10, 7, 8, 11 };
		System.out.println(" \nTabla2 ");
		muestraArray(tabla2);

		System.out.println(" \nTabla Ordenada ");
		Arrays.sort(tabla2);
		muestraArray(tabla2);

		// fusionar las 2 tablas en una 3era

		int nuevaTabla[] = fusionTablas(tabla, tabla2);
		System.out.println(" La nueva tabla fusionada es: ");
		muestraArray(nuevaTabla);
		
		sc.close();

	}

	public static void muestraArray(int num[]) {

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	public static int[] fusionTablas(int t1[], int t2[]) {

		int tamanho = t1.length + t2.length;
		int[] tablaFusionada = new int[tamanho];
		// copia la primera tabla, hay que guardar la posicion
		//para iniciar la siguiente copia de datos.
		for (int i = 0; i < t1.length; i++) {
			tablaFusionada[i] = t1[i];
		}
		int ultimaPos=t1.length;
		int j=0;
		for (int i = ultimaPos; i<tamanho; i++) {
			tablaFusionada[i] = t2[j];
			j++;
		}

		return tablaFusionada;
	}

}// main