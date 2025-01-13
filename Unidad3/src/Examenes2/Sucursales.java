package Examenes2;

import java.util.Scanner;

public class Sucursales {

	static float transferencia[][] = new float[20][20];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int selector;
//Menu
		do {
			System.out.println("Menu");
			System.out.println("1 -Introducir transferencia de una sucursal a otra");
			System.out.println("2 -Mostrar todos los datos introducidos");
			System.out.println("3 -Mostrar sucursal que ha recibido mas dinero");
			System.out.println("4 -Mostrar en cuántas sucursales el total de lo enviado supera 10000€");
			System.out.println("5 -Finalizar");
			selector = sc.nextInt();
			switch (selector) {
			case 1:
				System.out.println("Sucursal que envia el dinero");
				int sucursalEnvia = sc.nextInt();
				System.out.println("Sucursal que recibe el dinero");
				int sucursalRecibe = sc.nextInt();
				System.out.println("Cantidad enviada");
				float dinero = sc.nextFloat();
				transferencia[sucursalEnvia][sucursalRecibe] = dinero;
				System.out.println("Datos almacenados");
				break;
			case 2:
				mostrarTodosDatos(transferencia);
				break;
			case 3:
				mostrarSucursalesMasDinero(transferencia);
				break;
			case 4:
				mostrarSucursalesSupera(transferencia);
				break;
			case 5:
				System.out.println("Programa finalizado.");
				break;
			default:
				System.out.println("Elija una opcion correcta.");

			}
		} while (selector != 5);

		sc.close();

	}

	// Comprobar si la fila envia dinero
	public static boolean analizarFila(int numFila, float tabla[][]) {
		boolean cantidad = false;
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[numFila][i] > 0) {
				cantidad = true;
			}
		}
		return cantidad;

	}

	// Mostrar todos los datos introducidos
	public static void mostrarTodosDatos(float tabla[][]) {
		for (int i = 0; i < tabla.length; i++) {
			if (analizarFila(i, tabla)) {
				System.out.println("La sucursal num " + i + " ha enviado:");
				for (int j = 0; j < tabla.length; j++) {
					if (tabla[i][j] > 0) {
						System.out.println("a la sucursal " + j + ", " + tabla[i][j]);
					}
				}
			}
		}
	}

	// Mostrar sucursal que ha recibido mas dinero
	public static void mostrarSucursalesMasDinero(float tabla[][]) {
		int sucursalRecibioMasDinero = 0;
		float cantidadTotal = Float.MIN_VALUE;
		float cantidadSucursal = 0;
		for (int j = 0; j < tabla.length; j++) {
			for (int i = 0; i < tabla.length; i++) {
				cantidadSucursal = cantidadSucursal + tabla[i][j];
			}
			if (cantidadSucursal > cantidadTotal) {
				cantidadTotal = cantidadSucursal;
				sucursalRecibioMasDinero = j;
			}
			cantidadSucursal = 0;
		}
		System.out.println("La sucursal que mas dinero ha recibido ha sido " + sucursalRecibioMasDinero
				+ " con un total de " + cantidadTotal + " €.");
	}

	// Mostrar en cuántas sucursales el total de lo enviado supera 10000€
	public static void mostrarSucursalesSupera(float tabla[][]) {
		int contadorSupera = 0;
		float cantidadTotal = 0;
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				cantidadTotal = cantidadTotal + tabla[i][j];
			}
			if (cantidadTotal > 10000) {
				contadorSupera++;
			}
			cantidadTotal = 0;
		}
		System.out.println("Hay " + contadorSupera + " sucursales que han recibido mas de 10.000,00€");
	}
}
