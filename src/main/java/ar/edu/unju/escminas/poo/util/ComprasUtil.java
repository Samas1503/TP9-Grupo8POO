package ar.edu.unju.escminas.poo.util;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Particular;

public class ComprasUtil {

	Scanner sc = new Scanner(System.in);

	public ComprasUtil() {

	}

	public static Compra hacerCompra(Cliente cliente, Set<Articulo> articulos) {

		Compra nuevaCompra = new Compra();
		LocalDate hoy = LocalDate.now();
		LocalDate vencimiento = LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 15);
		float precioTotal = 0;
		int n;

		for (Articulo k : articulos) {
			// verifico que sea un articulo seleccionado
			if (ArticulosUtil.verificarArticuloSeleccionado(k)) {
				// saco el precio total a pagar
				precioTotal += k.getPrecio() * k.getCantidad();
				nuevaCompra.getArticulos().add(k);
			} else
				System.out.println("el articulo siguiente articulo debera pagarse al contado: " + k);
		}

		// asigno un plan correspondiente
		if (cliente instanceof Particular) {
			// cantidad de cuotas
			n = 24;
			// si el precio supera los 200.000 se le suma un 40% de interez
			if (precioTotal > 200000.00)
				precioTotal += precioTotal * 0.4;
		} else {
			// cantidad de cuotas
			n = 12;
			// si el precio supera los 500.000 se le suma un 40% de interez
			if (precioTotal > 500000.00)
				precioTotal += precioTotal * 0.4;
			// si no, entonces se le suma solo el 20% de interez
			else
				precioTotal += precioTotal * 0.2;
		}

		// creacion de las cuotas

		Set<Cuota> cuotas = new HashSet<>();

		for (int i = 1; i <= n; i++) {
			Cuota nuevaCuota = new Cuota(precioTotal / n, vencimiento.plusMonths(i));
			cuotas.add(nuevaCuota);
		}
		nuevaCompra.setCuotas(cuotas);
		return nuevaCompra;

	}

	public static Compra seleccionarCompra(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		Compra encontrada = null;
		int idCompra;

		System.out.println("elija una compra mediante su idCompra");
		// try catch

		do {
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

	public static void pagarCuota(Compra compra) {
		for (Cuota pagar : compra.getCuotas()) {
			if (pagar.getDiaPagado() == null) {
				pagar.setDiaPagado(LocalDate.now());
				break;
			}
		}
	}
}
