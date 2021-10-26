package ar.edu.unju.escminas.poo.tablas;

import java.util.Set;

import ar.edu.unju.escminas.poo.dominio.Cliente;

public class TablaClientes {
	Set<Cliente> clientes;
	
	public TablaClientes() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "TablaClientes [clientes=" + clientes + "]";
	}
	
	public void listarClientes() {
		this.getClientes().stream().forEach(System.out::println);
	}
	
	public Cliente seleccionarClienteId(int idCliente) {
		Cliente seleccionado = null;
		
		for(Cliente c : this.getClientes()) {
			if (c.getIdCliente() == idCliente)
				seleccionado = c;
		}
		return seleccionado;	
	}
	
	
	
}
