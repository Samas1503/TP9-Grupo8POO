package ar.edu.unju.escminas.poo.dominio;

public class Articulo {
	//variables
	int idArticulo;
	String nombre;
	int stock;
	String modelo;
	float precio;
	
	//constructor
	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public Articulo(int idArticulo, String nombre, int stock, String modelo,float precio) {
		super();
		this.idArticulo = idArticulo;
		this.nombre = nombre;
		this.stock = stock;
		this.modelo = modelo;
		this.precio = precio;
	}
	
	//get and set
	
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
	
	//metodo toString

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo +
				", nombre=" + nombre +
				", stock=" + stock + 
				", modelo=" + modelo+ 
				", precio=" + precio+ "]";
	}
	

	
}
