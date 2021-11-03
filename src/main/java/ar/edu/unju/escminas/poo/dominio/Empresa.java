package ar.edu.unju.escminas.poo.dominio;

public class Empresa extends Cliente {

	// variables
	private String nombre;
	private String representante;

	// constructores
	public Empresa() {

	}

	public Empresa(String tarjeta, String nombre, String representante) {
		super(tarjeta);
		this.nombre = nombre;
		this.representante = representante;
	}

	// get and set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	// metodo toString
	@Override
	public String toString() {
		return "Empresa [idCliente=" + this.getIdCliente() + ", representante=" + representante + ", nombre=" + nombre
				+ ", tarjeta=" + this.getTarjeta() + "]";
	}

}
