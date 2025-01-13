package Banco;

public class CuentaCorriente {
	// atributos
	private double saldo;
	public String nombreTitular;
	String dniTitular;
	private int limiteDescubierto;
	
	private static String nombreBanco = "Atlantik";//Actividad 4


	// constructores
	//Actividad 1
	public CuentaCorriente(String nombreTitular, String dniTitular) {
		this.nombreTitular = nombreTitular;
		this.dniTitular = dniTitular;
		saldo = 0;
		limiteDescubierto = -50;
	}

		//actividad 2 sobrecargar
	public CuentaCorriente(float saldo) {
		this.saldo = saldo;
		limiteDescubierto = 0;
	}
	
	public CuentaCorriente(float saldo, int limiteDescubierto, String dniTitular) {
		this.saldo = saldo;
		this.limiteDescubierto = limiteDescubierto;
		this.dniTitular = dniTitular;
		
	}
	

	// metodos 
	// Sacar Dinero
	public boolean Retirar(float dinero) {
		boolean aprobado;
		if (saldo - dinero > -50) {
			saldo -= dinero;
			aprobado = true;
		} else {
		aprobado = false;
	} 
	return aprobado;
}
//ingresar dinero
	public void ingresarDinero(int dinero) {
		saldo += dinero;
	}

	public void ingresarDinero(float dinero) {
		saldo += dinero;
	}
	
	
	
	//mostrar objeto cuenta corriente
	@Override
	public String toString() {
		return "CuentaCorriente [saldo=" + saldo + ", limiteDescubierto=" + limiteDescubierto + ", nombreTitular="
				+ nombreTitular + ", dniTitular=" + dniTitular + "]";
	}

	//getters y setters
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getLimiteDescubierto() {
		return limiteDescubierto;
	}

	public void setLimiteDescubierto(int limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}
	
	//Actividad 4 Modificar Nombre del banco.
	public static String getNombreBanco() {
		return nombreBanco;
	}

	public static void setNombreBanco(String nombreBanco) {
		CuentaCorriente.nombreBanco = nombreBanco;
	}


}
