
package Sintonizador;

import java.util.Scanner;

public class SintonizadorFM {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opt;
		Frequence f1 = new Frequence();

		do {
			System.out.println(" Sintonizador FM \n1.Subir Frecuencia \n2.Bajar Frecuencia \n3.Apagar");
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				f1.subirFrecuencia();
				System.out.println(f1.toString());
				System.out.println();
				break;
			case 2:
				f1.bajarFrecuencia();
				System.out.println(f1.toString());
				System.out.println();
				break;
			}
		} while (opt != 3);
		sc.close();
	}

}
