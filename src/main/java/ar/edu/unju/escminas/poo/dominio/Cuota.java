package ar.edu.unju.escminas.poo.dominio;

import java.time.LocalDate;

public class Cuota {
	
	//variables
	float monto;
	LocalDate vencimiento;
	boolean pagado;
	LocalDate diaPagado;
	
	//constructor
	public Cuota() {
		// TODO Auto-generated constructor stub
	}

	public Cuota(float monto, LocalDate vencimiento, boolean pagado, LocalDate diaPagado) {
		super();
		this.monto = monto;
		this.vencimiento = vencimiento;
		this.pagado = pagado;
		this.diaPagado = diaPagado;
	}

	//get and set
	
	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public LocalDate getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public LocalDate getDiaPagado() {
		return diaPagado;
	}

	public void setDiaPagado(LocalDate diaPagado) {
		this.diaPagado = diaPagado;
	}

	//metodo toString
	@Override
	public String toString() {
		return "Cuota [monto=" + monto + 
				", vencimiento=" + vencimiento + 
				", pagado=" + pagado +
				/*
				", diaPagado=" + diaPagado +
				*/ "]";
	}
	

	
	
}
