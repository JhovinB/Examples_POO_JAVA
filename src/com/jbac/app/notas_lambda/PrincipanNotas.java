package com.jbac.app.notas_lambda;

import java.util.Scanner;

public class PrincipanNotas {

	public static void main(String[] args) {
		
		GestionNotas gnotas = new GestionNotas();
		int op;//Opcion elegir por el usuario
		Scanner sc = new Scanner(System.in);
		double nota;
		do {
			//Menú
			System.out.println("1.Añadir nota");
			System.out.println("2.Ver media");
			System.out.println("3.Ver aprobados");
			System.out.println("4.Mostrar ordenados");
			System.out.println("5.Eliminar algunas notas");
			System.out.println("6.Salir");
			op=Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				System.out.println("Introduce nota:");
				nota=Double.parseDouble(sc.nextLine());
				gnotas.guardarNota(nota);
				break;
			case 2:
				System.out.println("Media actual: "+gnotas.media());
				break;
			case 3:
				System.out.println("Aprobados: "+gnotas.aprobados());
				break;
			case 4:
				Double[] todas= gnotas.recuperarNotas();
				for (Double d : todas) {
					System.out.println(d+",");
				}
				System.out.println("");
				break;
			case 5:
				gnotas.eliminarNotas();
				break;
				
			}
			
			
		} while (op!=6);
		
		sc.close();
	}

}
