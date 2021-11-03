package ar.edu.unju.escminas.poo.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Particular;

public class ComprasUtil {

	Scanner sc = new Scanner(System.in);

	public ComprasUtil() {

	}

	public void filtrarArticulos(Compra nuevaCompra, Set<Articulo> articulos, float precioTotal) {
		for (Articulo k : articulos) {
			// verifico que sea un articulo seleccionado
			if (ArticulosUtil.verificarArticuloSeleccionado(k)) {
				// saco el precio total a pagar
				precioTotal += k.getPrecio() * k.getCantidad();
				nuevaCompra.getArticulos().add(k);
			} else
				System.out.println("el articulo siguiente articulo debera pagarse al contado: " + k);
		}
	}

	// hacer test
	public static float calcularPrecioTotal(Set<Articulo> articulos) {
		float precio = 0;
		for (Articulo a : articulos) {
			precio += a.getPrecio();
		}
		return precio;
	}

	public static float calcularPrecioTotalCredito(Cliente cliente, float precioTotal) {
		// asigno un plan correspondiente
		if (cliente instanceof Particular) {
			// si el precio supera los 200.000 se le suma un 40% de interez
			if (precioTotal > 200000.00)
				precioTotal += precioTotal * 0.4;
		} else {
			// si el precio supera los 500.000 se le suma un 40% de interez
			if (precioTotal > 500000.00)
				precioTotal += precioTotal * 0.4;
			// si no, entonces se le suma solo el 20% de interez
			else
				precioTotal += precioTotal * 0.2;
		}
		return precioTotal;
	}


	// hacer test
	public static Set<Cuota> agregarCuotas(Set<Cuota> cuotas, float precioTotal, Cliente cliente) {
		LocalDate hoy = LocalDate.now();
		LocalDate vencimiento = LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 15);
		int n;
		// determina las cuotas del cliente
				if (cliente instanceof Particular) {
					// cantidad de cuotas
					n = 24;
				} else {
					// cantidad de cuotas
					n = 12;
				};
		
		for (int i = 1; i <= n; i++) {
			Cuota nuevaCuota = new Cuota (precioTotal/n,vencimiento.plusMonths(i));
			cuotas.add(nuevaCuota);
		}
		return cuotas;
	}

	public static Compra hacerCompra(Cliente cliente, Set<Articulo> articulos) {

		Compra nuevaCompra = new Compra();
		float precioTotal = 0;

		// determinar precio total
		precioTotal = calcularPrecioTotal(articulos);

		// determina el precio verdadero
		precioTotal = calcularPrecioTotalCredito(cliente, precioTotal);

		// creacion de las cuotas
		Set<Cuota> cuotas = new TreeSet<Cuota>();
		cuotas = agregarCuotas(cuotas, precioTotal,cliente);

		nuevaCompra.setCuotas(cuotas);
		return nuevaCompra;
	}

	public static Compra seleccionarCompra(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		Compra encontrada = null;
		int idCompra;

		System.out.println("elija una compra mediante su idCompra");

		do {
			//try catch
			idCompra = sc.nextInt();
			for (Compra c : cliente.getCompras()) {
				if (c.getIdCompra() == idCompra)
					encontrada = c;
			}
			if (encontrada == null)
				System.out.println("idCompra no valida, intente de nuevo");
		} while (encontrada == null);

		return encontrada;
	}

	public static boolean pagarCuota(Compra compra) {
		boolean pagado = false;
		for (Cuota pagar : compra.getCuotas()) {
			if (pagar.getDiaPagado() == null) {
				pagar.setDiaPagado(LocalDate.now());
				pagado = true;
				break;
			}
		}
		return pagado;
	}
}
