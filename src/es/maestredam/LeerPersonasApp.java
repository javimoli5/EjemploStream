package es.maestredam;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerPersonasApp {
	
	public static void main(String [] args) {
		
		final String FICHERO = "personas.dat";
		try (DataInputStream dis = new DataInputStream(
				new FileInputStream(FICHERO))){
			
			for (int i = 0; i < 4 ; i++){
				String nombre = dis.readUTF();
				System.out.printf("%s  ", nombre);	
				boolean edad = dis.readBoolean();
				System.out.printf("%b  ",edad);
				double saldo = dis.readDouble();
				System.out.println(saldo);
			}
			
			
		}catch (FileNotFoundException fnfe) {
			System.out.println("Archivo no encontrado");
		}catch (EOFException eof) {
			System.out.println("Error inesperado (?)");
		}catch (IOException ioe) {
			System.out.println("ERROR E/S "+ ioe);
		}
	}

}
