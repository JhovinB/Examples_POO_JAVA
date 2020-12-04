package com.jbac.app.polimorfismo;

public class PrincipalPolimorfismo {

	public static void main(String[] args) {
		
		mostrarDatosFiguras(new Triangulo ("amarillo",4,8));
		mostrarDatosFiguras(new Circulo("azul", 3));
	}
	public static void mostrarDatosFiguras(Figura f) {
		System.out.println("Color: "+f.getColor());
		System.out.println("Superficie "+f.superficie());
	}

}
