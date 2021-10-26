package ar.edu.unju.escminas.poo.tablas;

import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;

public class TablaArticulos {
	Set<Articulo> articulos;
	
	public TablaArticulos() {
		// TODO Auto-generated constructor stub
	}

	public Set<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Set<Articulo> articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "TablaArticulos [articulos=" + articulos + "]";
	}
	
	public void listarArticulos() {
		this.getArticulos().stream().forEach(System.out::println);
	}
	
	public Articulo seleccionarArticuloId(int idArticulo) {
		Articulo seleccionado = null;
		for(Articulo a : this.getArticulos())
		{
			if(a.getIdArticulo() == idArticulo)
				seleccionado = a;
		}
		return seleccionado;
		
	}
}
