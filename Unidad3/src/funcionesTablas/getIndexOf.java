package funcionesTablas;

import java.util.Scanner;
import java.util.Locale;

public class getIndexOf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		int[] tabla = {20,30,40,50,60};
		int x, pos;

		System.out.println(" Dime un numero 1-10: ");
		x = sc.nextInt();
		//busca el indice del numero.
		pos = getIndex(tabla, x);
		sc.close();
		
		if( pos != -1) {
		System.out.println(" La posicion del elemento es: "+pos);
		} else {
			System.out.println(" No existe el elemento buscado.");
		}
		
	}

	private static int getIndex(int[] tablaBuscar, int elemBuscar) {
		int index = -1;

		for (int i = 0; i < tablaBuscar.length; i++) {
			if (elemBuscar == tablaBuscar[i] ) {
				index = i;
			} //sin else, index = -1;
		}

		return index;
	}

}
