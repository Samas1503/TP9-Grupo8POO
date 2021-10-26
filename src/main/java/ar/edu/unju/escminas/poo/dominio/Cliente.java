package ar.edu.unju.escminas.poo.dominio;

import java.util.Set;

public abstract class Cliente {
	
	//variables
	int idCliente;
	static int ashei = 1;
	String tipoCliente;
	Set<Compra> compras;
	
	//constructor
	public Cliente() {
		// TODO Auto-generated constructor stu
		this.idCliente = ashei++;
	}
	public Cliente( String tipoCliente, Set<Compra> compras) {
		super();
		this.idCliente = ashei++;
		this.tipoCliente = tipoCliente;
		this.compras = compras;
	}


	//metodos get and set
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Set<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
	
	//metodo toString
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", tipoCliente=" + tipoCliente + ", compras=" + compras + "]";
	}
	
	public void agregarCompra(Compra compra) {
		this.getCompras().add(compra);
		
	}
	
}
