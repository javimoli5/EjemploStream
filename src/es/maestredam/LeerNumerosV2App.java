package es.maestredam;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerNumerosV2App {
	
		
	public static void main(String [] args) {
		
		final String FICHERO = "numeros_v2.dat";
		
		System.out.printf("Contenido de %s%n", FICHERO);
		System.out.printf("--------------------------------%n");
		
		try (DataInputStream dis = new DataInputStream
				(new FileInputStream(FICHERO))) {
			
			// Leo primero la cabecera con el nº de valores
			int num =  dis.readInt();
			System.out.printf("Cuenta: %d%n%n", num);	

			// LEO TODOS LOS VALORES QUE HE ESCRITO	
			for (int i = 0; i < num ; i++){
				double valor = dis.readDouble();
				System.out.printf("%f%n", valor);	
			}
		
		}catch (FileNotFoundException fnfe) {
			System.out.println("No encontrado");
		
		}catch (EOFException eof) {
			System.out.println("EOF inesperado (?)");
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S "+ioe);
		}
	}
	
}