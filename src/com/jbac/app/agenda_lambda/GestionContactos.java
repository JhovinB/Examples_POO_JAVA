package com.jbac.app.agenda_lambda;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	//lambda
	public Contacto [] recuperarEdadMaxima(int edad) {
		/*sssArrayList<Contacto> aux= new ArrayList<>();
		agenda.forEach((k,v)->{
			if (v.getEdad()<=edad) {
				aux.add(v);
			}
		});
		return aux.toArray(new Contacto[0]);*/
		
		Stream<Contacto>st = agenda.values().stream();
		return st.filter(c->c.getEdad()<=edad).toArray(t->new Contacto[t]);
	}
	//Stream
	//Si existe un contacto con ese nombre
	public boolean existContact(String nombre) {
		Stream<Contacto> st = agenda.values().stream();	
		return st.anyMatch(c->c.getNombre().equals(nombre));
		
	}
	//Devuelve el contacto con más edad
	public Contacto contactoMayor() {
		Stream<Contacto> st = agenda.values().stream();	
		return st.max((c1,c2)->c1.getEdad()-c2.getEdad()).get();
	}
	//Devuelve el primer contacto q coincide con el nombre
	public Contacto buscarPorNombre(String nombre) {
		Stream<Contacto> st = agenda.values().stream();
		return st.filter(c->c.getNombre().equals(nombre)).findFirst().get();	
	}
	//Devuelve la lista de nombres
	public List<String> recuperarNombres() {
		Stream<Contacto> st = agenda.values().stream();
		return st.map(c->c.getNombre()).collect(Collectors.toList());
	}
	//Devuelve la edad media de todos los contactos
	public double edadMedia() {
		Stream<Contacto> st= agenda.values().stream();
		return st.mapToInt(c->c.getEdad()).average().getAsDouble();
	}
}
