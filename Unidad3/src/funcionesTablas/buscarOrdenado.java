package funcionesTablas;
import java.util.Scanner;
import java.util.Locale;

public class buscarOrdenado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		int[] tabla = {2,4,6,8,7,5,3,1};
		int x, pos;

		System.out.println(" Dime un numero: ");
		x = sc.nextInt();
		//busca el indice del numero.
		pos = getIndex(tabla, x);
		sc.close();
		
		if( pos != -1) {
		System.out.println(" La posicion del elemento es: " + -1*pos);
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
