package ar.edu.unju.escminas.poo.dominio;

import java.util.Set;

public class Empresa extends Cliente{

	//variables
    String nombre;
    String representante;
    
    //constructores
    public Empresa() {
		// TODO Auto-generated constructor stub
	}

	public Empresa(int idCliente, String tipoCliente, Set<Compra> compras, String nombre, String representante) {
		super(tipoCliente, compras);
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.representante = representante;
	}

	//get and set
	
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
	
	//metodo toString
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + 
				", representante=" + representante + 
				", idCliente=" + this.getIdCliente() + 
				", tipoCliente=" + this.getTipoCliente() + 
				", compras=" + this.getCompras() +"]";
	}

	
	
}
