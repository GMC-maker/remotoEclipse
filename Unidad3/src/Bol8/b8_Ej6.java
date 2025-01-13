package Bol8;

import java.util.Scanner;

public class b8_Ej6 {

	public static void main(String[] args) {

		char graph;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime una letra: ");
		graph = sc.next().charAt(0);

		sc.close();

		System.out.println(" La letra introducida es vocal:  " + EsVocal(graph));
	}

	public static boolean EsVocal(char letra) {
		boolean VowelOK = false;

		Character.toUpperCase(letra);
		VowelOK = (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U');
		
		
		/*if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
			VowelOK = true;
		} else if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			VowelOK = true;
		} else {
			VowelOK = false;
		}*/
				
		return VowelOK;
	}

}
