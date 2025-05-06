package es.maestredam;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirPersonasApp {

	public static void main(String [] args) {
		
		final String FICHERO = "personas.dat";
		
		String  [] nombres 	= {"Javier", "Juan", "Marcos", "Luis"};
		boolean [] edades 	= {true, false, false, true};
		double  [] saldos	= {1500.75, 1266.34, 1492,60, 1110.55};
		
		try (DataOutputStream dos = new DataOutputStream(
				new FileOutputStream(FICHERO))) {
			
		int numNombres = nombres.length;
		int numEdades  = edades.length;
		int numSaldos  = saldos.length;
		
		for (int i = 0; i < numNombres; i++) {
			dos.writeUTF(nombres[i]);
			dos.writeBoolean(edades[i]);
			dos.writeDouble(saldos[i]);
		}
			
		}catch (IOException ioe) {
			System.out.println("ERROR E/S "+ioe);
		}
		
	}
	
}
