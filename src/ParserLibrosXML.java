

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserLibrosXML extends DefaultHandler {
	
	private List<Libro> lista_libros;
	private Libro libro;
	private String valor_actual;
	
	
	

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.startDocument();
		lista_libros = new ArrayList<Libro>();
		System.out.println("Inicio del Documento");
	}
	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		//super.startElement(uri, localName, qName, attributes);
		if (localName.equals("libro"))
		{
			this.libro = new Libro();
			String valor_isbn = attributes.getValue("isbn");
			this.libro.setIsbn(valor_isbn);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		//super.characters(ch, start, length);
		String str = new String (ch, start, length);
		valor_actual = str;
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
//		super.endElement(uri, localName, qName);
		
		if(localName.equals("libro"))
		{
			lista_libros.add(libro);
		}
		
		if (localName.equals("titulo"))
		{
			libro.setTitulo(valor_actual);
		}
		else if (localName.equals("autor"))
		{
			libro.setAutor(valor_actual);
		}
		else if (localName.equals("anyo"))
		{
			libro.setAnyo(valor_actual);
		}
		else if (localName.equals("editorial"))
		{
			libro.setEditioral(valor_actual);
		}
	}
	

	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		//super.endDocument();

		HashMap<String, Libro> hm = new HashMap<String, Libro>();
		
		for(Libro lib : lista_libros)
		{
			hm.put(lib.getIsbn(), lib);
		}
		
		MapaLibros.setMapa_libros(hm);
		
		
		
		
	}


}
