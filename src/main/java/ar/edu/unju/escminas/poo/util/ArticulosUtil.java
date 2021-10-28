package ar.edu.unju.escminas.poo.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.tablas.TablaArticulos;

public class ArticulosUtil {

	public ArticulosUtil() {

	}

	public Set<Articulo> seleccionarArticulos() {
		Scanner sc = new Scanner(System.in);
		TablaArticulos tablaArticulos = new TablaArticulos();
		Set<Articulo> lista = new HashSet<>();
		String respuesta;
		int cantidad;
		Articulo encontrado;

		do {

			System.out.println("elija un articulo segun su id");
			encontrado = tablaArticulos.seleccionarArticuloId(sc.nextInt());

			System.out.println("que cantidad de este articulo desea?");
			// try - catch
			cantidad = sc.nextInt();
			if (cantidad > encontrado.getStock())
				System.out.println("no hay suficiente stock");
			else {
				Articulo comprado = new Articulo(encontrado.getNombre(), encontrado.getModelo(), cantidad,
						encontrado.getPrecio());
				lista.add(comprado);
				// actualizar el stock
				encontrado.setStock(encontrado.getStock() - comprado.getCantidad());
			}

			System.out.println("desea agregar otro articulo?");
			// try-catch
			respuesta = sc.next();
		} while (respuesta != "no" || respuesta != "NO");

		return lista;
	}

	public boolean verificarArticuloSeleccionado(Articulo articulo) {
		if (articulo.getNombre() == "heladera" || articulo.getNombre() == "lavarropa"
				|| articulo.getNombre() == "cocina" || articulo.getNombre() == "termotanque"
				|| articulo.getNombre() == "lavavagillas" || articulo.getNombre() == "ventiladores")
			return true;
		else
			return false;

	}

}
