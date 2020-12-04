package com.jbac.app.cuenta_herencia_limitada;

import java.util.HashSet;

public class PrincipalCuenta {

	public static void main(String[] args) {
		
		CuentaMovimiento c = new CuentaMovimiento(200,100);
		c.ingresar(50);
		c.extraer(70);
		System.out.println(c.getSaldo());
		HashSet<Movimiento> movimientos = c.getMovimientos();
		for (Movimiento m : movimientos) {
			System.out.println("Cantidad: "+m.getCantidad()+" Tipo: "+m.getTipo());
		}
	}

}
