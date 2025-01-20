package b1_her;

public class Hora {
	protected int hora, minuto;

	// constructors
	public Hora() {
		super();
	}

	public Hora(int hora, int minuto) {
		// hora de 0 a 23
		super();  // un nuevo objeto que llama a las funciones set y verificar que sus valores
				// sean correctos entre 0-24h o 0-60m
		setHora(hora);
		setMinutos(minuto);
	}

	// methods

	public void inc() { // sin parametros, es una funcion que aumenta la hora en 1 minuto.
		this.minuto++;
		if (this.minuto >= 60) {
			this.minuto = 0;
			this.hora++;
			if (this.hora >= 24) {
				this.hora = 0;
			}
		}

	}


	// getters && Setters
	public void setMinutos(int minuto) { // da valor a los minutos, si llega a 60 = 1 
		if (minuto>=0 && minuto < 60) { //si no pasa la validacion el valor se queda igual.
			this.minuto = minuto;
		} else if(minuto >=60 ) {
			this.minuto = 0;
			setHora(this.hora++);
		}
	}

	public void setHora(int hora) {  // da valor a las horas, si llega a 24 -> 0 hrs.
		if (hora >= 0 && hora < 24) {  //si no pasa la validacion el valor se queda igual.
			this.hora = hora;
		} else if (hora == 24) {
			this.hora = 0;
		}
	}

	@Override
	public String toString() {
		return " [" + hora + ":" + minuto + "]";
	}

}
