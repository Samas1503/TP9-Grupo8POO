package ar.edu.unju.escminas.poo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Cuota;
import ar.edu.unju.escminas.poo.dominio.Empresa;
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

	// * Determinar que las cuotas generadas no tengan el valor null
	@Test
	public void determinarCuotaValidaTest() {
		LocalDate vencimiento = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(),
				LocalDate.now().getDayOfMonth());

		int precioCompraParticular = 120000;
		float montoParticular = precioCompraParticular / 24;
		Cuota cuotaEjemploParticular = new Cuota(montoParticular, vencimiento);

		int precioCompraEmpresa = 48000;
		float montoEmpresa = precioCompraEmpresa / 12;
		Cuota cuotaEjemploEmpresa = new Cuota(montoEmpresa, vencimiento);

		assertEquals(cuotaEjemploParticular, ComprasUtil.generarCuota(montoParticular, vencimiento));
		assertEquals(cuotaEjemploEmpresa, ComprasUtil.generarCuota(montoEmpresa, vencimiento));
	}

	// * Determinar que la cantidad de cuotas de un usuario sea la correcta
	@Test
	public void determinarCantidadCuotasTest() {
		Cliente particular = new Particular();
		int cantP = 24;

		Cliente empresa = new Empresa();
		int cantE = 12;

		assertEquals(cantP, ComprasUtil.determinarCuotas(particular));
		assertEquals(cantE, ComprasUtil.determinarCuotas(empresa));
	}

	// * Determinar que el comnto total del credito sea correcto
	@Test
	public void calcularPrecioTotalCreditoTest() {
		Cliente cliente = new Particular();
		Set<Articulo> articulos = new HashSet<>();
		Articulo articulo;
		float precio;

		// * Caso 1 particular
		// ingreso de articulos de prueba para un cliente particular
		articulo = new Articulo("heladera", null, 2, 20000);
		articulos.add(articulo);
		articulo = new Articulo("cocina", null, 1, 45000);
		articulos.add(articulo);
		articulo = new Articulo("termotanque", null, 1, 30000);
		articulos.add(articulo);
		articulo = new Articulo("ventilador", null, 3, 15000);
		articulos.add(articulo);

		// calcula el monto total del Set de articulos
		precio = ComprasUtil.calcularPrecioTotal(articulos);

		// calcula el precio que debe pagar el cliente
		precio = ComprasUtil.calcularPrecioTotalCredito(cliente, precio);

		assertEquals(160000, ComprasUtil.calcularPrecioTotalCredito(cliente, precio));

		// * Fin caso 1

		// elimina todos los elementos del collection
		articulos.removeAll(articulos);

		// * Caso 2 Particular
		// ingreso de articulos de prueba para un cliente particular
		articulo = new Articulo("heladera", null, 2, 20000);
		articulos.add(articulo);
		articulo = new Articulo("cocina", null, 2, 45000);
		articulos.add(articulo);
		articulo = new Articulo("termotanque", null, 1, 30000);
		articulos.add(articulo);
		articulo = new Articulo("ventilador", null, 3, 15000);
		articulos.add(articulo);

		// calcula el monto total del Set de articulos
		precio = ComprasUtil.calcularPrecioTotal(articulos);

		// calcula el precio que debe pagar el cliente
		precio = ComprasUtil.calcularPrecioTotalCredito(cliente, precio);

		assertEquals(278000, ComprasUtil.calcularPrecioTotalCredito(cliente, precio));

		// * Fin caso 2

		// elimina todos los elementos del collection
		articulos.removeAll(articulos);

		// * Caso 1 Empresa

		Cliente empresa = new Empresa();

		// ingreso de articulos de prueba para una empresa
		articulo = new Articulo("heladera", null, 3, 20000);
		articulos.add(articulo);
		articulo = new Articulo("cocina", null, 3, 45000);
		articulos.add(articulo);
		articulo = new Articulo("termotanque", null, 4, 30000);
		articulos.add(articulo);
		articulo = new Articulo("lavarropas", null, 3, 60000);
		articulos.add(articulo);

		// calcula el monto total del Set de articulos
		precio = ComprasUtil.calcularPrecioTotal(articulos);

		// calcula el precio que debe pagar el cliente
		precio = ComprasUtil.calcularPrecioTotalCredito(empresa, precio);

		assertEquals(5000, ComprasUtil.calcularPrecioTotalCredito(cliente, precio));

		// * Fin caso 1

		articulos.removeAll(articulos);

		// * Caso 2 Empresa

		// ingreso de articulos de prueba para una empresa
		articulo = new Articulo("heladera", null, 4, 20000);
		articulos.add(articulo);
		articulo = new Articulo("cocina", null, 3, 45000);
		articulos.add(articulo);
		articulo = new Articulo("termotanque", null, 4, 30000);
		articulos.add(articulo);
		articulo = new Articulo("lavarropas", null, 3, 60000);
		articulos.add(articulo);

		// calcula el monto total del Set de articulos
		precio = ComprasUtil.calcularPrecioTotal(articulos);

		// calcula el precio que debe pagar el cliente
		precio = ComprasUtil.calcularPrecioTotalCredito(empresa, precio);

		assertEquals(721000, ComprasUtil.calcularPrecioTotalCredito(cliente, precio));

		// *Fin caso 2
	}

}
