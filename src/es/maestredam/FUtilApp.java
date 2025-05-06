package es.maestredam;
public class FUtilApp {
	
	
	public static void main (String [] args) {
		
		final String FICHERO = "prueba.txt";
		final String FICHERO2 = "prueba2.txt";
		
		boolean existe = FUtil.existe(FICHERO);
		boolean existe2 = FUtil.existe(FICHERO2);
		
		System.out.printf("¿Existe el fichero %s? %b%n", FICHERO, existe);
		System.out.printf("¿Existe el fichero %s? %b%n", FICHERO2, existe2);
		
	}
}
