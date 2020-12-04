package com.jbac.app.cuenta_herencia_limitada;

import java.util.HashSet;

public class CuentaMovimiento extends CuentaLimitada{
	
	private HashSet<Movimiento> movs;
	
	public CuentaMovimiento(double saldo, double limite) {
		super(saldo, limite);
		movs=new HashSet<>();
	}

	@Override
	public void extraer(double cantidad) {
		movs.add(new Movimiento(cantidad,"extracción"));
		super.extraer(cantidad);
	}

	@Override
	public void ingresar(double cantidad) {
		movs.add(new Movimiento(cantidad,"ingresar"));
		super.ingresar(cantidad);
	}
	
	public HashSet<Movimiento> getMovimientos(){
		return movs;
	}
}
