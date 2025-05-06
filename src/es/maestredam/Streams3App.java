package es.maestredam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Streams3App {
	
	public static void main (String [] args) throws IOException {
		
		final String FICHERO = "prueba.txt";
		
		// ===========================================================000
		// EJEMPLO: BufferedReader
		// Mostrar la primera linea de un fichero de texto
		try (
				
			FileReader fichero = new FileReader(FICHERO);
				
			BufferedReader br = new BufferedReader(fichero)){
				
			// Mostrar la 1ª línea (Y si solo quiero mostrar la 2ª línea?)
			String linea = br.readLine();
			linea = br.readLine();
			// Cuando no lee nada devuelve null
			if (linea == null) {
				System.out.println("NO hay linea");
			}
			System.out.println(linea);
			
			
			// EJERCICIO: Contar palabras de la 2ª linea
			int cPals=0;
			String [] palabras = linea.split("\\s+");
			cPals = palabras.length;
			
			System.out.printf("Nº de caracteres: %d%n", linea.length());
			System.out.printf("Nº de palabras:   %d%n", cPals);
			
				
				
		
		}catch (FileNotFoundException fnfe) {
			System.out.println("Fichero "+ FICHERO+" no encontrado");
		
		}catch (IOException ioe) {
			System.out.println("ERROR E/S: "+ ioe);
		}
		
		
		
		// EJEMPLO: BufferedWriter
		// Escribir varias lineas de texto
		try (
						
			FileWriter fichero = new FileWriter("index.html");
						
			BufferedWriter bw = new BufferedWriter(fichero)){
						
			bw.write("<ul>");
			bw.newLine();
			bw.write("  <li>Item 1</li>");
			bw.newLine();
			bw.write("  <li>Item 2</li>");
			bw.newLine();
			bw.write("</ul>");
			bw.newLine();
			
			System.out.println("[HECHO]");
		
			}catch (IOException ioe) {
				System.out.println("ERROR E/S: "+ ioe);
			}
		
		
		
		// EJERCICIO: Hacer copia exacta del fichero index.html
		// y añadirle al final un footer con el nº total de lineas
		// y de caracteres, la fecha actual y vuestro nombre
		
		try (
			BufferedReader br = 
					new BufferedReader(new FileReader("index.html"));
			BufferedWriter bw = 
					new BufferedWriter(new FileWriter("copia_index.html"))) {
			
			System.out.println("COPIANDO index.html...");
			
			int numCars = 0;
			int numLineas = 0;
			
			String linea = br.readLine();
			while (linea!=null) {
				bw.write(linea);
				bw.newLine();
				numLineas++;
				numCars = numCars + linea.length();
				linea = br.readLine();
			}
						
			bw.write("<footer>");
			bw.newLine();
			bw.write("  <hr>");
			bw.newLine();
			bw.write("  Nº Lineas copiadas: "+ numLineas);
			bw.newLine();
			bw.write("  Nº Caracteres copiados: "+ numCars);
			bw.newLine();
			bw.write("  Nombre: Javier Molina-Prados");
			bw.newLine();
			bw.write("  <br>");
			bw.newLine();
			bw.write(" "+ new Date().toString());
			bw.newLine();
			bw.write("</footer>");

			
			
			
		}catch(FileNotFoundException fnf) {
			System.out.println("ERROR E/S: fichero no encontrado");
			
		}catch(IOException ioe) {
			System.out.println("Error E/S: " + ioe);
		}
	}

}
