package modelo.persistencia;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class FachadaPersistencia {

	File archivo;
	DocumentBuilder builder;
	Document documento;
	
	public void guardarPartida(String nombreDelJugador){
	    try{
	        File archivoPartida = new ArchivoPartida(nombreDelJugador);
	        abrirArchivo(archivoPartida);
	        EscritorDePartida escritor = new EscritorDePartida();
	        escritor.guardarPartida(documento, archivoPartida);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void cargarPartida(String nombreDelJugador){
	    abrirArchivo(new File("data/" + nombreDelJugador + ".xml"));
	    LectorDePartida lector = new LectorDePartida();
	    lector.cargarPartida(documento);
	}
	
	public void cargarMapa(String archivo){
	    abrirArchivo(new File(archivo));
	    CreadorDeMapa creadorDeMapa = new CreadorDeMapa();
	    creadorDeMapa.cargarMapa(documento);
	}
	
    public TablaDePuntuaciones cargarPuntuaciones(){
        ArchivoPuntuaciones archivo = null;
        try {
            archivo = new ArchivoPuntuaciones();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cargarPuntuaciones(archivo);
    }
	
	public TablaDePuntuaciones cargarPuntuaciones(File archivo){
		abrirArchivo(archivo);
		ManagerDePuntuaciones lector = new ManagerDePuntuaciones(documento);
		return lector.cargarPuntuaciones();
	}
	
	public void nuevaPuntuacion(String nombre, int puntuacion){
	    try {
            nuevaPuntuacion(new ArchivoPuntuaciones(), nombre, puntuacion);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void nuevaPuntuacion(File archivo, String nombre, int movimientos){
	    try {
	        abrirArchivo(archivo);
	        ManagerDePuntuaciones escritor = new ManagerDePuntuaciones(documento);
			escritor.ingresarPuntuacion(archivo, nombre, movimientos);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void borrarPuntuaciones(){
	    try {
            ArchivoPuntuaciones puntuaciones = new ArchivoPuntuaciones();
            puntuaciones.delete();
            puntuaciones.crearArchivoSiNoExisteYa();
        } catch (IOException e) {
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
