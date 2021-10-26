package ar.edu.unju.escminas.poo.dominio;

import java.util.Set;

public class Compra {
	//variables
	int idCompra;
	Articulo articulo;
	Set<Cuota> cuotas;
	
	//constructor
	public Compra() {
		// TODO Auto-generated constructor stub
	}
	
	public Compra(int idCompra, Articulo articulo, Set<Cuota> cuotas) {
		super();
		this.idCompra = idCompra;
		this.articulo = articulo;
		this.cuotas = cuotas;
	}

	//get and set
	
	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Set<Cuota> getCompras() {
		return cuotas;
	}

	public void setCompras(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	//metodo toString
	
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", articulo=" + articulo + ", compras=" + cuotas + "]";
	}
	
	
	
	
}
