package com.jbac.app.agenda;

import java.util.Scanner;

public class PrincipalContactos {

	public static void main(String[] args) {
		
		GestionContactos gcontactos= new GestionContactos();
		int op,edad;//Opcion elegir por el usuario
		Scanner sc = new Scanner(System.in);
		String nombre,email;
		
		try {
			
		do {
			//Menú
			System.out.println("1.Añadir contacto");
			System.out.println("2.Buscar contacto");
			System.out.println("3.Eliminar contacto");
			System.out.println("4.Mostrar contacto");
			System.out.println("5.Salir");
			op=Integer.parseInt(sc.nextLine());
			switch (op) {
				case 1:
					System.out.println("Nombre: ");
					nombre=sc.nextLine();
					System.out.println("Email: ");
					email=sc.nextLine();
					System.out.println("Edad: ");
					edad=Integer.parseInt(sc.nextLine());
					gcontactos.add(nombre, edad, email);
					break;
				case 2:
					System.out.println("Nombre: ");
					nombre=sc.nextLine();
					Contacto con =gcontactos.search(nombre);
					if (con==null) {
						System.out.println("No se encontro el contacto");
					}else {
						System.out.println(con.getNombre()+"-"+con.getEmail()+"-"+con.getEdad());
					}
					break;
				case 3:
					System.out.println("Nombre: ");
					nombre=sc.nextLine();
					if (gcontactos.eliminar(nombre)) {
						System.out.println("Contacto eliminado");
					}else {
						System.out.println("No se encontro el contacto");
					}
					break;
				case 4:
					Contacto[]todo=gcontactos.findContactos();
					for (Contacto contactos : todo) {
						System.out.println(contactos.getNombre()+"-"+contactos.getEmail()+"-"+contactos.getEdad());
					}
					break;
			
				case 5:
					break;
				
				default:
					System.out.println("Ingrese una opción valida");
				}
			
			} while (op!=5);
		}catch(Exception e) {
			System.out.println(e);
		}
		sc.close();
	}

}
