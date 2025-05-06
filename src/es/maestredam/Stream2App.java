package es.maestredam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stream2App {
	
	public static void main (String [] args) {
		
		// LECTURA - CARACTERES (la fuente es el TECLADO)
		// Elijo la clase InputStreamReader
		
		
		// 4) Es obligatorio tratar IOException (try-catch)
		int car = '?';
		
		try (FileReader streamFichero = new FileReader("prueba.txt")){
			System.out.println("Fichero abierto");
			
			// Operaciones de lectura
			car = streamFichero.read();
		
			
		}catch(FileNotFoundException fnf) {
			System.out.println("ERROR E/S: fichero no encontrado");
			
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
		
		System.out.println("Fichero cerrado");
		
		System.out.printf("Has tecleado %c %n", car);
	
	
	
	
		// EJERCICIO 1: Copia completa de un fichero de texto 
		// 				FileReader => "Canal" de lectura para texto
		// 				FileWriter => "Canal" de escritura para texto
		
		try (
			FileReader entrada = new FileReader ("prueba.txt");
				// De esta manera, Si no existe lo crea, y si existe lo sobrescribe
				// (Hay otro constructor para añadir por el final si existe)
			FileWriter salida  = new FileWriter ("prueba_copia.txt")
			){
			
			
			System.out.println("Copiando...");
			
			final int EOF = -1;
			car = entrada.read();
			
			while (car != EOF) {
				salida.write(car); // FileWriter usa write para añador los caracteres, NO append
				car = entrada.read();
			}
			
			
			
		}catch(FileNotFoundException fnf) {
			System.out.println("ERROR E/S: fichero no encontrado");
			
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
		
		
		System.out.println("[FIN]");
		
		
		
		// EJERCICIO 2: Copia completa de un fichero de texto,
		// 				Transformando el caracter en el siguiente, es decir,
		// 				A se transforma a B, B en C, a en b, 0 en 1,....
		
		try (
				FileReader entrada = new FileReader ("prueba.txt");
					// De esta manera, Si no existe lo crea, y si existe lo sobrescribe
					// (Hay otro constructor para añadir por el final si existe)
				FileWriter salida  = new FileWriter ("prueba_copia1.txt")
				){
				
				
				System.out.println("Cifrando...");
				
				final int EOF = -1;
				car = entrada.read();
				
				while (car != EOF) {
					
					if(car == 32) {			// 32 corresponde al ESPACIO EN BLANCO
						salida.write(car);
					}
					if (Character.isAlphabetic(car)) {
						salida.write((car+1));
					}
					car = entrada.read();
				}
				
				
				
			}catch(FileNotFoundException fnf) {
				System.out.println("ERROR E/S: fichero no encontrado");
				
			}catch(IOException ioe) {
				System.out.println("Error E/S: " + ioe);
			}
			
			
			System.out.println("[FIN]");
			
		
		
	
		
	}
}