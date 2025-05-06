package es.maestredam;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Streams1App {
	
	public static void main (String [] args) {
		
		// LECTURA - CARACTERES (la fuente es el TECLADO)
		// Elijo la clase InputStreamReader
		
		int car = '?';
		
		// 4) Es obligatorio tratar IOException (try-catch)
		try {
			// 1) Creo el Stream adecuado:
			InputStreamReader streamTeclado = 
					new InputStreamReader (System.in);
			
			// 2) Leo un caracter
			car = streamTeclado.read();
			
			// 3) Cierro stream
			streamTeclado.close();
			
		
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
		
		System.out.printf("Has tecleado %c %n", car);
		
		// =============================================================
		// EJERCICIO 1: Leer el primer caracter de un fichero de texto
		
		// 4) Es obligatorio tratar IOException (try-catch)
		try {
			// 1) Creo el Stream adecuado:
			FileReader streamFichero = 
					new FileReader ("prueba.txt"); // como está en el mismo proyecto no es necesario poner la ruta entera, es muy importante que esté a la altura del src
			
			// 2) Leo un caracter
			car = streamFichero.read();
			
			// 3) Cierro stream
			streamFichero.close();
			
		
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
		
		System.out.printf("El primer caracter es %c %n", car);
		
		// =============================================================
		// EJERCICIO 2: Mostrar en consola los 3 primeros caracteres de un fichero 
		// de texto
		StringBuffer sb = new StringBuffer();
						
		// 4) Es obligatorio tratar IOException (try-catch)
		try {
			// 1) Creo el Stream adecuado:
			FileReader streamFichero = 
					new FileReader ("prueba.txt"); // como está en el mismo proyecto no es necesario poner la ruta entera, es muy importante que esté a la altura del src
			
			// 2) Leo tres caracteres
			for (int i = 0; i < 3; i++) {
				car = streamFichero.read();
				// Añado el caracter
				sb.append((char)car);	// el append del StringBuffer mete los enteros, hay que hacer casting a char
			}
			
			// 3) Cierro stream
			streamFichero.close();
			
		
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
		
		System.out.printf("Los caracteres leidos son %s %n", sb.toString());
		
		
		// =================================================================================
		// EJERCICIO 3: Mostrar en consola todos los caracteres de un fichero de texto
		final int EOF = -1;
		final String FICHERO = "D:\\programación\\java\\EjemploStream\\prueba.txt";
		try {
			// 1) Creo el Stream adecuado:
			FileReader streamFichero = new FileReader (FICHERO); // ejemplo de como seria con la ruta
		
			// 2) Leo el fichero completo, mostrando por consola cada caracter
			car = streamFichero.read();
			while (car != EOF) {
				System.out.printf("%c",car);
				car = streamFichero.read();
			}
			System.out.printf("%n-------------------------------%n");
			// 3) Cierro stream
			streamFichero.close();
			
		
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}		
		
	}
	
}