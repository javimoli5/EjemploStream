package es.maestredam;
import java.io.File;

public class FUtil {
	
	/**
	 * Metodo que verifica si una cadena pasada existe o no
	 * @param filename cadena o fichero pasado
	 * @return true si existe, false si no; si es una cadena vacia lanza una excepcion
	 */
	public static boolean existe(String filename) {
		File file = new File(filename);
		if (filename.isBlank()) {
			throw new IllegalArgumentException("CADENA VACIA");
		}
		if (file.exists()) {
			return true;
		}
		return false;
	}
}