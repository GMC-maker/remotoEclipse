package tablas2;

import java.util.Scanner;
import java.util.Locale;
import java.util.Arrays;

public class E10_RellenaPares {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int t[] = new int[5];

		System.out.println("Impares Desechados"+rellenaPares(t,sc));
		System.out.println(Arrays.toString(t));
		sc.close();
	}

	private static int rellenaPares(int[] tabla, Scanner sc) {
		int number, imparesDesechados = 0;
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Dime un número: ");
			number = sc.nextInt();
			if (number % 2 == 0) {
				tabla[i] = number;
			} else {
				i -=1;
				imparesDesechados++;
			}
		}
		return imparesDesechados;
	}

}
