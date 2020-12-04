package com.jbac.app.cuenta_herencia;

public class PrincipalCuenta {

	public static void main(String[] args) {
		
		CuentaLimitada c = new CuentaLimitada(100, 20);
		c.extraer(20);
		System.out.println(c.getSaldo());
	}

}
