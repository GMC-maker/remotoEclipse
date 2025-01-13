package Banco;

public class Principal {

	public static void main(String[] args) {

		CuentaCorriente cc1 = new CuentaCorriente("Pepe", "796R");
		System.out.println(cc1.getLimiteDescubierto());
		System.out.println(cc1.nombreTitular);

		System.out.println(cc1.getSaldo());
		// depositar
		cc1.ingresarDinero(1000);
		cc1.ingresarDinero(200);
		System.out.println(cc1.getSaldo());

		// retiro
		if (!cc1.Retirar(65.5f)) {
			System.out.println("Fondos Insufiencientes");
		} else {
			System.out.println("Transaccion Realizada, tu saldo actual es: " + cc1.getSaldo());
		}

		// Actividad 2 - constructor sobrecargado

		CuentaCorriente cc2 = new CuentaCorriente(250);
		System.out.println(cc2.getSaldo());
		System.out.println();
		
		
		CuentaCorriente cc3 = new CuentaCorriente(250f,-10, "Y98R");
		
		//Actividad 3
		
		// Public: Acceso permitido
        System.out.println("Nombre del titular: " + cc1.nombreTitular); // OK

        // Private: Acceso no permitido 
        System.out.println(cc2.getSaldo());           // saldo es privado ahora necesita GETTERS y SETTERS
        System.out.println(cc2.getLimiteDescubierto());  // 

        // Protected: Acceso permitido dentro del mismo paquete
        System.out.println("DNI: " + cc3.dniTitular); // OK porque está en el mismo paquete
		
		//Actividad 4
        
        
        
        
	}

}
