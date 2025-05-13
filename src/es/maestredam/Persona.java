package es.maestredam;

public class Persona implements java.io.Serializable {
	// Serial ID (recomendable para serialización de objetos)
	private static final long serialVersionUID = 7943224216197675682L;
	
	private String nombre;
	private boolean mayorEdad;
	private double saldo;
	
	public Persona(String nombre, boolean mayorEdad, double saldo) {
		this.nombre=nombre;
		this.mayorEdad=mayorEdad;
		this.saldo=saldo;
	}
	// GETTERS & SETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		if (saldo<0) {
			throw new IllegalArgumentException("Saldo negativo");
		}else {
		this.saldo = saldo;
		}
	}
	
	// Sobrescribo toString
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", mayorEdad=" + mayorEdad + ", saldo=" + saldo + "]";
	}
	

}
