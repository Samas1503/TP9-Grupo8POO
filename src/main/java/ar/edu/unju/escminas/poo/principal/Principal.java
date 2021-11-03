package ar.edu.unju.escminas.poo.principal;

import ar.edu.unju.escminas.poo.tablas.TablaArticulos;
import ar.edu.unju.escminas.poo.tablas.TablaClientes;
import ar.edu.unju.escminas.poo.util.MenuPrincipal;
import ar.edu.unju.escminas.poo.util.TablaArticulosUtil;
import ar.edu.unju.escminas.poo.util.TablaClientesUtil;

public class Principal {

	public static void main(String[] args) {

		TablaClientes tablaClientes = new TablaClientes();
		TablaArticulos tablaArticulos = new TablaArticulos();

		tablaClientes.setClientes(TablaClientesUtil.cargarClientes());

		tablaArticulos.setArticulos(TablaArticulosUtil.cargarArticulos());

		int opcion = 0;

		do {
			opcion = MenuPrincipal.menu(opcion, tablaClientes, tablaArticulos);
		} while (opcion != 7);
	}

}
