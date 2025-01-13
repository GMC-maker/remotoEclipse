package Examenes;

import java.util.Scanner;
import java.util.Arrays;

public class Exa2018 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(" Oficina de Estudios Electorales OEEHM ");
		int opcion, indiceLocalidad=-1, indicePartido=-1;
		String localidad[];
		String partido[];
		int maxLocalidades = 30, maxPartidos = 20;
		int tablaVotos[][] = new int [maxPartidos][maxLocalidades];
		/* inicializa la matriz de votos*/
		boolean continuar = true;

		while (continuar) {
			System.out.println(" *******BIENVENIDO************ \n");
			System.out.println(" 1. Introducir votos obtenidos en una ciudad por partido. ");
			System.out.println(" 2. Listado alfabetico por partido de todos los datos introducidos. ");
			System.out.println(" 3. Listado de mejores resultados de cada partido ");
			System.out.println(" 4. Listado de localidades de menor a mayor participacion ");
			System.out.println(" 5. % de Votos obtenidos x partido x comunidad ");
			System.out.println(" 6. FIN ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				int i = 0;
				int nLocalidad=0, nPartido=0;
				
				String nombreLocalidad,nombrePartido;

				System.out.println(" Nombre de la localidad: ");
				nombreLocalidad = sc.next(); // ¿donde lo guarda?				
				
				System.out.println(" Nombre del partido: "); 
				nombrePartido = sc.next();
				
				
							
				
				/*necesito los indices para que me pueda grabar los datos de los votos*/
				System.out.println(" Indique el numero de votos de la localidad por partido");
				tablaVotos[indicePartido][indiceLocalidad] = sc.nextInt();
				
		

				System.out.println(" DATOS ALMACENADOS ");

				break;

			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				continuar = false;
				System.out.println(" FIN ");
				break;

			}// fin switch

		} // fin while p continuar en el menu

		sc.close();
	}

	public static int getIndexOf(String t[], int numElem, String elemBusca) {
		int indice = -1;
		for (int i = 0; i < numElem && indice == -1; i++) {
			if (t[i].equals(elemBusca)) {
				indice = i;
			}
		}
		return indice;
	}

	public static String[] tablaOrdenada(String t[], int numElem) {
		String[] tOrdenada = Arrays.copyOf(t, numElem);
		Arrays.sort(tOrdenada);
		return tOrdenada;

	}

}
