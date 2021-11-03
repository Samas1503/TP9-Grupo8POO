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
		MenuPrincipal menuprincipalUtil = new MenuPrincipal();
		
		TablaClientesUtil tablaClientesUtil = new TablaClientesUtil();
		tablaClientes.setClientes(tablaClientesUtil.cargarClientes());
		
		TablaArticulosUtil tablaArticulosUtil = new TablaArticulosUtil();
		tablaArticulos.setArticulos(tablaArticulosUtil.cargarArticulos());
		
		int opcion = 0;

		do {
			menuprincipalUtil.menu(opcion, tablaClientes, tablaArticulos);

		} while (opcion != 7);
	}

}
