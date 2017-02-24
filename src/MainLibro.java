import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class MainLibro {

	public static void mostrar()
	{
		Libro libro = null;
		List<Libro> lista_libros = new ArrayList<Libro>();
		String isbn = null;
		
////		for (String nombre: listaLibros.keySet())
//		{
//            String value = listaLibros.get(nombre).toString();
//            System.out.println(nombre+value);  
////		
		
	}
	
	public static int getNLibros()
	{
		int num_libros = 0;
		
		num_libros = MapaLibros.mapa_libros.size();
		
		return num_libros;
	}
	
	
	public static void main(String[] args) throws SAXException, FileNotFoundException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		ParserLibrosXML parserLibros = null;
		parserLibros = new ParserLibrosXML();
		
		reader.setContentHandler(parserLibros);
		
		reader.parse(new InputSource(new FileInputStream("libros.xml")));
		mostrar();

	}
	
}
