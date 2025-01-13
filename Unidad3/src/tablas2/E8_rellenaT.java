package tablas2;



public class E8_rellenaT {

	public static void main(String[] args) {
	
		int[][] tabla = new int[5][5];

		/*
		 * y rellenarla de la siguiente forma: la posición [n,m] debe contener n+m.
		 * Después, se debe mostrar su contenido.
		 */
		rellenaTablaNM(tabla);
		muestraTabla(tabla);


	}

	private static void rellenaTablaNM(int[][] t) {

		for (int n = 0; n < t.length; n++) {
			for (int m = 0; m < t[n].length; m++) {
				t[n][m] = n + m;
			}
		}

	}
	
	private static void muestraTabla(int[][] t) {
		for (int n = 0; n < t.length; n++) {
			System.out.print("[ ");
			for (int m = 0; m < t[n].length; m++) {
				System.out.print(t[n][m]+" ");
				
			}
			System.out.print("]\n");
			
		}
	}
	
}
