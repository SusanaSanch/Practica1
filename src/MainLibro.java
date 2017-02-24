import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
		
			Collection<Libro> lista = MapaLibros.mapa_libros.values();
			for (Libro libro : lista) 
			{
				System.out.println("Isbn = " + libro.getIsbn() + ". " + "Título = " +libro.getTitulo() + ". "+ "Año = " + libro.getAnyo() + ". "+"Autor = " + libro.getAutor() + ". " + "Editorial = " +libro.getEditioral()+ ". ");
			}
					
					
		
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
		System.out.println("\nNúmero de libros: " + getNLibros());

	}
	
}
