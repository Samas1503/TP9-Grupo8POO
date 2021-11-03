package ar.edu.unju.escminas.poo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Cliente{

	// variables
	private int idCliente;
	private static int auto = 1;
	private List<Compra> compras;
	private String tarjeta;

	// constructor
	public Cliente() {
		this.idCliente = auto++;
		this.setCompras(new ArrayList<Compra>());
	}

	public Cliente(String tarjeta) {
		super();
		this.setCompras(new ArrayList<Compra>());
		this.idCliente = auto++;
		this.tarjeta = tarjeta;
	}

	// metodos get and set
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	// metodo toString
	// no se mostraran las compras para evitar redundancia de datos
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ",tarjeta=" + tarjeta + "]";
	}

}
