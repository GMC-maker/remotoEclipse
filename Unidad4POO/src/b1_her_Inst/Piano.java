package b1_her_Inst;

public class Piano extends Instrumento {

//attributes

	
	
//constructors
 public Piano() {
	 super(); // el constructor de instrumento, va a recibir notas
 }
	
//methods
	@Override
	void interpretar() {
		for (int i = 0; i<numNotas; i++) { //reciclando el contador numNotas porque para cada piano va a existir un atributo suyo heredado.
			switch (notas[i]) {
			case DO:
				System.out.println("do");
				break;
			case RE:
				System.out.println("re");
				break;
			case MI:
				System.out.println("mi");
				break;
			case FA:
				System.out.println("fa");
				break;
			case SOL:
				System.out.println("sol");
				break;
			case LA:
				System.out.println("la");
				break;
			case SI:
				System.out.println("si");
				break;
			}
		}
		
	}

	
	
	
	
}
