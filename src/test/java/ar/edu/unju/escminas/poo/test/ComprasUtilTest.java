package ar.edu.unju.escminas.poo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Particular;
import ar.edu.unju.escminas.poo.util.ComprasUtil;
import junit.framework.TestCase;

public class ComprasUtilTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		System.out.println("inicia test");
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("finaliza el test");
		super.tearDown();
	}

	// cliente particular / heladera / 100.000 pesos
	@Test
	public void testVerificarHacerCompra() {
		Particular santy = new Particular("Banco1", new HashSet<Compra>(), 1, "santy", "tinty");

		Set<Articulo> articulos = new HashSet<>();
		Articulo a = new Articulo("heladera", 20, "samsum", 90000);
		articulos.add(a);
		a = new Articulo("cocina", 15, "limpio", 80000);
		articulos.add(a);

		Set<Cuota> cuotas = new HashSet<Cuota>();
		Cuota cuota1 = new Cuota(50000, LocalDate.of(2021, 11, 15));
		Cuota cuota2 = new Cuota(50000, LocalDate.of(2021, 12, 15));
		cuotas.add(cuota1);
		cuotas.add(cuota2);

		Compra compraTest = new Compra();
		compraTest.setIdCompra(2);
		compraTest.setArticulos(articulos);
		compraTest.setCuotas(cuotas);
		santy.getCompras().add(compraTest);
		assertEquals(compraTest, ComprasUtil.hacerCompra(santy, articulos));

	}

}
