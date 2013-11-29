package modelo.persistencia;

import modelo.evento.Evento;
import modelo.evento.FabricaDeEventos;
import modelo.general.Mapa;
import modelo.general.Posicion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CreadorDeMapa {

    public void cargarMapa(Document documentoXML){
        Mapa.getInstance().limpiarEventos();
        Node nodoMapa = documentoXML.getDocumentElement();
        cargarPropiedades((Element)nodoMapa);
        cargarEventos(nodoMapa);
    }
    
    private void cargarPropiedades(Element raiz){
        int ancho = Integer.parseInt(raiz.getAttribute("ancho"));
        int alto = Integer.parseInt(raiz.getAttribute("alto"));
        Mapa.getInstance().setAlto(ancho);
        Mapa.getInstance().setAlto(alto);
    }
    
    private void cargarEventos(Node raiz){
        NodeList nodos = raiz.getChildNodes();
        for(int i = 0; i < nodos.getLength(); i++){
            Node nodo = nodos.item(i);
            if(esElemento(nodo))
                cargarEvento((Element)nodo);
        }
    }
    
    private void cargarEvento(Element nodo){
        Posicion posicion = cargarPosicion(nodo);
        Evento evento = cargarEvento(nodo, posicion);
        Mapa.getInstance().addEvento(evento);
    }
    
    private Posicion cargarPosicion(Element evento){
        int x = Integer.parseInt(evento.getAttribute("x"));
        int y = Integer.parseInt(evento.getAttribute("y"));
        return new Posicion(x, y);
    }
    
    private Evento cargarEvento(Element evento, Posicion posicion){
        String nombre = evento.getAttribute("nombre");
        return FabricaDeEventos.desdeString(nombre, posicion);
    }
    
    private boolean esElemento(Node nodo){
        return nodo instanceof Element;
    }
    
}
