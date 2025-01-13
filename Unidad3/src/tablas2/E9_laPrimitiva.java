package tablas2;

import java.util.Scanner;
import java.util.Locale;

public class E9_laPrimitiva {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int primiGuess[] = new int[6];
		int numeroGanador[] = { 2, 11, 12, 13, 28, 21 };

		System.out.println(" Dime tus números 1-49 para jugar a la PRIMITIVA: ");

		for (int i = 0; i < primiGuess.length; i++) {
			int numero = sc.nextInt();
			if (numero < 1 || numero > 49) {
				System.out.println(" Solamente se acepta de 1-49 para jugar, ingresalo de nuevo: ");
				numero = sc.nextInt();
				primiGuess[i] = numero;
			} else {
				primiGuess[i] = numero;
			}

		}
		sc.close();

		System.out.println(" Has acertado " + numeroAciertos(primiGuess, numeroGanador));
	}

	private static int numeroAciertos(int[] tablApuesta, int[] tablaGanador) {
		int contadorAciertos = 0;

		for (int i = 0; i < tablApuesta.length; i++) {
			for (int j = 0; j < tablaGanador.length; j++) {
				if (tablApuesta[i] == tablaGanador[j]) {
					contadorAciertos++;
				}
			}
		}
		return contadorAciertos;

	}

}
