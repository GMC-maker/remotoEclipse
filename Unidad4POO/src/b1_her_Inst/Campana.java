package b1_her_Inst;

public class Campana extends Instrumento {

	// constructor
	public Campana() {
		super();
	}

	@Override
	void interpretar() {
		for (int i = 0; i < numNotas; i++) { // reciclando el contador numNotas porque para cada piano va a existir un
											// atributo suyo heredado.
			switch (notas[i]) {
			case DO:
				System.out.println("doooo");
				break;
			case RE:
				System.out.println("reeee");
				break;
			case MI:
				System.out.println("miiii");
				break;
			case FA:
				System.out.println("faaaa");
				break;
			case SOL:
				System.out.println("soool");
				break;
			case LA:
				System.out.println("laaaaa");
				break;
			case SI:
				System.out.println("siiiii");
				break;
			}

		}

		// method

	}
}
