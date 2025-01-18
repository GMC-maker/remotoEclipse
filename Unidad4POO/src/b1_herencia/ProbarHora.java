package b1_herencia;

public class ProbarHora {

	public static void main(String[] args) {

		E1_Hora hh = new E1_Hora(11, 30);
		System.out.println("HORA");
		System.out.println(hh);

		hh.inc();// invocamos el metodo para aumentar en 1 minuto
		System.out.println(hh);

		// cambiamos la hora.
		hh.setHora(24);

		// cambiamos minutos
		hh.setMinutos(15);
		System.out.println(hh);
		System.out.println();

		// Hora12
		System.out.println("HORA 12");
		E2_Hora12 hh2 = new E2_Hora12(12, 10, E2_Hora12.Meridiano.AM);

		System.out.println(hh2);

		hh2.setHora(24);
		hh2.setMinutos(0);

		System.out.println(hh2);
		System.out.println();
		
		//HoraExacta 
		System.out.println("Hora Exacta ");
		
		HoraExacta hh3 = new HoraExacta(15,15,15);
		System.out.println(hh3);

	}

}
