package b1_herencia;

public class HoraExacta extends E1_Hora {
	
	protected int segundos;

	public HoraExacta(int hora, int minuto, int segundos) {
		super(hora, minuto);
		this.segundos = segundos;
	}


	public void setSegundos(int segundos) {
		if (segundos > 0 && segundos  < 60) {
		this.segundos = segundos;
		
		} else if (segundos >= 60) {
			this.segundos -= 60;
			setMinutos(this.minuto++);
		}
	}


	@Override
	public void inc() {
		segundos ++;
		if(segundos > 60) {
			segundos = 0;
			super.inc();//incrementa 1 minuto
		}
	}


	@Override
	public String toString() {
		return "[" + hora + ":" + minuto + ":"+ segundos +"]";
	}
	
	
	
	

}
