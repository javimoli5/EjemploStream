package es.maestredam;
import java.io.File;

public class FUtil {
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