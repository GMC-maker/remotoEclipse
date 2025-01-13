package ferroviaria;

public class Mecanico {

	String nombreCompleto;
	String tlfn;
	String especialidad;

	// constructors

		public Mecanico(String nombreCompleto, String tlfn, String especialidad) {
		this.nombreCompleto = nombreCompleto;
		this.tlfn = tlfn;
		this.especialidad = especialidad;
	}

		public Mecanico() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Mecanico [nombreCompleto=" + nombreCompleto + ", tlfn=" + tlfn + ", especialidad=" + especialidad
					+ "]";
		}
		
		//methods
		
		
		//get - set
		
		

}
