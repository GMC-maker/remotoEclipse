package Bol8;

import java.util.Scanner;
import java.util.Locale;

@SuppressWarnings("unused")

public class b8_Ej3 {

	public static void main(String[] args) {
		// 1 - Area
		// 2 - Volume

		int select, h, r;
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		

		System.out.println(" Indica si quieres calcular el \n1-Area \n2-Volumen de un cilindro");
		select = sc.nextInt();
		System.out.println(" Dime la altura: ");
		h = sc.nextInt();
		System.out.println(" Dime el radio: ");
		r = sc.nextInt();
		sc.close();
		
		cilindro(select,h,r);
	}

	public static void cilindro(int opt, int height, int radius) {
		double area, volume;
		final double PI = 3.1415; 

		if (opt == 1) {

			area = 2 * PI * radius * (height + radius);
			System.out.printf("El área del Cilindro es: %.2f%n",area);
		} else if (opt == 2) {

			volume = PI * Math.pow(radius, 2) * height;
			System.out.printf(" El volumen del Cilindro es: %.2f%n", volume);
		}
	}
}
