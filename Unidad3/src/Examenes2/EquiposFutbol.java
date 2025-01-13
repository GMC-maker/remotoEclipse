package Examenes2;

import java.util.Arrays;
import java.util.Scanner;

public class EquiposFutbol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int selector;
		String[] equipos = new String[20];
		int numEquipos = 0;
		// Tabla: [equipo local][equipo visitante][goles]
		int[][][] goles = new int[20][20][2];

		for (int i = 0; i < goles.length; i++) {
			for (int j = 0; j < goles[0].length; j++) {
				for (int k = 0; k < goles[0][0].length; k++) {
					goles[i][j][k] = -1;
				}
			}
		}
		//
		do {
			System.out.println("Menú");
			System.out.println("1 -Introducir votos obtenidos en una ciudad por un partido");
			System.out.println("2 -Mostrar todos los resultados introducidos");
			System.out.println("3 -Mostrar el equipo ganador de la liga");
			System.out.println("4 -Mostrar el porcentaje de partidos en los que perdio el equipo local");
			System.out.println("5 -Introducir el nombre del equipo y mostrar los resultados de todos sus partidos");
			System.out.println("6 -Finalizar");
			selector = sc.nextInt();
			switch (selector) {
			case 1:
				System.out.println("Equipo Local");
				String equipoLocal = sc.next();
				System.out.println("Equipo Visitante");
				String equipoVisitante = sc.next();
				System.out.println("Goles Equipo Local");
				int golesLocal = sc.nextInt();
				System.out.println("Goles Equipo Visitante");
				int golesVisitante = sc.nextInt();
				int indiceLocal = 0;
				int indiceVisitante = 0;
				// Con este codigo buscamos una palabra en la tabla usando getIndexOf(Tabla
				// donde se
				// busca, palabra que buscamos)
				// Si esta se ejecuta esto:
				if (getIndexOf(equipos, equipoLocal) >= 0) {
					indiceLocal = getIndexOf(equipos, equipoLocal);
				}
				// Si no esta se ejecuta esto:
				else {
					equipos[numEquipos] = equipoLocal;
					indiceLocal = numEquipos;
					numEquipos++;
				}
				// Con este codigo buscamos una palabra en la tabla getIndexOf(Tabla donde se
				// busca, palabra que buscamos)
				// Si está en la tabla se ejecuta esto para obtener el indice de la palabra.
				if (getIndexOf(equipos, equipoVisitante) >= 0) {
					indiceVisitante = getIndexOf(equipos, equipoVisitante);
				}
				// Si no esta se ejecuta esto para agregar esa palabra en la tabla asignada:
				else {
					equipos[numEquipos] = equipoVisitante;
					indiceVisitante = numEquipos;
					numEquipos++;
				}
				goles[indiceLocal][indiceVisitante][0] = golesLocal;
				goles[indiceLocal][indiceVisitante][1] = golesVisitante;
				indiceLocal = 0;
				indiceVisitante = 0;

				System.out.println("Datos almacenados");

				break;
			case 2:
				String[] equipoOrdenado = getSoftedTabla(equipos, numEquipos);
				// Primer for() se encuentra el valor a buscar
				for (int i = 0; i < equipoOrdenado.length; i++) {
					// Segundo for() es la tabla donde buscar el valor
					for (int j = 0; j < equipos.length && equipos[j] != null; j++) {
						// Ya tenemos el indice del equipo que nos interesa
						if (equipos[j].equals(equipoOrdenado[i])) {
							for (int i1 = 0; i1 < equipoOrdenado.length; i1++) {
								for (int j1 = 0; j1 < equipos.length && equipos[j1] != null; j1++) {
									if (equipos[j1].equals(equipoOrdenado[i1]) && goles[j][j1][0] >= 0) {
										System.out.println(equipos[j] + " - " + equipos[j1] + " (" + goles[j][j1][0]
												+ "-" + goles[j][j1][1] + ")");
									}
								}
							}
						}
					}
				}
				break;
			case 3:
				int[] puntos = new int[equipos.length];
				int totalPunto = -1;
				int indiceTotalPunto = -1;
				for (int i = 0; i < puntos.length; i++) {
					puntos[i] = 0;
				}
				for (int i = 0; i < goles.length; i++) {
					for (int j = 0; j < goles.length; j++) {
						if (goles[i][j][0] > goles[i][j][1]) {
							puntos[i] += 3;
						} else if (goles[i][j][0] < goles[i][j][1]) {
							puntos[j] += 3;
						} else if (goles[i][j][0] == goles[i][j][1] && goles[i][j][0] >= 0) {
							puntos[i] += 1;
							puntos[j] += 1;
						}
					}
				}
				for (int i = 0; i < puntos.length; i++) {
					if (totalPunto < puntos[i]) {
						indiceTotalPunto = i;
						totalPunto = puntos[i];
					}
				}
				System.out.println("El equipo con mas puntos es: " + equipos[indiceTotalPunto] + " con " + totalPunto);
				break;
			case 4:
				float totalPartidosJugados = 0;
				float partidosPerderLocal = 0;
				for (int i = 0; i < goles.length; i++) {
					for (int j = 0; j < goles.length; j++) {
						if (goles[i][j][0] >= 0) {
							totalPartidosJugados += 1;
							if (goles[i][j][0] < goles[i][j][1]) {
								partidosPerderLocal += 1;
							}
						}
					}
				}
				System.out.println("Porcentaje de partidos en los que perdió el equipo local: "
						+ partidosPerderLocal * 100 / totalPartidosJugados + "%");

				break;
			case 5:
				System.out.print("Introduzca un equipo:");
				String equipoMostrar = sc.next();
				int indice = -1;
				for (int i = 0; i < equipos.length && indice == -1; i++) {
					if (equipos[i].equals(equipoMostrar)) {
						indice = i;
						System.out.println(equipos[i]);
						System.out.println("");
						System.out.println("Local:");
						System.out.println("");
						for (int j = 0; j < equipos.length; j++) {
							if (goles[i][j][0] > -1) {
								System.out.println(
										equipos[i] + " " + goles[i][j][0] + " - " + equipos[j] + " " + goles[i][j][1]);
							}
						}
						System.out.println("");
						System.out.println("Visitante:");
						System.out.println("");
						for (int k = 0; k < equipos.length; k++) {
							if (goles[k][i][0] > -1) {
								System.out.println(
										equipos[k] + " " + goles[k][i][0] + " - " + equipos[i] + " " + goles[k][i][1]);
							}
						}
					}
				}

				break;
			case 6:
				System.out.println("Hasta otra.");
				break;
			}

		} while (selector != 6);

		sc.close();

	}

	public static int getIndexOf(String tabla[], String texto) {
		int indice = -1;
		for (int i = 0; i < tabla.length && tabla[i] != null; i++) {
			if (tabla[i].equals(texto)) {
				indice = i;
			}
		}
		return indice;
	}

	// Ordenar la tabla String
	public static String[] getSoftedTabla(String tabla[], int num) {
		String[] copyTabla = Arrays.copyOf(tabla, num);
		Arrays.sort(copyTabla);
		return copyTabla;
	}

}
