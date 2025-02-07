package b1_reloj;

public class Hora12 extends Hora {

	// atributos

	public enum Meridiano {
		AM, PM
	}

	protected Meridiano mer;

	// constructors

	public Hora12(int hora, int minuto, Meridiano mer) {
		// hora de 0 a 12
		super(hora, minuto); // el padre permite horas de 0 a 23
		setHora(hora); // agregamos nuestro método setHORA
		this.mer = mer;
	}

	// methods

	@Override
	public void setHora(int hora) {
		if (hora >= 1 && hora <= 12) {
			this.hora = hora;
		} else if (hora > 12) {
			hora -= 12;
			this.hora = hora;
			cambiarMeridiano();
		}
	}

	@Override
	public void inc() {
		super.inc();
		if (hora == 13) {
			hora = 1;
			cambiarMeridiano();
		}
	}

	public void cambiarMeridiano() {
		if (this.mer == Meridiano.AM) {
			this.mer = Meridiano.PM;
		} else {
			this.mer = Meridiano.AM;
		}

	}

	@Override
	public String toString() {

		return super.toString() + mer;
	}

}