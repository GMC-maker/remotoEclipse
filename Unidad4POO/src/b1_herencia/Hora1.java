package b1_herencia;

public class Hora1 {
	private int hora;
	private int minuto;

	// constructors
	public Hora1(int hora, int minuto) {
		// hora de 0 a 23
		super();
		this.hora = hora;
		this.minuto = minuto;
	}

	// methods
	public void inc(int hora, int minuto) {
		// incrementa la hora en un minuto
		this.minuto = minuto + 1;
		if (this.minuto > 60) {
			this.minuto = 0;
			this.hora = hora + 1;
			if (this.hora > 24) {
				this.hora = 0;
			}
		}

	}

	public void setMinutos(int valor) {
		// que da valor a los minutos, si llega a 60 = 1 min
		
	}

	public void setHora(int valor) {
		// que da valor a las horas, si llega a 24 = a 0 hrs dia siguiente.
	}

	// getters && Setters

}
