package ar.edu.unju.escminas.poo.tablas;

import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;

public class TablaArticulos {
	Set<Articulo> articulos;

	public TablaArticulos() {

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

	public Articulo seleccionarArticuloId() {
		Articulo seleccionado = null;
		Scanner sc = new Scanner(System.in);
		int idArticulo = 0;
		
			
			System.out.println("elija un articulo segun su id");
			try {
				idArticulo = sc.nextInt();
			} catch (Exception e) {
				System.out.println("ingrese valores numericos");
			}	
	
			for (Articulo a : this.getArticulos()) {				
				if (a.getIdArticulo() == idArticulo)
					seleccionado = a;
			}
			if (seleccionado == null)
				System.out.println("no existe ese producto, intente de nuevo");

		return seleccionado;

	}
}
