package ar.edu.unju.escminas.poo.dominio;

public class Articulo {
	// variables
	private int idArticulo;
	private static int auto = 1;
	private String nombre;
	private String modelo;
	private float precio;
	// producto almacenado
	private int stock;
	// producto comprado
	private int cantidad;

	// constructor
	public Articulo() {

		this.idArticulo = auto++;
	}

	// constructor para producto almacenado
	public Articulo(String nombre, int stock, String modelo, float precio) {
		super();
		this.idArticulo = auto++;
		this.nombre = nombre;
		this.stock = stock;
		this.modelo = modelo;
		this.precio = precio;
	}

	// constructor para producto almacenado
	public Articulo(String nombre, String modelo, int cantidad, float precio) {
		super();
		this.idArticulo = auto++;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.modelo = modelo;
		this.precio = precio;
	}

	// get and set

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// metodo toString para Articulo almacenado

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombre=" + nombre + ", stock=" + stock + ", modelo=" + modelo
				+ ", precio=" + precio + "]";
	}

	// metodo toString para articulo comprado

	public String toString2() {
		return "Articulo [idArticulo=" + idArticulo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", modelo="
				+ modelo + "]";
	}

}
