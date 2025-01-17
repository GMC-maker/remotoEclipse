package Sintonizador;

public class Frequence {
	
	//attributes
	private final static float SALTOS = 0.5f;
	private final static float FRECUENCIA_MAX = 108.0f;
	private final static float FRECUENCIA_MIN = 80.0f;
	private float frecuenciActual;
	
	
	
	//constructors
	public Frequence() {
		frecuenciActual= FRECUENCIA_MIN;
	}


	//	methods
	public void subirFrecuencia() {
		frecuenciActual+=SALTOS;
		if(frecuenciActual>FRECUENCIA_MAX) {
			frecuenciActual=FRECUENCIA_MIN;
			System.out.println(frecuenciActual+" MHz");
		}
	}
	
	public void bajarFrecuencia() {
		frecuenciActual-=SALTOS;
		if(frecuenciActual<FRECUENCIA_MIN) {
			frecuenciActual=FRECUENCIA_MAX;
			System.out.println(frecuenciActual+" MHz");
		}
	}
	
	
	//get-set
	
	@Override
	public String toString() {
		return "Frecuence [frecuenciActual=" + frecuenciActual + "]";
	}


	public float getFrecuenciActual() {
		return frecuenciActual;
	}

	public void setFrecuenciActual(float frecuenciActual) {
		this.frecuenciActual = frecuenciActual;
	}


	public static float getSaltos() {
		return SALTOS;
	}


	public static float getFrecuenciamax() {
		return FRECUENCIA_MAX;
	}


	public static float getFrecuenciamin() {
		return FRECUENCIA_MIN;
	}
	
}
