package ExamenArray;

import java.util.Scanner;
import java.util.Arrays;

public class Ex24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] nomCaballos = new String[15];
		String[] ciudades = new String[10];// tantas ciudades como carreras
		int[] carrera = new int[10];
		Arrays.fill(carrera, -1);

		// asumamos 15 Cab -10 Carr -10 Ciudades
		float[][][] matrizVelocidades = new float[15][10][10];
		int opcion;
		int caballosInsertados = 0;
		int ciudadesInsertadas = 0;
		int carreraRegistrada = 0;

		do {
			System.out.println("\n1.Introducir datos \r\n" + "2. Listar todos los datos \r\n"
					+ "3. Ciudad en la que ha habido mas carreras\r\n"
					+ "4. Listado de carreras junto con el caballo en ultima posicion\r\n"
					+ "5. Listado - ordenado por caballo - de velocidades medias \r\n" + "6. FIN");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(" Nombre del caballo: ");
				String nombreC = sc.next();

				// pido el indice del caballo array-tamaño-nombre obtenido
				int indiceCaballos = getIndexOf(nomCaballos, nomCaballos.length, nombreC);
				// primera posicion del dato a insertar
				if (indiceCaballos == -1) {
					indiceCaballos = caballosInsertados;
					nomCaballos[caballosInsertados] = nombreC;
					caballosInsertados++;
				}

				System.out.println(" No. Carrera: ");
				int numCarrera = sc.nextInt();// esto directamente me da el indice
				// pero necesito almacenar ese dato porque no me dan en orden.

				int indiceCarrera = getIndexOf(carrera, carrera.length, numCarrera);// ojo sobrecargar la fx con int
				if (indiceCarrera == -1) {
					indiceCarrera = carreraRegistrada;// dato 0
					carrera[carreraRegistrada] = numCarrera;
					carreraRegistrada++;
				}

				System.out.println(" Nombre de la Ciudad: ");
				String nombreCiudad = sc.next();

				// pide el indice para ver si ya existe array-tamaño-nombreBuscado
				int posCiudad = getIndexOf(ciudades, ciudades.length, nombreCiudad);
				// posicion String Ciudades
				if (posCiudad == -1) {
					posCiudad = ciudadesInsertadas;
					ciudades[ciudadesInsertadas] = nombreCiudad;
					ciudadesInsertadas++;
				}
				// ahora guardar el dato en la matrix!

				System.out.println(" Dime la velocidad registrada: ");
				matrizVelocidades[indiceCaballos][indiceCarrera][posCiudad] = sc.nextFloat();//se me olvidó

				break;
			case 2:
				imprimirResultados(matrizVelocidades, nomCaballos, carrera, ciudades);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;

			}

		} while (opcion != 6);

		sc.close();
	}

	private static int getIndexOf(int[] tablaNum, int tamanho, int datoBuscar) {
		int indice = -1;
		// aquí recorre la tabla y busca el elemento que buscamos un INT
		for (int i = 0; i < tamanho && indice == -1; i++) {
			if (tablaNum[i] != -1 && tablaNum[i] == datoBuscar) {
				indice = i;
			}
		}
		return indice;
	}

	private static void imprimirResultados(float[][][] matrixTri, String[] nombreCaballos, int[] ncarrera,
			String[] nombreciudad) {
		int i, j, k; // vamos a recorrer toda la matriz paso a pasito...
		for (i = 0; i < matrixTri.length; i++) { // caballo
			if (nombreCaballos[i] != null) {
				System.out.println("Caballo: " + nombreCaballos[i]);// tengo que buscar en el array de nombres de
																	// caballo..
			}
			for (j = 0; j < matrixTri[i].length; j = 0) {// aqui la carrera
				if (ncarrera[i] != -1) {
					System.out.print(" Carrera: " + ncarrera[j]);
				}
				for (k = 0; k < matrixTri[i][j].length; k++) {// aqui la ciudad
					if (nombreciudad != null) {
						System.out.println(nombreciudad[k] + ": " + matrixTri[i][j][k] + "\t");// esto es la velocidad.
						
					}
				}
				System.out.println();
			}

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
