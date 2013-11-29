package modelo.persistencia;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.moviles.FabricaDeMoviles;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LectorDePartida {

    Element partidaXML;
    Element jugadorXML;
    Element metaXML;
    
    public void cargarPartida(Document documentoXML){
        Node raiz = documentoXML.getDocumentElement();
        cargarElementosXML(raiz);
        cargarMapa();
        cargarJugador();
    }
    
    private void cargarElementosXML(Node raiz){
        partidaXML = (Element)raiz;
        jugadorXML = buscarElementoPorNombre(raiz, "jugador");
        metaXML = buscarElementoPorNombre(raiz, "meta");
    }
    
    private void cargarMapa(){
        cargarDificultad();
        crearMapa();
    }
    
    private void cargarDificultad(){
        String stringDificultad = partidaXML.getAttribute("dificultad");
        Juego.Dificultad dificultad = Juego.Dificultad.desdeString(stringDificultad);
        Juego.getInstance().setDificultad(dificultad);
    }
    
    private void crearMapa(){
        FachadaPersistencia persistencia = new FachadaPersistencia();
        Juego juego = Juego.getInstance();
        persistencia.cargarMapa(juego.getDificultad().getArchivoDelMapa());
        crearMeta();
    }
    
    private void crearMeta(){
        int x = Integer.parseInt(metaXML.getAttribute("x"));
        int y = Integer.parseInt(metaXML.getAttribute("y"));
        Mapa.getInstance().generarMeta(new Posicion(x, y));
    }
    
    private void cargarJugador(){
        Jugador jugador = Juego.getInstance().getJugador();
        cargarPosicion(jugador);
        cargarMovimientos(jugador);
        cargarMovil(jugador);
    }
    
    private void cargarPosicion(Jugador jugador){
        int x = Integer.parseInt(jugadorXML.getAttribute("x"));
        int y = Integer.parseInt(jugadorXML.getAttribute("y"));
        jugador.setPosicionInicial(new Posicion(x, y));
    }
    
    private void cargarMovimientos(Jugador jugador){
        int movimientos = Integer.parseInt(jugadorXML.getAttribute("movimientos"));
        jugador.setMovimientos(movimientos);
    }
    
    private void cargarMovil(Jugador jugador){
        String tipo = jugadorXML.getAttribute("movil");
        jugador.setMovil(FabricaDeMoviles.desdeString(tipo));
    }
    
    private Element buscarElementoPorNombre(Node raiz, String nombre){
        NodeList nodos = raiz.getChildNodes();
        Element elementoDevuelto = null;
        for(int i = 0; i < nodos.getLength(); i++){
            Node nodo = nodos.item(i);
            if(esElemento(nodo) && tieneElNombreBuscado(nodo, nombre))
                elementoDevuelto = (Element)nodo;
        }
        return elementoDevuelto;
    }
    
    private boolean esElemento(Node nodo){
        return nodo instanceof Element;
    }
    
    private boolean tieneElNombreBuscado(Node nodo, String nombre){
        return ((Element)nodo).getNodeName().equals(nombre);
    }
}
