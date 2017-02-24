import java.util.HashMap;
import java.util.Map;



public class MapaLibros extends HashMap<String, Libro>{
	
	public static Map<String, Libro> mapa_libros;

	public static Map<String, Libro> getMapa_libros() {
		
		
		return mapa_libros;
	}

	public static void setMapa_libros(Map<String, Libro> mapa_libros) {
		MapaLibros.mapa_libros = mapa_libros;
	}
	

	public MapaLibros()
	{
		super();
		mapa_libros = new HashMap<String, Libro>();
	}


	
}
