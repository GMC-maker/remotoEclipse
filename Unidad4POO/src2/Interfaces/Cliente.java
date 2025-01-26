package Interfaces;

import java.util.Objects;

public class Cliente {

	// attributes
	private String dni;
	private String nombre;
	private int edad;
	private double saldo;

	// constructors
	public Cliente(String dni, String nombre, int edad, double saldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.saldo = saldo;
	}
	
	// methods
	@Override
	public String toString() {
		return "Cliente[ " + dni + ", " + nombre + ", " + edad + ", " + saldo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(dni, obj.dni);
	}

	

}
