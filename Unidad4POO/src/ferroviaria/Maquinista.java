package ferroviaria;

public class Maquinista {
	
	String nombreCompleto;
	String dni;
	float sueldoMensual;
	int rango;
	
	//constructors
	
	
	public Maquinista (String nombreCompleto,String dni, float sueldoMensual,int rango) {
		this.nombreCompleto= nombreCompleto;
		this.dni = dni;
		this.sueldoMensual = sueldoMensual;
		this.rango = rango;
	}

	public Maquinista() {
		super();
		
	}

	@Override
	public String toString() {
		return "Maquinista [nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", sueldoMensual=" + sueldoMensual
				+ ", rango=" + rango + "]";
	}
	
	//methods
	
	
	//get - set
	
	
	
}
