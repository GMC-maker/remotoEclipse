package tablas;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;

public class E7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		final int numAlumnos = 5;

		int[] trim1 = new int[numAlumnos];
		int[] trim2 = new int[numAlumnos];
		int[] trim3 = new int[numAlumnos];

		int option;
		int pos;

		do {
			System.out
					.println("\n1. Registrar Notas.\n2. Mostrar notas." + "\n3. Nota Media del Grupo en cada trimestre."
							+ "\n4. Media del ALUMNO en la posicion POS =" + "\n5. Salir");
			option = sc.nextInt();

			switch (option) {
			case 1:
				// funcion que registre las notas.
				introducirNotas(sc, trim1, trim2, trim3, numAlumnos);
				break;

			case 2:
				System.out.println("Trimestre I   " + Arrays.toString(trim1));
				System.out.println("Trimestre II  " + Arrays.toString(trim2));
				System.out.println("Trimestre III " + Arrays.toString(trim3));
				System.out.println();
				System.out.println();
				break;

			case 3:
				// funcion que calcule la media del trimestre
				System.out.println("La media Trimestre I es:" + mediaTrimestral(trim1, numAlumnos));
				System.out.println("La media Trimestre II es:" + mediaTrimestral(trim2, numAlumnos));
				System.out.println("La media Trimestre III es:" + mediaTrimestral(trim3, numAlumnos));
				break;

			case 4:
				System.out.println("Indica la posicion del alumno: ");
				pos = sc.nextInt();
				System.out.println("Su media es: " + mediaAlumno(trim1, trim2, trim3, pos));
				break;

			case 5:
				break;
			}

		} while (option != 5);
		sc.close();
	}

	private static void introducirNotas(Scanner sc, int[] t1, int[] t2, int[] t3, int numElem) {

		for (int i = 0; i < numElem; i++) {
			System.out.println(" Notas Trimestre I alumno " + (i + 1));
			t1[i] = sc.nextInt();

			System.out.println(" Notas Trimestre II alumno " + (i + 1));
			t2[i] = sc.nextInt();

			System.out.println(" Notas Trimestre III alumno " + (i + 1));
			t3[i] = sc.nextInt();
		}

	}

	private static float mediaTrimestral(int[] t1, int numElem) {
		float media, suma = 0;
		for (int i = 0; i < numElem; i++) {
			suma += t1[i];
		}
		media = suma / numElem;
		return media;
	}

	private static float mediaAlumno(int[] t1, int[] t2, int[] t3, int indice) {
		float media, suma = 0;

		for (int i = 0; i < indice; i++) {
			suma = t1[i] + t2[i] + t3[i];
		}
		media = suma / 3;
		return media;
	}
}
