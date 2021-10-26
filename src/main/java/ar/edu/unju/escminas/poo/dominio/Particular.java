package ar.edu.unju.escminas.poo.dominio;

import java.util.Set;

public class Particular extends Cliente{
	
	//variables
	int dni;
	String nombre;
	String apellido;
	
	//constructores
	public Particular() {
		// TODO Auto-generated constructor stub
	}
	public Particular(int idCliente, String tipoCliente, Set<Compra> compras,int dni, String nombre, String apellido) {
		super(tipoCliente, compras);
		// TODO Auto-generated constructor stub
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//get and set

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
		return "Particular [dni=" + dni + 
				", nombre=" + nombre + 
				", apellido=" + apellido +
				" ,idCliente=" + this.getIdCliente() + 
				", tipoCliente=" + this.getTipoCliente() + 
				", compras=" + this.getCompras() +"]";
	}
	

	
}
