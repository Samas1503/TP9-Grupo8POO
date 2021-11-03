package ar.edu.unju.escminas.poo.dominio;

public class Particular extends Cliente {

	// variables
	private int dni;
	private String nombre;
	private String apellido;

	// constructores
	public Particular() {
	}

	public Particular(String tarjeta, int dni, String nombre, String apellido) {
		super(tarjeta);
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// get and set

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Particular [idCliente=" + this.getIdCliente() + ", nombre=" + nombre + ", apellido=" + apellido
				+ " ,dni=" + dni + ", tarjeta=" + this.getTarjeta() + "]";
	}

}
