package tablas2;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class E11_Campeonato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int[] puntuaciones = new int[5];
		int[] exhibicion = new int[3];
		int[] tablaCombinada;
		int[] tablaModificada;

		Arrays.fill(exhibicion, -1);

		guardarPuntuacion(puntuaciones, exhibicion, sc);

		mostrarArray(puntuaciones);
		mostrarArray(exhibicion);

		tablaModificada = borrarVacios(exhibicion);
		mostrarArray(tablaModificada);
		tablaCombinada = combinarArrays(puntuaciones, tablaModificada);

		// ordenar
		Arrays.sort(tablaCombinada);
		mostrarArray(tablaCombinada);
	}

	private static void guardarPuntuacion(int[] tablaP, int[] tablaE, Scanner scan) {
		int dato;

		System.out.println("Indica la puntuaciones finales de los 5 jugadores: ");
		for (int i = 0; i < tablaP.length; i++) {
			tablaP[i] = scan.nextInt();
		}

		System.out.println("Programadores Exihibicion");

		int index = 0;

		dato=0;
		while (dato!=-1 && index < tablaE.length) {
			System.out.println("Introduzca puntuación -1 si no hay intervenciones");
			dato = scan.nextInt();
			if (dato != -1) {
				tablaE[index] = dato;
				index++;
			}
		}

	}

	private static int[] borrarVacios(int[] tabla) {
		int newTamanio = 0;
		int nueva[];
		int pos = 0;

		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] != -1) {
				newTamanio++;
			}
		}

		nueva = new int[newTamanio];

		for (int i = 0; i < tabla.length && tabla[i] != -1; i++) {
			nueva[pos] = tabla[i];
			pos++;

		}

		return nueva;
	}

	private static int[] combinarArrays(int[] tablaP, int[] tablaE) {

		int tablaFinal[];

		tablaFinal = new int[tablaP.length + tablaE.length];

		System.arraycopy(tablaP, 0, tablaFinal, 0, tablaP.length);// copiamos el array1
		System.arraycopy(tablaE, 0, tablaFinal, tablaP.length, tablaE.length); // copiamos el array2

		return tablaFinal;
	}

	private static void mostrarArray(int[] tabla) {
		System.out.println("Puntuaciones por jugador:");
		System.out.print("[ ");
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i] + " ");
		}
		System.out.println("]");
	}

}
