package es.maestredam;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerNumerosApp {
	
		
	public static void main(String [] args) {
		
		final String FICHERO = "numeros_v2.dat";
		
		System.out.printf("Contenido de %s%n", FICHERO);
		System.out.printf("--------------------------------%n");
		
		try (DataInputStream dis = new DataInputStream
				(new FileInputStream(FICHERO))) {
			
			// LEO TODOS LOS VALORES QUE HE ESCRITO	
			// Debo controlar EOFException
			while (true) {
				double valor = dis.readDouble();
				System.out.printf("%f%n", valor);	
			}
		
		}catch (FileNotFoundException fnfe) {
			System.out.println("No encontrado");
		
		}catch (EOFException eof) {
			System.out.println("[FIN]");
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S "+ioe);
		}
	}
	
}
