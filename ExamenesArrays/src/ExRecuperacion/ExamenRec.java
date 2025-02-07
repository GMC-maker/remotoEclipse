package ExRecuperacion;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;

public class ExamenRec {

	public static void main(String[] args) {
		// primero pide, luego el menu y en la opcion 1 tambien pide.
		Scanner sc = new Scanner(System.in);
		// sc.useLocale(Locale.US);// para punto del archivo ahk.

		String nombreCurso;
		int numSesiones;

		System.out.println(" Nombre del Curso: ");
		nombreCurso = sc.next();

		System.out.println(" Numero de Sesiones: ");
		numSesiones = sc.nextInt();

		int opcion;
		String[] nomUsuarios = new String[20];
		int[] tiempoSesion = new int[numSesiones];
		double[][] notasUsuarios = new double[numSesiones][20];
		int contUsuariosRegistrados = 0;

		for (int s = 0; s < tiempoSesion.length; s++) {
			System.out.println(" Tiempo de las Sesion" + s);
			tiempoSesion[s] = sc.nextInt();// aqui registra los tiempos.
		}

		do {
			System.out.println("\n1. Registrar la calificación de un usuario en cierta sesión de aprendizaje."
					+ "\n2. Listar todas las sesiones, junto con su duracion y notas."
					+ "\n3. Indicar cuál es la sesion en la que se ha sacado mejor nota media"
					+ "\n4. Mostrar los usuarios que han estudiado solo una sesion."
					+ "\n5. Listar usuarios (ordenados alfabéticamente)." + "\n6. SALIR");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				String nombreUser;
				int numSesionAreg;
				int posActualU;

				System.out.println(" Nombre del Usuario");
				nombreUser = sc.next();

				posActualU = getIndexOf(nomUsuarios, nombreUser);// getIndex para buscar si ya existe
				if (posActualU == -1) {
					posActualU = contUsuariosRegistrados;
					nomUsuarios[posActualU] = nombreUser;
					contUsuariosRegistrados++;
				} // else es posActual q ya tengo.

				System.out.println(" Indique la Sesion del 0 al" + numSesiones);
				numSesionAreg = sc.nextInt(); // no necesito GetIndex porque me lo da el usuario

				// luego guarda el dato en los indices sesion i(V),usuario j(H).
				System.out.println(" Calificacion");
				notasUsuarios[numSesionAreg][posActualU] = sc.nextDouble();

				break;
			case 2:
				// mostrarArray(nomUsuarios);
				// mostrarMatriz(notasUsuarios);

				mostrarDatos(nombreCurso, tiempoSesion, nomUsuarios, contUsuariosRegistrados, notasUsuarios);

				break;
			case 3:

				System.out.println("La sesion con mejor media es: "
						+ mejorNotaMedia(nomUsuarios, contUsuariosRegistrados, notasUsuarios));

				break;
			case 4:
				System.out.println("Usuarios que han estudiado solo una sesion: ");
				unaSesion(notasUsuarios, nomUsuarios, contUsuariosRegistrados);

				break;
			case 5:
				// listar los usuarios con el total de minutos dedicados
				tiempoDedicado(notasUsuarios, nomUsuarios, contUsuariosRegistrados, tiempoSesion);
				break;

			}

		} while (opcion != 6);
		sc.close();
	}

	private static void tiempoDedicado(double[][] notasUsu, String[] nomUsu, int contUsuReg, int[] tiempos) {

		// ordenar el array de nombres
		String[] copiaNombres = Arrays.copyOf(nomUsu, contUsuReg);
		Arrays.sort(copiaNombres);

		for (int j = 0; j < contUsuReg; j++) { // me posiciono en el usuario.
			int suma = 0; // para acumular sumatoria
			int posTemp = getIndexOf(nomUsu, copiaNombres[j]);

			for (int i = 0; i < notasUsu.length; i++) {
				if (notasUsu[i][j] > 0) {

					suma += tiempos[i];
				}

			}
			System.out.println(nomUsu[j] + suma);

		}

	}

	private static void unaSesion(double[][] notasUsu, String[] nomUsu, int contUsuReg) {

		for (int j = 0; j < contUsuReg; j++) { // me posiciono en el usuario.
			int contador = 0; // para contar mas que 1
			for (int i = 0; i < notasUsu.length; i++) {
				if (notasUsu[i][j] > 0) {
					contador++;
				}

			}
			if (contador == 1) {
				System.out.println(" " + nomUsu[j]);
			}
		}

	}

	private static double mejorNotaMedia(String[] nomUsu, int contUsuReg, double[][] notasUsu) {
		double media;
		double mediaMayor = Double.MIN_VALUE;
		int sesionMayor = -1;

		for (int i = 0; i < notasUsu.length; i++) { // Me posiciono en la Sesion
			double suma = 0;
			int contador = 0;

			for (int j = 0; j < contUsuReg; j++) {
				if (notasUsu[i][j] > 0) {
					suma += notasUsu[i][j];
					contador++;
				}
			}

			media = suma / contador; // System.out.print(media);

			if (media > mediaMayor) {
				mediaMayor = media;
				sesionMayor = i;
			}
		}

		return sesionMayor;
	}

	private static void mostrarDatos(String nombreC, int[] tiempoSes, String[] nomUsu, int contUsuR,
			double[][] notasUsu) {

		System.out.println(" Curso: " + nombreC);
		System.out.println(" Listado de Sesiones: ");

		for (int i = 0; i < tiempoSes.length; i++) {
			System.out.println(" Sesion " + i + "  " + tiempoSes[i] + "minutos.");

			for (int j = 0; j < contUsuR; j++) {
				if (notasUsu[i][j] > 0) {
					System.out.println("\t -Usuario: " + nomUsu[j] + " Nota " + notasUsu[i][j]);
				}
			}

		}

	}

	private static int getIndexOf(String[] tablaNombres, String nombres) {
		int index = -1;

		for (int i = 0; i < tablaNombres.length; i++) {
			if (nombres.equals(tablaNombres[i])) {
				index = i;
			}
		}

		return index;
	}
}

/*
 * private static void mostrarArray(String[] tablaString) {
 * System.out.print("[  "); for (int i = 0; i < tablaString.length; i++) {
 * System.out.print(tablaString[i] + " "); } System.out.println(" ]"); }
 * 
 * private static void mostrarMatriz(double[][] matrizString) {
 * 
 * for (int i = 0; i < matrizString.length; i++) { System.out.print("[ "); for
 * (int j = 0; j < matrizString[i].length; j++) {
 * System.out.print(matrizString[i][j] + "   "); } System.out.print(" ]");
 * System.out.println(); } } }
 */
