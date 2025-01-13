package Examenes;

import java.util.Scanner;


public class Exa2014 {

	public static void main(String[] args) {
		System.out.println(" Notas Evaluacion ciclo DAW ");

		Scanner sc = new Scanner(System.in);
		int opcion;
		// col 1 Control col2 ExamenFinal col3 Positivos?
		float matrizNotas[][] = new float[30][3];// guarda las notas
		String nomAlumnos[] = new String[30];
		String nombre;
		String nomAlumOrd[];
		float[] alumnosNotasFinOrdenado;
		

		int fila = 0;// para saber cuantos alumnos hemos introducido

		do {
			System.out.print("\n 1. Alumno,nota de control, nota examen final.");
			System.out.print("\n 2. Poner un positivo a un alumno. ");
			System.out.print("\n 3. Lista todos los alumnos con su nota final de eval ordenado por nota.");
			System.out.print("\n 4. Mostrar estadísticas de la evaluación.");
			System.out.print("\n 5. FIN\n");
			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				// en este caso pide 3 datos de la misma persona, con lo cual los puedo
				// almacenar directamente
				// y sumar el contador como si fuera el indice.

				System.out.println(" Dime el nombre del alumno");
				nomAlumnos[fila] = sc.next();
				// guarda en la matriz de notas tipo Float
				System.out.println(" Dime la nota de Control 1");
				matrizNotas[fila][0] = sc.nextFloat();
				System.out.println("Dime la nota Final del P1");
				matrizNotas[fila][1] = sc.nextFloat();
				fila++;

				break;
			case 2:
				// busca el nombre del Alumno para guardar el valor positivo.
				System.out.println("\nNombre del Alumno: ");
				nombre = sc.next();
				// busca el indice en el arreglo de nombres.
				int indice = getIndexOf(nombre, nomAlumnos, fila);
				// la funcion devuelve -1 si no está, o el valor del indice si es igual.
				if (indice == -1) {
					System.out.println("Ese alumno no está en esta clase");
				} else {
					matrizNotas[indice][2]++;// positivo sumado
					System.out.println("Positivo Sumado");
				}
				break;
			case 3: // lista los alumnos junto con su nota final de eval.
				nomAlumOrd = new String[fila];// en el peor de los casos igual que el array original.

				// un array con las notas ordenadas de los alumnos y guardando el valor de la
				// nota final global
				alumnosNotasFinOrdenado = new float[fila];
				// una funcion que ordena los datos del array que has enviado
				getAlumNotasFinalesOrdenados(nomAlumnos, matrizNotas, fila, alumnosNotasFinOrdenado, nomAlumOrd);

				System.out.println("Listado de alumnos y sus notas: ");
				for (int i = 0; i < fila; i++) {
					System.out.println(nomAlumOrd[i] + ": " + alumnosNotasFinOrdenado[i]);
				}
				break;
			case 4:
				System.out.println("El % de alumnos con el examen final suspenso es: "+100*contadorAlumSuspenso(matrizNotas, fila)/fila);
				System.out.println("La media del grupo es "+getMediaGrupo(matrizNotas, fila));
				break;

			}

		} while (opcion != '5');
		sc.close();
	}

	private static float getMediaGrupo(float[][] matrizNotas, int fila) {
		int maxPositivos= getMaxPositivos(matrizNotas, fila);
		float suma=0;
		for(int i=0;i<fila;i++) {
			suma+=0.3f*matrizNotas[i][0]+0.6f*matrizNotas[i][1]+0.1f*matrizNotas[i][2]/maxPositivos;
		}
		return suma/fila;
	}

	private static int contadorAlumSuspenso(float[][] matrizNotas, int fila) {
			int contador=0;
			for(int i=0;i<fila;i++) {
				if(matrizNotas[i][1]<5) {
					contador++;
				}
			}
			return contador;
			
		}
	

	private static void getAlumNotasFinalesOrdenados(String[] nomAlumnos, float[][] matrizNotas, int fila,
			float[] alumnosNotasFinOrdenado, String[] nomAlumOrd) {
		int maxPositivos = getMaxPositivos(matrizNotas, fila);//llama a otra funcion para obtener los maximos
		
		for (int i = 0; i < fila; i++) {
			float notaFinalAlumno = 0.3f * matrizNotas[i][0] + 0.6f * matrizNotas[i][1]
					+ 0.1f * matrizNotas[i][2] / maxPositivos;
			int j = i - 1;
			while (j >= 0 && alumnosNotasFinOrdenado[j] > notaFinalAlumno) {
				alumnosNotasFinOrdenado[j + 1] = alumnosNotasFinOrdenado[j];
				nomAlumOrd[j + 1] = nomAlumOrd[j];
				j--;
			}
			alumnosNotasFinOrdenado[j + 1] = notaFinalAlumno;
			nomAlumOrd[j + 1] = nomAlumnos[i];
		}

	}

	private static int getMaxPositivos(float[][] matrizNotas, int fila) {
		float maxPosi=-1;
		for(int i=0; i< fila;i++) {
			if(matrizNotas[i][2]>maxPosi) {
				maxPosi=matrizNotas[i][2];
			}
		}
		return (int) maxPosi;

	}

	
	private static int getIndexOf(String nombre, String[] nomAlumnos, int fila) {
		int indice = -1; // creo la variable y la inicializo a -1;
		for (int i = 0; i < nomAlumnos.length && indice == -1; i++) {
			if (nomAlumnos[i].equalsIgnoreCase(nombre)) {
				indice = i;
			}
		}
		return indice;
	}

}
