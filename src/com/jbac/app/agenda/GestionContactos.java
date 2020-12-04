package com.jbac.app.agenda;

import java.util.Collection;
import java.util.HashMap;

public class GestionContactos {

	HashMap<String,Contacto> agenda;
	
	public GestionContactos() {
		agenda=new HashMap<>();
	}
	
	public boolean add(String nombre, int edad,String email) {
		//containsKey->elem esta siendo utilizada o no
		//Si no existe, se añade
		if (!agenda.containsKey(nombre)) {
			Contacto c = new Contacto(nombre,email, edad);
			agenda.put(nombre,c);
			return true;
		}else {
		return false;
	
		}
	}
	public Contacto search(String nombre) {
		Contacto c = null;
		if (agenda.containsKey(nombre)) {
			c=agenda.get(nombre);
		}
		return c;//devuelve el contacto encontrado
	}
	public boolean eliminar(String nombre) {
		if (agenda.containsKey(nombre)) {
			agenda.remove(nombre);
			return true;
		}else {
			return false;
		}
	}
	public Contacto[]findContactos(){
		Contacto [] existe=new Contacto[agenda.size()];
		int i=0;
		Collection<Contacto>valores = agenda.values();
		for (Contacto con : valores) {
			existe[i]=con;
			i++;
		}
		return existe;
	}
	
}
