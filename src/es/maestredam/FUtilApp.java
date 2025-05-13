package es.maestredam;
public class FUtilApp {
	
	
	public static void main (String [] args) {
		
		final String FICHERO = "prueba.txt";
		final String FICHERO2 = "    ";
		
		boolean existe = FUtil.existe(FICHERO);
		System.out.printf("¿Existe el fichero %s? %b%n", FICHERO, existe);

		boolean existe2 = FUtil.existe(FICHERO2);
		System.out.printf("¿Existe el fichero %s? %b%n", FICHERO2, existe2);
		
	}
}
