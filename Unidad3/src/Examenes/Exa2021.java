package Examenes;

import java.util.Scanner;

public class Exa2021 {

	public static void main(String[] args) {
		// BANK
		Scanner sc = new Scanner(System.in);
		int option, envia, recibe, idSucursal = -1, contDiezMil = 0;
		float monto, montoMax = Float.MIN_VALUE;
		float matrizTrnx[][] = new float[20][20];

		do {

			System.out.println(" ****MENU******");
			System.out.println("1. Transferir a otra sucursal ");
			System.out.println("2. Mostrar todos los datos introducidos: ");
			System.out.println("3. Sucursal que ha recibido más dinero ");
			System.out.println("4. Sucursales que superan los 10000€ enviados ");
			System.out.println("5. Finalizar ");
			option = sc.nextInt();

			switch (option) {
			case 1: // suponiendo que no se van a equivocar... no hay validacion para la sucursal.

				System.out.println(" sucursal que ENVIA 0 -  19 ");
				envia = sc.nextInt();
				System.out.println(" sucursal que RECIBE 0 - 19 ");
				recibe = sc.nextInt();
				System.out.println(" Cantidad a transferir: ");
				monto = sc.nextFloat();

				while (monto <= 0) {
					System.out.println(" Cantidad debe ser mayor a 0 \n Cantidad a transferir:  ");
					monto = sc.nextFloat();
				}

				matrizTrnx[envia][recibe] = monto; // en el enunciado indica que se pierde el dato anterior.
				System.out.println("  DATOS ALMACENADOS  \n");
				//
				if (monto >= montoMax) {
					montoMax = monto;
					idSucursal = recibe;
					if (monto > 10000) {
						contDiezMil++;
					}
				}

				break;

			case 2: // mostrar todos los datos introducidos

				System.out.println("****** Resumen ******** ");

				for (int i = 0; i < matrizTrnx.length; i++) {
					System.out.println(" La sucursal  " + i + " ha enviado ");
					for (int j = 0; j < matrizTrnx[0].length; j++) {
						if (matrizTrnx[i][j] > 0) {// si el valor de monto guardado, es mayor a 0.

							System.out.printf(" a la sucursal %d: %.2f€ \n", j, matrizTrnx[i][j]);
							/*
							 * %d: Especifica que aquí se imprimirá un número entero (en este caso, el valor
							 * de destino, se usan , en lugar de + para concatenar) %.2f: Especifica que
							 * aquí se imprimirá un número decimal con 2 decimales
							 */
						}
					}
				}
				break;
			case 3:
				//para calcular la que mas ha recibido sumo las columnas 
				int row=0,col;
				 
				for (col = 0;col<matrizTrnx[row].length;col++) {
					float sumaSucRecibe = 0;// se inicializa a 0 para que sume la siguiente columna
					for (row=0;row<matrizTrnx.length;row++) {
						sumaSucRecibe = matrizTrnx[col][row];
					}
					//cuando sume toda la columna que vaya guardando el valor en el nuevo Array:
					float []sumatorioRecibe = new float[matrizTrnx.length];
					sumatorioRecibe[col]=sumaSucRecibe;
				}
				
				System.out.printf(" La sucursal que más ha recibido más dinero es %d: %.2f  \n", idSucursal, montoMax);
				break;
			case 4:
				System.out.println(" sucursal(es) que ha(n) enviado más de 10,000€:  " + contDiezMil);
				break;
			case 5:

				break;

			}// switch

		} while (option != 5);

		sc.close();
		System.out.println(" FIN  ");

	}

	public static boolean filaRellena(int numFila, float t[][]) {

		boolean rellena = false;
		for (int j = 0; j < 20; j++) {
			if (t[numFila][j] > 0)
				rellena = true;
		}

		return rellena;
	}

}
