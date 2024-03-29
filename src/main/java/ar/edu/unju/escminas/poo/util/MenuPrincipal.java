package ar.edu.unju.escminas.poo.util;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.tablas.TablaArticulos;
import ar.edu.unju.escminas.poo.tablas.TablaClientes;

public class MenuPrincipal {
	public MenuPrincipal() {
	}

	public static float deudaCompra(Compra compra) {
		float deuda = 0;
		for (Cuota c : compra.getCuotas()) {
			deuda = c.getMonto() * compra.getCuotas().stream().filter(n -> n.getDiaPagado() == null).count();
			break;
		}
		return deuda;
	}

	public static int menu(int opcion, TablaClientes tablaClientes, TablaArticulos tablaArticulos) {
		Scanner sc = new Scanner(System.in);
		boolean pagado = true;
		Cliente cliente = null;
		Set<Articulo> articulos = null;

		System.out.println("******MENU********");
		System.out.println("1. crear y agregar al sistema una compra ");
		System.out.println("2. listar clientes mas cuotas pagadas, cuotas por pagar, monto por pagar ");
		System.out.println("3. registrar el pago de las cuotas");
		System.out.println("4. cuotas no pagadas de un cliente");
		System.out.println("5. dinero por cobrar");
		System.out.println("6. cliente con menos deuda");
		System.out.println("7. salir");
		System.out.println("elija una opcion");

		do {
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				System.out.println("ocurrio un error, intente de nuevo");
				opcion = -1;
			}
		} while (opcion < 1 || opcion > 7);

		switch (opcion) {

		case 1:
			tablaClientes.listarClientes();
			System.out.println("elija un cliente a travez de su id");

			try {
				cliente = tablaClientes.seleccionarClienteId(sc.nextInt());
			} catch (Exception e) {
				System.out.println("ocurrio un error, intente de nuevo");
				break;
			}

			tablaArticulos.listarArticulos();
			try {
				articulos = ArticulosUtil.seleccionarArticulos(tablaArticulos);
			} catch (Exception e) {
				System.out.println("ocurrio un error, intente de nuevo");
				break;
			}

			if (articulos == null) {
				System.out.println("no realizo ninguna compra");
			} else {
				// verifico tarjeta de banco correcto
				if (cliente.getTarjeta() == "Banco1" || cliente.getTarjeta() == "Banco2"
						|| cliente.getTarjeta() == "Banco3") {
					// en caso de que no haya ninguna compra registrada se crea un arreglo nuevo
					if (cliente.getCompras() == null)
						cliente.setCompras(new ArrayList<Compra>());
					// si ya existen compras se agrega al array
					cliente.getCompras().add(ComprasUtil.hacerCompra(cliente, articulos));
					System.out.println("realizo una compra con exito");
				} else
					System.out.println("el cliente seleccionado no posee una tarjeta valida. Pague al contado");
			}

			break;

		case 2:
			float deuda = 0;
			for (Cliente p : tablaClientes.getClientes()) {
				System.out.println("CLIENTE: " + p);
				if (p.getCompras() != null) {
					for (Compra t : p.getCompras()) {
						System.out.println("CUOTAS PAGADAS de la compra: " + t);
						t.getCuotas().stream().filter(n -> n.getDiaPagado() != null).forEach(System.out::println);
						System.out.println("CUOTAS NO PAGADAS de la compra: " + t);
						t.getCuotas().stream().filter(n -> n.getDiaPagado() == null).forEach(System.out::println);

						deuda += deudaCompra(t);

					}
					System.out.println("Cantidad de deuda total del cliente: " + deuda);
					deuda = 0;
				} else
					System.out.println("El cliente" + p.getIdCliente() + "no registra ninguna compra");
			}
			break;

		case 3:
			tablaClientes.listarClientes();
			System.out.println("elija un cliente a travez de su id");
			// try catch
			cliente = tablaClientes.seleccionarClienteId(sc.nextInt());
			if (cliente.getCompras() == null)
				System.out.println("El cliente no tiene compras");
			else {
				System.out.println("el cliente tiene las siguientes compras: ");
				cliente.getCompras().stream().forEach(System.out::println);

				Compra compraEncontrada = ComprasUtil.seleccionarCompra(cliente);
				pagado = ComprasUtil.pagarCuota(compraEncontrada);
				if (pagado)
					System.out.println("la cuota fue pagada");
				else
					System.out.println("la compa ya fue pagada en su totalidad");
			}
			break;

		case 4:
			tablaClientes.listarClientes();
			System.out.println("elija un cliente a travez de su id");
			// try catch
			cliente = tablaClientes.seleccionarClienteId(sc.nextInt());

			if (cliente.getCompras() != null) {
				for (Compra p : cliente.getCompras()) {
					System.out.println("por la compra: " + p + "el cliente debe las siguientes cuotas");
					p.getCuotas().stream().filter(n -> n.getDiaPagado() == null).forEach(System.out::println);
				}
			} else
				System.out.println("El cliente " + cliente.getIdCliente() + " no registra ninguna compra");
			break;

		case 5:
			float deudaTotalEmpresa = 0;
			for (Cliente x : tablaClientes.getClientes()) {
				if (x.getCompras() != null) {
					for (Compra v : x.getCompras()) {
						deudaTotalEmpresa += deudaCompra(v);
					}
				}
			}
			System.out.println("la deuda total de todos los clientes hacia la empresa es de : " + deudaTotalEmpresa);
			break;
		case 6:
			Cliente favorito = null;
			float deudaCliente = 0, deudaMinima = 1000000000;
			for (Cliente c : tablaClientes.getClientes()) {
				if (c.getCompras() != null) {
					for (Compra p : c.getCompras()) {
						deudaCliente += deudaCompra(p);
					}
					if (deudaCliente < deudaMinima) {
						deudaMinima = deudaCliente;
						favorito = c;
					}
					deudaCliente = 0;
				}
			}
			if (favorito != null) {
				System.out.println("el cliente con menos deuda es: " + favorito);
				System.out.println("con una deuda de: " + deudaMinima);
			} else
				System.out.println("No hay clientes con compras realizadas");

			break;
		case 7:
			System.out.println("hasta luego");
			break;
		default:
			System.out.println("opcion no valida, intente de nuevo");
			break;
		}
		return opcion;
	}
}
