package b1_her;

public class ProbarHora {

	public static void main(String[] args) {

		Hora hh = new Hora(11, 30);
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
		Hora12 hh2 = new Hora12(12, 10, Hora12.Meridiano.AM);

		System.out.println(hh2);

		hh2.setHora(24);
		hh2.setMinutos(0);

		System.out.println(hh2);
		System.out.println();
		
		//HoraExacta 
		System.out.println("Hora Exacta ");
		
		HoraExacta hh3 = new HoraExacta(15,15,15);
		System.out.println(hh3);
		System.out.println();
		
		System.out.println("Metodo Equals Hora Exacta ");
		HoraExacta a = new HoraExacta(10,9,8);
		HoraExacta b = new HoraExacta(10,9,8);
		HoraExacta c = new HoraExacta(10,20,30);
		
		System.out.println("  " + a.equals(b));
		System.out.println("  " + a.equals(c));
	
	}

}
