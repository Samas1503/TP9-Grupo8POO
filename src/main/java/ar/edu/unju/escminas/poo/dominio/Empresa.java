package ar.edu.unju.escminas.poo.dominio;

import java.util.Set;

public class Empresa extends Cliente {

	// variables
	private String nombre;
	private String representante;

	// constructores
	public Empresa() {

	}

	public Empresa(Set<Compra> compras, String tarjeta, String nombre, String representante) {
		super(compras, tarjeta);

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
		return "Empresa [nombre=" + nombre + ", representante=" + representante + ", idCliente=" + this.getIdCliente()
				+ ", tarjeta=" + this.getTarjeta() + "]";
	}

}
