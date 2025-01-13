package funcionesTablas;

import java.util.Scanner;
import java.util.Locale;

public class insertarDato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);// para que acepte . como divisor decimal

		int dato;
		int[] tabla = {1,2,3,-1,8};

		System.out.println(" Dime un numero: ");
		dato = sc.nextInt();
		
		mostrarArray(tabla);
		
		getIndex(tabla,dato);
		
		insertDato(tabla, sc);

		mostrarArray(tabla);

		sc.close();
	}

	private static void insertDato(int[] t, Scanner scan) {
		int pos = 0;
		
		System.out.println(" Dime un numero: ");
		int dato = scan.nextInt();
		if (getIndex(t,dato) == -1) { //si busco el dato y no lo encuentro
			t[pos]=dato; //se inserta el dato en el primer hueco
			pos++; //se aumenta en 1 
		}
	}

	private static int getIndex(int[] tablaBuscar, int elemBuscar) {
		int index = -1;

		for (int i = 0; i < tablaBuscar.length; i++) {
			if (elemBuscar == tablaBuscar[i]) {
				index = i;
			} // sin else, index = -1;
		}

		return index;
	}

	private static void mostrarArray(int[] t) {
		System.out.print("[ ");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println("]");

	}

}
