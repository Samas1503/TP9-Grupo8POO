package ar.edu.unju.escminas.poo.principal;

import ar.edu.unju.escminas.poo.tablas.TablaArticulos;
import ar.edu.unju.escminas.poo.tablas.TablaClientes;
import ar.edu.unju.escminas.poo.util.MenuPrincipal;

public class Principal {

	public static void main(String[] args) {

		TablaClientes tablaClientes = new TablaClientes();
		TablaArticulos tablaArticulos = new TablaArticulos();
		MenuPrincipal menuprincipalUtil = new MenuPrincipal();

		int opcion = 0;

		do {
			menuprincipalUtil.menu(opcion, tablaClientes, tablaArticulos);

		} while (opcion != 7);
	}

}
