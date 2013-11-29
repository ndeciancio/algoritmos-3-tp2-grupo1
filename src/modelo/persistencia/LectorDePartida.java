package modelo.persistencia;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.moviles.FabricaDeMoviles;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LectorDePartida {

    public void cargarPartida(Document documentoXML){
        Node raiz = documentoXML.getDocumentElement();
        cargarMapa((Element)raiz);
        cargarJugador((Element)raiz.getFirstChild());
    }
    
    private void cargarMapa(Element partidaXML){
        cargarDificultad(partidaXML);
        crearMapa(partidaXML);
    }
    
    private void cargarDificultad(Element partidaXML){
        String stringDificultad = partidaXML.getAttribute("dificultad");
        Juego.Dificultad dificultad = Juego.Dificultad.desdeString(stringDificultad);
        Juego.getInstance().setDificultad(dificultad);
    }
    
    private void crearMapa(Element partidaXML){
        FachadaPersistencia persistencia = new FachadaPersistencia();
        Juego juego = Juego.getInstance();
        persistencia.cargarMapa(juego.getDificultad().getArchivoDelMapa());
        crearMeta((Element)partidaXML.getLastChild());
    }
    
    private void crearMeta(Element metaXML){
        int x = Integer.parseInt(metaXML.getAttribute("x"));
        int y = Integer.parseInt(metaXML.getAttribute("y"));
        Mapa.getInstance().generarMeta(new Posicion(x, y));
    }
    
    private void cargarJugador(Element jugadorXML){
        Jugador jugador = Juego.getInstance().getJugador();
        cargarPosicion(jugador, jugadorXML);
        cargarMovimientos(jugador, jugadorXML);
        cargarMovil(jugador, jugadorXML);
    }
    
    private void cargarPosicion(Jugador jugador, Element jugadorXML){
        int x = Integer.parseInt(jugadorXML.getAttribute("x"));
        int y = Integer.parseInt(jugadorXML.getAttribute("y"));
        jugador.setPosicionInicial(new Posicion(x, y));
    }
    
    private void cargarMovimientos(Jugador jugador, Element jugadorXML){
        int movimientos = Integer.parseInt(jugadorXML.getAttribute("movimientos"));
        jugador.setMovimientos(movimientos);
    }
    
    private void cargarMovil(Jugador jugador, Element jugadorXML){
        String tipo = jugadorXML.getAttribute("movil");
        jugador.setMovil(FabricaDeMoviles.desdeString(tipo));
    }
}
