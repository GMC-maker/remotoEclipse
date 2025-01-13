package tablas;

import java.util.Scanner;

public class E2 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		
		int t[];
		
		System.out.println("¿Cuantos números quieres ingresar?");
		int num = sc.nextInt();
		
		//llama a la funcion pideDatos con el mismo Scanner
		 t = pideDatos(num, sc);

		sc.close();

		for (int i = t.length - 1; i >= 0; i--) {
			System.out.print(t[i] + " ");
		}
	}

	public static int[] pideDatos(int n, Scanner sc) {

		int tabla[] = new int[n];
		System.out.println(" Ingresa los datos: ");
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = sc.nextInt();
		}

		return tabla;

	}
}
