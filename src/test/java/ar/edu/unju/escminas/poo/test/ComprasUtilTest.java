package ar.edu.unju.escminas.poo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Compra;
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
	
	//verificar permita validar que la lista de cuotas que se generan para el plan correspondiente no es un valor null. 
	@Test
	public void testVerificarAgregarCuotasCliente() {
		LocalDate hoy = LocalDate.now();
		LocalDate vencimiento = LocalDate.of(hoy.getYear(), hoy.getMonthValue(), 15);
		// primero verificare que se creen las cuotas correctas para un cliente particular
		
		//creacion de objeto a verificar
		Particular particular = new Particular("Banco1",1,"san","tiago");
		Set<Cuota> objeto = new TreeSet<Cuota>();
		ComprasUtil.agregarCuotas(objeto, 24000, particular);
		
		//creacion de objeto para verificar
		Set<Cuota> esperado = new TreeSet<Cuota>();
		for(int i=1 ; i <= 24 ;i++ ) {
			esperado.add(new Cuota(1000,vencimiento.plusMonths(i)));
		}
		
		assertEquals(esperado,objeto);
		
		//segundo verificare que se creen las cuotas correctas para un cliente empresa
		
		//creacion de objeto a verificar
		Empresa empresa = new Empresa("Banco2","Corralon","Gerardo");
		Set<Cuota> objeto2 = new TreeSet<Cuota>();
		ComprasUtil.agregarCuotas(objeto2, 12000, empresa);
		
		//creacion de objeto para verificar
		Set<Cuota> esperado2 = new TreeSet<Cuota>();
		for(int i=1 ; i <= 12 ;i++ ) {
			esperado2.add(new Cuota(1000,vencimiento.plusMonths(i)));
		}
		
		assertEquals(esperado2,objeto2);
	}
	
	//Test que valida que la cantidad de cuotas generadas no supere la cantidad de cuotas permitidas.
	public void testVerificarCantidadCuotasParticular() {

		Set<Articulo> articulos = new HashSet<Articulo>();
		Articulo articulo;
				articulo = new Articulo("heladera", null, 2, 80000);
				articulos.add(articulo);
				articulo = new Articulo("cocina", null, 1, 45000);
				articulos.add(articulo);
				articulo = new Articulo("termotanque", null, 1, 30000);
				articulos.add(articulo);
				articulo = new Articulo("ventilador", null, 3, 95000);
				articulos.add(articulo);

		//primero verificare la cantidad de cuotas para un cliente particular
				
		//creacion de objeto a verificar
		Particular particular = new Particular("Banco1",1,"san","tiago");
		particular.getCompras().add(ComprasUtil.hacerCompra(particular, articulos));
		
		//extraigo la cantidad de cuotas
		Long cantidad = particular.getCompras().get(0).getCuotas().stream().count();
		
		//variable para comparar
		Long esperado = (long) 24;
		
		assertEquals(esperado,cantidad);
		
		//segundo verificare la cantidad de cuotas para un cliente empresa
		
		//creacion de objeto a verificar
		Empresa empresa = new Empresa("Banco2","Corralon","Gerardo");
		empresa.getCompras().add(ComprasUtil.hacerCompra(empresa, articulos));
		
		//extraigo la cantidad de cuotas
		Long cantidad2 = empresa.getCompras().get(0).getCuotas().stream().count();
		
		//variable para comparar
		Long esperado2 = (long) 12;
		
		assertEquals(esperado2,cantidad2);
		
	}
	
	//Test que valida que el monto total del crédito sea correcto
	@Test
	public void testVerificarMontoCreditoParticular() {
		
		//primero verificare la correcta creacion del monto total para un cliente particular
		
		//variable a verificar
		Particular particular = new Particular("Banco1",1,"san","tiago");
		// primero verifico si entra en el plan para particulares
		float objeto = ComprasUtil.calcularPrecioTotalCredito(particular, 200000);
		float esperado = 200000;
		assertEquals(esperado,objeto);
		
		//segundo veirifico si no entra en el plan para particulares
		objeto = ComprasUtil.calcularPrecioTotalCredito(particular, 250000);
		esperado = (float) (250000 + 250000 * 0.4);
		assertEquals(esperado,objeto);
		
		//segundo verificare la correcta creacion del monto total para un cliente particular
		
		//variable a verificar
		Empresa empresa = new Empresa("Banco2","Corralon","Gerardo");
		// primero verifico si entra en el plan para empresa
		float objeto2 = ComprasUtil.calcularPrecioTotalCredito(empresa, 500000);
		float esperado2 = (float) (500000 + 500000 * 0.2);
		assertEquals(esperado2,objeto2);
				
		//segundo veirifico si no entra en el plan para particulares
		objeto2 = ComprasUtil.calcularPrecioTotalCredito(particular, 510000);
		esperado2 = (float) (510000 + 510000 * 0.4);
		assertEquals(esperado2,objeto2);
	}
	
}
