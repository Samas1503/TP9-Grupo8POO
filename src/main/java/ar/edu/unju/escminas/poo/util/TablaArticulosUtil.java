package ar.edu.unju.escminas.poo.util;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;

public class TablaArticulosUtil {

	public TablaArticulosUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Articulo> cargarArticulos(){
		Set<Articulo> articulos = new HashSet<Articulo>();
		
		//articulos seleccionados
		
		//Heladeras, lavarropas, cocinas, termotanques, lavavajillas y ventiladores.
		Articulo articulo = new Articulo ("heladera","hilux",200,50000);
		articulos.add(articulo);
		articulo = new Articulo ("heladera","samsum",190,55000);
		articulos.add(articulo);
		articulo = new Articulo ("lavarropa","hilux",180,60000);
		articulos.add(articulo);
		articulo = new Articulo ("lavarropa","samsum",170,65000);
		articulos.add(articulo);
		articulo = new Articulo ("cocina","hilux",190,80000);
		articulos.add(articulo);
		articulo = new Articulo ("cocina","samsum",110,75000);
		articulos.add(articulo);
		articulo = new Articulo ("termotanque","hilux",200,55000);
		articulos.add(articulo);
		articulo = new Articulo ("termotanque","samsum",180,50000);
		articulos.add(articulo);
		articulo = new Articulo ("lavavagillas","hilux",100,70000);
		articulos.add(articulo);
		articulo = new Articulo ("lavavagillas","samsum",110,55000);
		articulos.add(articulo);
		articulo = new Articulo ("ventilador","hilux",140,30000);
		articulos.add(articulo);
		articulo = new Articulo ("ventilador","samsum",130,25000);
		articulos.add(articulo);
			
		//articulos no seleccionados
		articulo = new Articulo ("microondas","samsum",100,55000);
		articulos.add(articulo);
		articulo = new Articulo ("televisor","samsum",100,55000);
		articulos.add(articulo);
		articulo = new Articulo ("computadora","samsum",100,55000);
		articulos.add(articulo);
		
		return articulos;
		
	}
}
