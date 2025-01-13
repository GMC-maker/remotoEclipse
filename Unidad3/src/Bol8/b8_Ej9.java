package Bol8;

import java.util.Scanner;

public class b8_Ej9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.println(" Dime un numero: ");
		num = sc.nextInt();
		sc.close();

		divisoresPrimos(num);

	}

	public static void divisoresPrimos(int n) {
		System.out.print("Divisores primos de " + n + ": ");
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && B8_Ej7.esPrimo(i)) {
				System.out.print(i + ", ");
			}
		}
		System.out.println();
	}

}
