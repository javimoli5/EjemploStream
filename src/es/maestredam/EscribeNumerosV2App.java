package es.maestredam;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Aplicación que genera un fichero con N valores reales.
 * El número de valores está en el int de la cabecera
 * 
 * FORMATO int | double | double | ... | double
 */

public class EscribeNumerosV2App {

	public static void main (String [] args) {
		
		final String FICHERO = "numeros_v2.dat";
		
		// double num = 78.36;
		double [] numeros = {78.36, 79.34, 12.12, 44.44, 99.99, 1234.666666, -1.1};
		// Creo un objeto DataOutputStream (filtro para codificar el dato), 
		// usando un objeto FileOutputStream como "canal" de salida de tipo Binario.
		try (DataOutputStream dos = new DataOutputStream
				(new FileOutputStream(FICHERO))) {
			
			// Escribir todos los números reales
			/**
			 * dos.writeUTF(cadena);
			   dos.writeInt(entero);
			   dos.writeBoolean(booleano);
			*/
			
			// Escribo primero la cabecera
			int numElementos = numeros.length;
			dos.writeInt(numElementos);
			
			// Escribo todos los números reales
			for (int i = 0; i < numElementos; i++) {
				dos.writeDouble(numeros[i]);
			}
			
			
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S "+ioe);
		}
	}
	
}
