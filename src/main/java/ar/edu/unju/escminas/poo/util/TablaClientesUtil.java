package ar.edu.unju.escminas.poo.util;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unju.escminas.poo.dominio.Cliente;
import ar.edu.unju.escminas.poo.dominio.Empresa;
import ar.edu.unju.escminas.poo.dominio.Particular;

public class TablaClientesUtil {
	
	public TablaClientesUtil() {
		// TODO Auto-generated constructor stub
	}
		
	public Set<Cliente> cargarClientes(){
		
		Set<Cliente> clientes = new HashSet<Cliente>();
		
		//particulares
		Particular particular = new Particular("Banco1",1,"santiago","tintilay");
		clientes.add(particular);
		particular = new Particular ("Banco2",2,"Mayok","Hermandez");
		clientes.add(particular);
		particular = new Particular ("Banco3",3,"samoel","heredia");
		clientes.add(particular);
		particular = new Particular ("Banco4",4,"mariano","marianez");
		clientes.add(particular);
		
		//empresa
		Empresa empresa = new Empresa("Banco1","chango","ramirez");
		clientes.add(empresa);
		empresa = new Empresa ("Banco2","corralon","dalas");
		clientes.add(empresa);
		empresa = new Empresa ("Banco3","Stardeoz","joaquin");
		clientes.add(empresa);
		empresa = new Empresa ("Banco4","youtibe","mayko");
		clientes.add(empresa);
		
		
		return clientes;
		
	}

}
