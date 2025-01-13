package Bol8;

public class b8_Ej2 {

	public static void main(String[] args) {
		/* Diseñar una función a la que se le pasen dos enteros
		 *  y muestre todos los números comprendidos entre ellos.
		 */
		
		imprimEnt(0,200);
	}
	
	public static void imprimEnt(int n1, int n2) {
		for (int i=n1+1; i<n2;i++) {
			System.out.printf("%n"+i);
		}
	}
}
