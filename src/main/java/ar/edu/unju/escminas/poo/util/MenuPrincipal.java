package ar.edu.unju.escminas.poo.util;

import java.util.Scanner;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Particular;
import ar.edu.unju.escminas.poo.tablas.TablaArticulos;
import ar.edu.unju.escminas.poo.tablas.TablaClientes;

public class MenuPrincipal {
		public MenuPrincipal() {
			// TODO Auto-generated constructor stub
		}
		
		public void menu (int opcion, TablaClientes tablaClientes,TablaArticulos tablaArticulos) {
			ComprasUtil compraUtil = new ComprasUtil();
			ArticulosUtil articuloUtil = new ArticulosUtil();
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
				
				//verifico tarjeta de banco correcto
				if (cliente.getTarjeta() == "Banco1" || cliente.getTarjeta() == "Banco2"|| cliente.getTarjeta() == "Banco3") {
				
					cliente.getCompras().add(compraUtil.hacerCompra(cliente, articuloUtil.seleccionarArticulos()));
					
					System.out.println("la compra fue realizada con exito");
				}
				else
					System.out.println("el cliente seleccionado no posee una tarjeta valida. Pague al contado");
				break;
				
			case 2:
				float deuda = 0;
				for(Cliente p : tablaClientes.getClientes())
				{
					System.out.println("CLIENTE: "+ p );
					for(Compra t : p.getCompras())
					{
						System.out.println("CUOTAS PAGADAS de la compra: "+ t);
						t.getCuotas().stream().filter(n -> n.getDiaPagado() != null).forEach(System.out::println);
						System.out.println("CUOTAS NO PAGADAS de la compra: "+ t);
						t.getCuotas().stream().filter(n -> n.getDiaPagado() == null).forEach(System.out::println);
						
						//saco el monto de uno y lo multiplico 
						for(Cuota c : t.getCuotas()) {
							deuda += c.getMonto() *  t.getCuotas().stream().filter(n -> n.getDiaPagado() == null).count();
							break;
						}
							
						
					}
					System.out.println("Cantidad de deuda total: " + deuda);
					
				}
				break;
				
			case 3:
				tablaClientes.listarClientes();
				System.out.println("elija un cliente a travez de su id");
				//try catch
				cliente = tablaClientes.seleccionarClienteId(sc.nextInt());
				
				System.out.println("el cliente tiene las siguientes compras: ");
				cliente.getCompras().stream().forEach(System.out::println);
				
				Compra compraEncontrada = compraUtil.seleccionarCompra(cliente);
				compraUtil.pagarCuota(compraEncontrada);
				
				System.out.println("la cuota fue pagada");
				break;
				
			case 4:
				tablaClientes.listarClientes();
				System.out.println("elija un cliente a travez de su id");
				//try catch
				cliente = tablaClientes.seleccionarClienteId(sc.nextInt());
				
				for(Compra p: cliente.getCompras()) {
					System.out.println("por la compra: " + p + "el cliente debe las siguientes cuotas");
					p.getCuotas().stream().filter(n -> n.getDiaPagado() == null).forEach(System.out::println);
				}
				
				break;
				
			case 5:
				System.out.println("hola ashei");
				break;
			}
		}
		

}

