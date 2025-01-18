package b1_herencia;

public class HoraExacta extends Hora {
	
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


	@Override
	public boolean equals(Object obj) {
		HoraExacta hh4 = (HoraExacta) obj ; //esto es un cast de objeto, ya que para comparar tiene que ser dos elementos iguales.
		boolean sonIguales = false; 
		if (this.hora == hh4.hora
				&& this.minuto == hh4.minuto 
				&& this.segundos == hh4.segundos) {
				sonIguales = true;
		}
			
		return sonIguales;
	}
	
	
	
	

}
