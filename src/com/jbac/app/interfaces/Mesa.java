package com.jbac.app.interfaces;

public class Mesa implements Proceso{
	
	private int ancho, largo;
	
	
	public Mesa(int ancho, int largo) {
		super();
		this.ancho = ancho;
		this.largo = largo;
	}

	@Override
	public void imprimir() {
		System.out.println("El ancho es: "+ancho+"El largo es: "+largo);
	}

	@Override
	public void aumentas(int c) {
		ancho+=c;
		largo+=c;
	}

}
