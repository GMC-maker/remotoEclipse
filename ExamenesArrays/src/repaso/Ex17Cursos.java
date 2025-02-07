package repaso;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class Ex17Cursos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		// attributes
		int opcion;
		String[] nombreProf = new String[10];
		String[] nombreCurso = new String[10];
		String[] nombreAlumno = new String[10];
		int[][] notasAlumno = new int[10][10];
		String nomP, nomC, nomA;
		int contProfesores = 0, contCursos = 0, contAlum = 0;

		// menu
		do {
			System.out.println("\n 1. Introducir datos de un curso. "
					+ "\n 2. Introducir dato de  la nota de un alumno en un curso. "
					+ "\n 3. Listado de todos los datos introducidos, alfabéticamente por curso. "
					+ "\n 4. Listado alfabético de profesores con mas de 10 alumnos en total. "
					+ "\n 5. Listado de cursos con su nota media, ordenado por media. "
					+ "\n 6. Listado de alumnos y cursos en los que se supera una nota dada" + "\n 7. FIN");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(" Nombre del Profesor: ");
				nomP = sc.next();

				System.out.println(" Nombre del curso: ");
				nomC = sc.next();

				// OjO un profesor da un solo curso, como lo valoro¿?
				// asumamos un cruce de indices, ya que se almacenan los datos en orden el Prof1
				// guarda el Curso1 en la casilla 0,0;
				//

				int posActualP = getIndexOf(nombreProf, nomP);
				int posActualC;
				if (posActualP != -1) {
					System.out.println(" Profesor ya registrado. ");
				} else if (posActualP == -1) {
					posActualP = contProfesores;
					nombreProf[posActualP] = nomP;
					contProfesores++;
				}

				// vamos a controlar que valide si ya existe un profesor no guarde el dato del
				// curso si ya existe el curso,
				// asumimos que es el mismo indice, porque los arrays se guardan en orden.
				if (getIndexOf(nombreProf, nomP) != -1) { // si el profesor ya esta registrado {
					posActualC = getIndexOf(nombreCurso, nomC);
					if (posActualC != -1) {
						System.out.println(" Curso ya registrado " + nombreCurso[posActualC].toUpperCase()
								+ "no se ha registrado esta entrada");
					} else if (posActualC == -1) {
						posActualC = contCursos;
						nombreCurso[posActualC] = nomC;
						contCursos++;
					}
				}

				// para mi

				System.out.println(Arrays.toString(nombreProf));
				System.out.println(Arrays.toString(nombreCurso));

				break;

			case 2:
				System.out.println(" Nombre del Alumno: ");
				nomA = sc.next();

				System.out.println(" Nombre del Curso: ");
				nomC = sc.next();

				int posActualA = getIndexOf(nombreAlumno, nomA);
				if (posActualA == -1) {
					posActualA = contAlum;
					nombreAlumno[posActualA] = nomA;
					contAlum++;
				}
				// nombre del curso que se ha matriculado, se debe controlar si ya se ha
				// matriculado previamente.
				posActualC = getIndexOf(nombreCurso, nomC);

				if (posActualC != -1) {
					System.out.println(" Nota Alumno: ");
					int nota = sc.nextInt();
					posActualA = contAlum;
					notasAlumno[posActualC][posActualA] = nota;

				} else {
					System.out.println(" Curso no existe, vuelva y registrelo primero.");
				}
				System.out.println(Arrays.toString(nombreAlumno));
				break;

			case 3:
				// todos los datos listados alfabeticamente por curso.
				verDatos(notasAlumno, nombreProf, nombreCurso, nombreAlumno, contProfesores, contCursos, contAlum);

				break;

			case 4:

				break;

			case 5:
				break;

			case 6:
				break;
			}

		} while (opcion != 7);

	}

	private static void verDatos(int[][] notas, String[] profesores, String[] cursos, String[] alumnos, int contP,
			int contC, int contA) {

		String[] copiaCursosOrdenados = Arrays.copyOf(cursos, contC);
		Arrays.sort(copiaCursosOrdenados);
		// Iterar sobre los cursos ordenados
		for (String cursoOrdenado : copiaCursosOrdenados) {
			int indiceCursoOriginal = getIndexOf(cursos, cursoOrdenado);

			// Imprimir el curso y su profesor
			System.out.println("Curso: " + cursoOrdenado);
			System.out.println("Profesor: " + profesores[indiceCursoOriginal]);

			// Mostrar los alumnos inscritos y sus notas para este curso
			System.out.println("Alumnos:");
			boolean hayAlumnos = false; // Bandera para verificar si hay alumnos en el curso

			for (int i = 0; i < contA; i++) { // Recorremos los alumnos registrados
				if (notas[indiceCursoOriginal][i] > 0) { // Si hay nota, el alumno está inscrito
					hayAlumnos = true;
					System.out.println(" - Alumno: " + alumnos[i] + " Nota: " + notas[indiceCursoOriginal][i]);
				}
			}

			if (!hayAlumnos) {
				System.out.println(" - No hay alumnos inscritos en este curso.");
			}

			System.out.println(); // Separador entre cursos
		}
	}

	private static int getIndexOf(String[] nombres, String nomBuscado) {
		int index = -1;

		for (int i = 0; i < nombres.length; i++) {
			if (nomBuscado.equals(nombres[i])) {
				index = i;
			}
		}

		return index;
	}

}
