package modelo.persistencia;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Juego;
import modelo.juego.Juego.Dificultad;
import modelo.juego.Jugador;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EscritorDePartida {

    private Document documentoXML;
    
    public void guardarPartida(Document documentoXML, File archivoPartida) throws TransformerException{
        this.documentoXML = documentoXML;
        Element partida = crearNodoPartida();
        crearMeta(partida);
        crearJugador(partida);
        guardarXML(archivoPartida);
    }
    
    private Element crearNodoPartida(){
        Element partida = documentoXML.getDocumentElement();
        partida.setAttribute("dificultad", stringDificultad());
        return partida;
    }
    
    private String stringDificultad(){
        Dificultad dificultad = Juego.getInstance().getDificultad();
        return dificultad.toString();
    }
    
    private void crearMeta(Element partida){
        Element nodoMeta = documentoXML.createElement("meta");
        configurarMeta(nodoMeta);
        partida.appendChild(nodoMeta);
    }
    
    private void configurarMeta(Element nodoMeta){
        Posicion posicion = Mapa.getInstance().getPosicionDeLaMeta();
        nodoMeta.setAttribute("x", posicion.getCoordenadaX().toString());
        nodoMeta.setAttribute("y", posicion.getCoordenadaY().toString());
    }
    
    private void crearJugador(Element partida){
        Element nodoJugador = documentoXML.createElement("jugador");
        configurarJugador(nodoJugador);
        partida.appendChild(nodoJugador);
    }
    
    private void configurarJugador(Element nodoJugador){
        Jugador jugador = Juego.getInstance().getJugador();
        configurarMovimientos(jugador, nodoJugador);
        configurarPosicion(jugador, nodoJugador);
        configurarMovil(jugador, nodoJugador);
    }
    
    private void configurarMovimientos(Jugador jugador, Element jugadorXML){
        String movimientos = jugador.getMovimientos().toString();
        jugadorXML.setAttribute("movimientos", movimientos);
    }
    
    private void configurarPosicion(Jugador jugador, Element jugadorXML){
        Posicion posicion = jugador.getPosicionActual();
        jugadorXML.setAttribute("x", posicion.getCoordenadaX().toString());
        jugadorXML.setAttribute("y", posicion.getCoordenadaY().toString());
    }
    
    private void configurarMovil(Jugador jugador, Element jugadorXML){
        jugadorXML.setAttribute("movil", jugador.getMovil().toString());
    }
    
    private void guardarXML(File archivoPartida) throws TransformerException{
        DOMSource fuente = new DOMSource(documentoXML);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformador = transformerFactory.newTransformer();
        StreamResult resultado = new StreamResult(archivoPartida);
        transformador.transform(fuente, resultado);
    }
    
}
