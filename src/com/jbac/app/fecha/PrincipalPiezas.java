package com.jbac.app.fecha;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class PrincipalPiezas {
	
	public static void main(String[] args) {
		
		GestionPiezas gpiezas = new GestionPiezas();
		Scanner sc = new Scanner(System.in);
		int op,dia,mes,anio;
		String nombre;
		
		do {
			//Menú
			System.out.println("1.Añadir pieza");
			System.out.println("2.Pieza Antigua");
			System.out.println("3.Salir");
			op=Integer.parseInt(sc.nextLine());
			switch (op) {
				case 1:
					System.out.println("Nombre pieza: ");
					nombre=sc.nextLine();
					System.out.println("Año fabricación: ");
					anio=Integer.parseInt(sc.nextLine());
					System.out.println("Mes fabricación(1-12): ");
					mes=Integer.parseInt(sc.nextLine());
					System.out.println("Día fabricación: ");
					dia=Integer.parseInt(sc.nextLine());
					
					//Creamos un calendar con datos de fecha
					//Introduccion
					Calendar cal = Calendar.getInstance();
					cal.set(anio,mes-1,dia);
					//Pasamos la fecha al método como un objeto Date
					gpiezas.addPieza(nombre,cal.getTime());
					break;
				case 2:
					System.out.println("Año fabricación: ");
					anio=Integer.parseInt(sc.nextLine());
					System.out.println("Mes fabricación(1-12): ");
					mes=Integer.parseInt(sc.nextLine());
					System.out.println("Día fabricación: ");
					dia=Integer.parseInt(sc.nextLine());
					//Se resta 1 en el mes xq van 0 a 11
					Calendar cal2 = Calendar.getInstance();
					cal2.set(anio,mes-1,dia);
					HashSet<Pieza> piezas = gpiezas.obtenerAntigua(cal2.getTime());
					//Recorremos la piezas recuperadas y mostramos la fecha
					//formateada
					for (Pieza p : piezas) {
						DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("Es","es"));
						System.out.println(p.getNombre()+"-"+df.format(p.getFechaFabricacion()));
					} 
					break;
				}
			} while (op!=3);
			
			sc.close();
		}
}
