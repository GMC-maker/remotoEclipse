package b1_her_Inst;

public abstract class Instrumento {

	// attributes
	public enum Nota {
		DO, RE, MI, FA, SOL, LA, SI
	}

	protected Nota notas[]; // arreglo que almacena las notas
	protected int numNotas; // numero de notas almacenadas
	static protected int maxNotas = 100;

	// constructors
	public Instrumento() {
		notas = new Nota[maxNotas]; // dar tamaño al objeto -> el arreglo de notas tendrá 100.
		numNotas = 0; // inicializar contador de notas
	}

	// methods
	public void add(Nota n) {// agregar una nota a un array de nota.
		if (numNotas < notas.length) { //agrega si hay sitio, numNotas <100
			notas[numNotas]= n; //se inserta iniciando en 0 
			numNotas++;
		}
	}

	abstract void interpretar();

}
