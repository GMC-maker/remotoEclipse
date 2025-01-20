package b1_herCaja;

public class PruebaCaja {

	public static void main(String[] args) {
		Caja caja1,caja2;
		
		caja1 = new Caja(100,100,200,Caja.Unidades.CM);
		caja1.etiqueta = "Ave de Panama No.27, Edificio Grijalba";		
		
		caja2 = new Caja(2.5f,2.5f,5.0f,Caja.Unidades.M);
		caja2.etiqueta = "Calle Carlos V, No. 12, Apto 5F";
		
		System.out.println(caja1);
		System.out.println("Volumen: " + caja1.getVolumen()+caja1.unit);
		
		System.out.println(caja2);
		System.out.println("Volumen: " + caja2.getVolumen()+caja2.unit);
		
	}

}
