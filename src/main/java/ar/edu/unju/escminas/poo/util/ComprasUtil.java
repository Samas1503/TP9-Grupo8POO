package ar.edu.unju.escminas.poo.util;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Articulo;
import ar.edu.unju.escminas.poo.dominio.Compra;
import ar.edu.unju.escminas.poo.dominio.Cuota;

public class ComprasUtil {
		Scanner sc = new Scanner(System.in);
		
		public ComprasUtil() {
			// TODO Auto-generated constructor stub
		}
		
		public Compra hacerCompraParticular(Articulo articulo) {
		LocalDate hoy = LocalDate.now();
		LocalDate vencimiento;
		int cantidad;
		Compra nuevaCompra = new Compra();
		//id compra
		nuevaCompra.setArticulo(articulo);
		articulo.setStock(articulo.getStock()-1);
		
		System.out.println("ingrese la cantidad de cuotas");
		//try catch
		cantidad = sc.nextInt();
		
		if (cantidad < 24 )
		{
			for(int i=0; i<cantidad; i++);
			{
				//
				//Cuota cuota = new Cuota((articulo.getPrecio()/cantidad),);
			}
		}
		return nuevaCompra;
			
		}
}
