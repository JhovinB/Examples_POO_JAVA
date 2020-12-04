package com.jbac.app.fecha;

import java.util.Date;
import java.util.HashSet;

public class GestionPiezas {
	
	private HashSet<Pieza> piezas;
	
	public GestionPiezas() {
		piezas=new HashSet<>();
	}
	public void addPieza(String nombre,Date fecha) {
		piezas.add(new Pieza(nombre,fecha));
	}
	
	public void addPieza(String nombre) {
		piezas.add(new Pieza(nombre,new Date()));
	}
	
	public HashSet<Pieza> obtenerAntigua(Date fecha){
		HashSet<Pieza> res = new HashSet<>();
		for (Pieza p : piezas) {
			if (p.getFechaFabricacion().getTime()<fecha.getTime()) {
				res.add(p);
			}
		}
		return res;
	}
	
}
