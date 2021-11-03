package ar.edu.unju.escminas.poo.principal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Particular;
import ar.edu.unju.escminas.poo.util.ComprasUtil;

public class Practicas {

	public static void main(String[] args) {
		//creacion de objeto a verificar
				Particular objeto = new Particular("Banco1",1,"san","tiago");
				// ingreso de articulos de prueba para un cliente particular
				Set<Articulo> articulos = new HashSet<Articulo>();
				Articulo articulo;
						articulo = new Articulo("heladera", null, 2, 20000);
						articulos.add(articulo);
						articulo = new Articulo("cocina", null, 1, 45000);
						articulos.add(articulo);
						articulo = new Articulo("termotanque", null, 1, 30000);
						articulos.add(articulo);
						articulo = new Articulo("ventilador", null, 3, 15000);
						articulos.add(articulo);
						
				//objeto.getCompras().add(hacerCompra(objeto, articulos));
				
				Long cantidad = objeto.getCompras().get(0).getCuotas().stream().count();
				
				Long esperado = (long) 24;
				System.out.println(cantidad);
				System.out.println(esperado);

	}

}
