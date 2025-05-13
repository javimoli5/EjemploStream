package es.maestredam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class PersonaApp {
	
	public static void main (String [] args) {
		final String FICHERO = "personas2.dat";
		
		// Creo 3 objetos Persona
		Persona p1 = new Persona("Juan",   true, 1000);
		Persona p2 = new Persona("Ana",    true, 2000);
		Persona p3 = new Persona("Daniel", false,0);
		
		ArrayList <Persona> personas = new ArrayList <>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		
		// Muestro los 3 objetos
		for(Persona p:personas) {
			System.out.println(p);
		}
		
		// Guardo los 3 objetos en un fichero
		// Uso ObjectOutputStream => Stream ESCRITURA datos BINARIOS (que son Objetos)
		// con FileOutputStream   => FICHERO
		System.out.println("Escribiendo...");
		try (ObjectOutputStream ficheroPersonas = 
				new ObjectOutputStream(new FileOutputStream(FICHERO))){
			
			for(Persona p:personas) {
				ficheroPersonas.writeObject(p);
			}

		}catch(IOException ioe){
			System.out.println("ERROR ESCRITURA" + ioe);
		}
		
		// Elimino los objetos de memoria
		p1=null;
		p2=null;
		p3=null;
		
		// Da prioridad al Garbage Collector
		System.gc(); 
		
		
		// Recupero los objetos del fichero y los muestro
		// ¿Ha cambiado algo?
		// Uso ObjectInputStream => Stream LECTURA datos BINARIOS (que son Objetos)
		// con FileInputStream   => FICHERO
		System.out.println("Leyendo...");
		try (ObjectInputStream ficheroPersonas = 
				new ObjectInputStream(new FileInputStream(FICHERO))){
			
			// Devuelve un "Object"
			// leo y muestro los 3 objetos
			for(Persona p:personas) {
				Persona leido = (Persona) ficheroPersonas.readObject();
				System.out.println(leido);
			}
	
			
		}catch(FileNotFoundException fnfe) {
			System.out.println("ERROR fichero no econtrado: " + fnfe);
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("ERROR al leer objeto: " + cnfe);
			
		}catch(IOException ioe){
			System.out.println("ERROR ESCRITURA: " + ioe);
		}
	}

}
