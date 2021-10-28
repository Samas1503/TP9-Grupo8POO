package ar.edu.unju.escminas.poo.dominio;

import java.util.HashSet;
import java.util.Set;

public class Compra {
	// variables
	private int idCompra;
	private static int auto = 1;
	private Set<Articulo> articulos;
	private Set<Cuota> cuotas;

	// constructor
	public Compra() {
		this.articulos = new HashSet<Articulo>();
		this.idCompra = auto++;
	}

	public Compra(Set<Articulo> articulos, Set<Cuota> cuotas) {
		super();
		this.idCompra = auto++;
		this.articulos = articulos;
		this.cuotas = cuotas;
	}

	// get and set

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	// metodo toString

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", articulos=" + articulos + "]";
	}

}
