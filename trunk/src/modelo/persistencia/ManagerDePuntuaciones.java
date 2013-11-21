package modelo.persistencia;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ManagerDePuntuaciones {

	private Document documento;
	private TablaDePuntuaciones tabla;
	
	public ManagerDePuntuaciones(Document documento){
		this.documento = documento;
	}
	
	public void ingresarPuntuacion(File archivo, String nombre, int puntuacion) throws TransformerException{
		quitarJugadorPorNombre(nombre);
	    Element jugador = documento.createElement("jugador");
		jugador.setAttribute("nombre", nombre);
		jugador.setAttribute("puntuacion", Integer.toString(puntuacion));
		documento.getDocumentElement().appendChild(jugador);
		actualizarDocumento(archivo);
	}
	
	private void quitarJugadorPorNombre(String nombre){
	    NodeList nodos = documento.getDocumentElement().getChildNodes();
	    Element jugadorEliminado = null;
	    for(int i = 0; i < nodos.getLength(); i++){
	        Node nodo = nodos.item(i);
	        if(esElemento(nodo) && ((Element)nodo).getAttribute("nombre").equals(nombre))
	            jugadorEliminado = (Element)nodo;
	    }
	    if(jugadorEliminado != null)
	        eliminarJugador(jugadorEliminado);
	}
	
	private void eliminarJugador(Element jugador){
	    jugador.getParentNode().removeChild(jugador);
	}
	
	private void actualizarDocumento(File archivo) throws TransformerException {
		DOMSource fuente = new DOMSource(documento);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformador = transformerFactory.newTransformer();
		StreamResult resultado = new StreamResult(archivo);
		transformador.transform(fuente, resultado);
	}
	
	public TablaDePuntuaciones cargarPuntuaciones(){
		NodeList nodos = documento.getDocumentElement().getChildNodes();
		tabla = new TablaDePuntuaciones();
		for(int i = 0; i < nodos.getLength(); i++){
			Node nodo = nodos.item(i);
			if(esElemento(nodo))
				cargarJugadorEnTabla((Element)nodo);
		}
		return tabla;
	}
	
	private boolean esElemento(Node nodo){
		return nodo instanceof Element;
	}
	
	private void cargarJugadorEnTabla(Element jugador){
		String nombre = jugador.getAttribute("nombre");
		String puntuacion = jugador.getAttribute("puntuacion");
		tabla.ingresar(nombre, Integer.parseInt(puntuacion));
	}
	
}
