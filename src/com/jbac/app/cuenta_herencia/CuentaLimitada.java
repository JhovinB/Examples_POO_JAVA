package com.jbac.app.cuenta_herencia;

public class CuentaLimitada extends Cuenta{

	private double limite;
	
	//Super->Llama al constructor de la clase cuenta;
	public CuentaLimitada(double saldo,double limite) {
		super(saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void fijarLimite() {
		limite=getSaldo()/2;
	}
	
	
	
}
