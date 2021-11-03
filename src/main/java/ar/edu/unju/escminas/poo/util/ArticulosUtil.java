package ar.edu.unju.escminas.poo.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.tablas.TablaArticulos;

public class ArticulosUtil {

	public ArticulosUtil() {

	}

	public static Set<Articulo> seleccionarArticulos(TablaArticulos tablaArticulos) {
		Scanner sc = new Scanner(System.in);
		Set<Articulo> lista = null;
		String respuesta;
		int cantidad;
		Articulo encontrado = null;

		do {
	
			encontrado = tablaArticulos.seleccionarArticuloId();
			
			if(encontrado != null)
			{
				
				
				System.out.println("que cantidad de este articulo desea?");
				try {
					cantidad = sc.nextInt();
				} catch (Exception e) {
					System.out.println("ingrese valores numericos");
					cantidad = 0;
				}
				
				if (cantidad > encontrado.getCantidad())
					System.out.println("no hay suficiente stock");
				else {
					lista = new HashSet<>();
					Articulo comprado = new Articulo(encontrado.getNombre(), encontrado.getModelo(), 
							cantidad,encontrado.getPrecio());
					lista.add(comprado);
					// actualizar el stock
					encontrado.setCantidad(encontrado.getCantidad() - comprado.getCantidad());
				}

			}

			
			System.out.println("desea agregar otro articulo? si/no");
			try {
				respuesta = sc.next();
			} catch (Exception e) {
				System.out.println("ocurrio un error, se tomara como que no quiere agreagar otro producto");
				respuesta = "no";
			}
			
		} while (respuesta.equals("si"));

		return lista;
	}

	public static boolean verificarArticuloSeleccionado(Articulo articulo) {
		if (articulo.getNombre() == "heladera" || articulo.getNombre() == "lavarropa"
				|| articulo.getNombre() == "cocina" || articulo.getNombre() == "termotanque"
				|| articulo.getNombre() == "lavavagillas" || articulo.getNombre() == "ventilador")
			return true;
		else
			return false;

	}

}
