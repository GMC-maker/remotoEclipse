package Examenes;

import java.util.Scanner;

public class Ej1_Marta {

	public static void main(String[] args) {
		String[] nombresAlumnos = new String[30];
		// cada fila es un alumno que se corresponde con el nombre que est� en la misma
		// posici�n de nombresAlumnos
		// columna 0: control
		// columna 1: examen
		// columna 2: positivos
		float[][] alumnosNotas = new float[30][3];
		// indicador para saber cu�ntos alumnos hemos introducido
		int numAlumnos = 0;
		String[] nomAlumnosOrdenados;
		float[] alumnosNotasFinalesOrdenado;

		try (Scanner sc = new Scanner(System.in)) {
			int opcion = -1;
			while (opcion != 5) {
				System.out.println("1- Introducir alumno, nota del control y nota del examen final del alumno.\n"
						+ "2- Poner un positivo a un alumno.\n"
						+ "3- Listar todos los alumnos con su nota final de evaluaci�n ordenado por nota.\n"
						+ "4- Mostrar estad�sticas de la evaluaci�n.\n" + "5- Fin. \n");
				opcion = sc.nextInt();
				switch (opcion) {
				case 1:
					/*
					 * Pedir� el nombre del alumno, la nota que ha obtenido en el control y la nota
					 * que ha obtenido en el examen final. Una vez introducido los tres datos, se
					 * volver� al men�. Sabemos que el n�mero m�ximo de alumnos es 30.
					 */
					System.out.print("Nombre alumno: ");
					nombresAlumnos[numAlumnos] = sc.next();
					System.out.print("Nota control: ");
					alumnosNotas[numAlumnos][0] = sc.nextInt();
					System.out.print("Nota examen: ");
					alumnosNotas[numAlumnos][1] = sc.nextInt();
					numAlumnos++;
					break;
				case 2:
					/*
					 * S�lo pedir� el nombre del alumno al que hay que a�adir un positivo. El n�mero
					 * m�ximo de positivos no se especifica, pero sabemos que ser� un entero. Tras
					 * introducir el nombre, se volver� al men�. El programa no debe permitir
					 * errores.
					 */
					System.out.print("Nombre alumno: ");
					int indice = getIndiceAlumno(sc.next(), nombresAlumnos, numAlumnos);
					if (indice == -1) {
						System.out.println("Ese alumno no est� en esta clase");
					} else {
						alumnosNotas[indice][2]++;
						System.out.println("Positivo sumado");
					}
					break;
				case 3:
					/*
					 * Listar� todas los alumnos introducidos, junto con su nota final de la
					 * evaluaci�n. Esta nota se calcula de la forma: 30% ser� la nota del control,
					 * 60% la nota del final, y 10% la nota obtenida del n�mero de positivos,
					 * sabiendo que el alumno o alumnos que m�s positivos tengan tendr�n la m�xima
					 * nota en este apartado; el resto de los alumnos tendr�n una nota en este
					 * apartado proporcional a ese m�ximo y al n�mero de positivos obtenidos. El
					 * listado se debe mostrar ordenado crecientemente por nota final de evaluaci�n.
					 */
					nomAlumnosOrdenados=new String[numAlumnos];
					alumnosNotasFinalesOrdenado=new float[numAlumnos];
					getAlumnosNotasFinalesOrdenados(nombresAlumnos, alumnosNotas, numAlumnos, alumnosNotasFinalesOrdenado, nomAlumnosOrdenados);
					System.out.println("Listado de alumnos y sus notas: ");
					for(int i=0;i<numAlumnos;i++) {
						System.out.println(nomAlumnosOrdenados[i]+": "+alumnosNotasFinalesOrdenado[i]);
					}
					break;
				case 4:
					/*
					 * Mostrar� en un mensaje los siguientes datos: - (1 punto) Porcentaje de
					 * alumnos con el examen final suspenso (sin tener en cuenta las otras notas). -
					 * (0.5 puntos) Nota media final de evaluaci�n de todo el grupo. - (0.5 puntos)
					 * Nombre y nota del alumno con nota m�xima en el control.
					 */
					System.out.println("El % de alumnos con el examen final suspenso es: "+100*contadorAlumnosExamenSuspenso(alumnosNotas, numAlumnos)/numAlumnos);
					System.out.println("La media del grupo es "+getMediaGrupo(alumnosNotas, numAlumnos));
					
					float notaMaxControl=-1;
					String alumnoNotaMax="";
					for(int i=0;i<numAlumnos;i++) {
						if(alumnosNotas[i][0]>notaMaxControl) {
							notaMaxControl=alumnosNotas[i][0];
							alumnoNotaMax=nombresAlumnos[i];
						}
					}
					System.out.println("El alumno con m�xima nota en el control es "+alumnoNotaMax+" con un "+notaMaxControl);
					
					break;
				case 5:
					System.out.println("!Hasta la pr�xima!");
					break;
				default:
					System.out.println("Opci�n incorrecta");
					opcion = 5;
				}
			}

		}
	}

	private static float getMediaGrupo(float[][] alumnosNotas, int numAlumnos) {
		int maxPositivos= getMaxPositivos(alumnosNotas, numAlumnos);
		float suma=0;
		for(int i=0;i<numAlumnos;i++) {
			suma+=0.3f*alumnosNotas[i][0]+0.6f*alumnosNotas[i][1]+0.1f*alumnosNotas[i][2]/maxPositivos;
		}
		return suma/numAlumnos;
	}

	private static void getAlumnosNotasFinalesOrdenados(String[] nombresAlumnos, float[][] alumnosNotas, int numAlumnos, float[] alumnosNotasFinalesOrdenado, String[] nomAlumnosOrdenados) {

		int maxPositivos= getMaxPositivos(alumnosNotas, numAlumnos);
		for(int i=0;i<numAlumnos;i++) {
			float notaFinalAlumno=0.3f*alumnosNotas[i][0]+0.6f*alumnosNotas[i][1]+0.1f*alumnosNotas[i][2]/maxPositivos;
			int j=i-1;
			while(j>=0 && alumnosNotasFinalesOrdenado[j]>notaFinalAlumno) {
				alumnosNotasFinalesOrdenado[j+1]=alumnosNotasFinalesOrdenado[j];
				nomAlumnosOrdenados[j+1]=nomAlumnosOrdenados[j];
				j--;
			}
			alumnosNotasFinalesOrdenado[j+1]=notaFinalAlumno;
			nomAlumnosOrdenados[j+1]=nombresAlumnos[i];
		}
		
	}

	private static int contadorAlumnosExamenSuspenso(float[][] alumnosNotas, int numAlumnos) {
		int contador=0;
		for(int i=0;i<numAlumnos;i++) {
			if(alumnosNotas[i][1]<5) {
				contador++;
			}
		}
		return contador;
		
	}

	private static int getMaxPositivos(float[][] alumnosNotas, int numAlumnos) {
		float maxPosi=-1;
		for(int i=0; i< numAlumnos;i++) {
			if(alumnosNotas[i][2]>maxPosi) {
				maxPosi=alumnosNotas[i][2];
			}
		}
		return (int) maxPosi;
	}

	private static int getIndiceAlumno(String nombre, String[] nombresAlumnos, int numAlumnos) {
		int indice = -1;
		for (int i = 0; i < numAlumnos && indice == -1; i++) {
			if (nombresAlumnos[i].equals(nombre)) {
				indice = i;
			}
		}
		return indice;

	}

}
