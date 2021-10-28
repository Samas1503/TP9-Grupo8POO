package ar.edu.unju.escminas.poo.principal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;

public class Practicas {

	public static void main(String[] args) {
		LocalDate hola = LocalDate.now();
		hola = hola.plusMonths(3);
		System.out.println(hola);

		// ComprasUtil f = new ComprasUtil();
		Compra compraTest = new Compra();
		compraTest.setIdCompra(1);
		// Articulo a = new Articulo("heladera", 20, "samsum", 100000);
		// compraTest.setArticulo(a);

		Set<Cuota> cuotas = new HashSet<Cuota>();
		Cuota cuota1 = new Cuota(50000, LocalDate.of(2021, 11, 15));
		Cuota cuota2 = new Cuota(50000, LocalDate.of(2021, 12, 15));
		cuotas.add(cuota1);
		cuotas.add(cuota2);

		compraTest.setCuotas(cuotas);

		// Particular santy = new Particular("Banco1", null, 1, "santy", "tinty");

		System.out.println(compraTest);
		// System.out.println(f.hacerCompra(santy, a, 2));

	}

}
