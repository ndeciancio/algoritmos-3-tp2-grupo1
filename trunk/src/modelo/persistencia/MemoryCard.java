package modelo.persistencia;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MemoryCard {

	File archivo;
	DocumentBuilder builder;
	Document documento;
	
	public TablaDePuntuaciones cargarPuntuaciones(File archivo){
		abrirArchivo(archivo);
		ManagerDePuntuaciones lector = new ManagerDePuntuaciones(documento);
		return lector.cargarPuntuaciones();
	}
	
	public void nuevaPuntuacion(File archivo, String nombre, int movimientos){
		abrirArchivo(archivo);
		ManagerDePuntuaciones escritor = new ManagerDePuntuaciones(documento);
		try {
			escritor.ingresarPuntuacion(archivo, nombre, movimientos);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void abrirArchivo(File archivo){
		this.archivo = archivo;
		construirDocumento();
	}
	
	private void construirDocumento(){
		try {
			crearDocumentBuilder();
			parsearDocumento();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void crearDocumentBuilder() throws ParserConfigurationException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
	}
	
	private void parsearDocumento() throws SAXException, IOException {
		documento = builder.parse(archivo);
	}
	
}
