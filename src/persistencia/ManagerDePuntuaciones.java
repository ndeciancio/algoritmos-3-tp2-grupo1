package persistencia;

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
	
	public void ingresarPuntuacion(File archivo, String nombre, int movimientos) throws TransformerException{
		Element jugador = documento.createElement("jugador");
		jugador.setAttribute("nombre", nombre);
		jugador.setAttribute("movimientos", Integer.toString(movimientos));
		documento.getDocumentElement().appendChild(jugador);
		actualizarDocumento(archivo);
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
		for(int i=0; i < nodos.getLength(); i++){
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
		String movimientos = jugador.getAttribute("movimientos");
		tabla.ingresar(nombre, Integer.parseInt(movimientos));
	}
	
}
