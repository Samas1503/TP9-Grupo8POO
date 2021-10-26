package ar.edu.unju.escminas.poo.util;

import java.util.Scanner;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Particular;
import ar.edu.unju.escminas.poo.tablas.TablaArticulos;
import ar.edu.unju.escminas.poo.tablas.TablaClientes;

public class MenuPrincipal {
		public MenuPrincipal() {
			// TODO Auto-generated constructor stub
		}
		
		public void menu (int opcion, TablaClientes tablaClientes,TablaArticulos tablaArticulos) {
			ComprasUtil compraUtil = new ComprasUtil(); 
			Scanner sc = new Scanner(System.in);
			Cliente cliente = null;
			Articulo articulo = null;
			
			System.out.println("******MENU********");
			System.out.println("1. crear y agregar al sistema una compra ");
			System.out.println("2. listar clientes más cuotas pagadas, cuotas por pagar, monto por pagar ");
			System.out.println("3. registrar el pago de las cuotas");
			System.out.println("4. cuotas no pagadas de un cliente particular");
			System.out.println("5. dinero por cobrar");
			System.out.println("6. cliente con menos deuda");
			System.out.println("7. salir");
			System.out.println("elija una opcion");
			
			do {
				try {
					opcion = sc.nextInt();
				}catch (Exception e) 
				{
					System.out.println("ocurrio un error, intente de nuevo");
					opcion = -1;
				}
			}while (opcion < 1 && opcion > 7 );
			
			switch(opcion) {
			
			case 1: 
				tablaClientes.listarClientes();
				System.out.println("elija un cliente a travez de su id");
				//try catch
				cliente = tablaClientes.seleccionarClienteId(sc.nextInt());
				
				tablaArticulos.listarArticulos();
				System.out.println("elija un articulo a travez de su id");
				//try catch
				articulo = tablaArticulos.seleccionarArticuloId(sc.nextInt());
				
				if(cliente instanceof Particular) 
				{
					cliente.agregarCompra(compraUtil.hacerCompraParticular(articulo));
				}
					
				
			break;
			
			case 2:
				
			}
		}
		

}

