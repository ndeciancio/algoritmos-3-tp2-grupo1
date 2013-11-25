package vista.componentes;

import java.awt.image. BufferedImage;

import vista.imagenes.Imagenes;
import modelo.evento.Evento;
import modelo.general.Mapa;
import modelo.general.Posicion;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

public class PanelMapa extends PanelCentrado {

    private static final long serialVersionUID = 1L;
    
    private final int DISTANCIA_ENTRE_CUADRAS = 40; // px
    private int cuadrasEnX;
    private int cuadrasEnY;
    
    public PanelMapa(FramePrincipal framePrincipal) {
       super(framePrincipal);
       configurarMapa();
    }
    
    private void configurarMapa(){
        Mapa mapa = Mapa.getInstance();
        this.cuadrasEnX = (mapa.getAncho() + 3) /2;
        this.cuadrasEnY = (mapa.getAlto() + 3) /2;
    }

    @Override
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        pintarCuadras(grafico);
        pintarEventos(grafico);
        pintarJugador(grafico);
    }
    
    private void pintarCuadras(Graphics grafico){
        int auxEnX = calcularXParaCentrarElMapa();
        int auxEnY = calcularYParaCentrarElMapa();
        BufferedImage imagenCuadra = Imagenes.CUADRA.obtenerImagen();
        for (int i = 0; i < cuadrasEnX; i++) {
            for (int j = 0; j < cuadrasEnY; j++) {
                grafico.drawImage(imagenCuadra, auxEnX, auxEnY, null);
                auxEnY = auxEnY + DISTANCIA_ENTRE_CUADRAS;
            }
            auxEnX = auxEnX + DISTANCIA_ENTRE_CUADRAS;
            auxEnY = calcularYParaCentrarElMapa();
        }
    }
    
    private int calcularXParaCentrarElMapa(){
        int anchoVentana = framePrincipal.getWidth();
        int anchoMapa = calcularAnchoDelGraficoDelMapa();
        return ((anchoVentana - anchoMapa)/2);
    }
    
    private int calcularYParaCentrarElMapa(){
        int altoVentana = framePrincipal.getHeight();
        int altoMapa = calcularAltoDelGraficoDelMapa();
        return ((altoVentana - altoMapa)/2);
    }
    
    private Posicion calcularCoordenadas (Posicion posicion) {
        int y = DISTANCIA_ENTRE_CUADRAS/2 + calcularYParaCentrarElMapa() + posicion.getCoordenadaY()*( (DISTANCIA_ENTRE_CUADRAS)/2 );
        int x = DISTANCIA_ENTRE_CUADRAS/2 + calcularXParaCentrarElMapa() + posicion.getCoordenadaX()*( DISTANCIA_ENTRE_CUADRAS/2 );
        
        Posicion coordenadas = new Posicion(x,y);
        return coordenadas;
   }
    private int calcularAnchoDelGraficoDelMapa(){
        int anchoDeUnaCuadra = Imagenes.CUADRA.obtenerImagen().getWidth();
        return (cuadrasEnX*anchoDeUnaCuadra + (cuadrasEnX - 1)*DISTANCIA_ENTRE_CUADRAS);
    }
    
    private int calcularAltoDelGraficoDelMapa(){
        int altoDeUnaCuadra = Imagenes.CUADRA.obtenerImagen().getHeight();
        return (cuadrasEnY*altoDeUnaCuadra + (cuadrasEnY - 1)*DISTANCIA_ENTRE_CUADRAS);
    }
    
    private void pintarEventos(Graphics grafico){
        Mapa mapa = Mapa.getInstance();
        List<Evento> eventos= mapa.getEventos();
        Iterator<Evento> it = eventos.iterator();
        while (it.hasNext()) {
            Evento evento = it.next();
            pintarEvento(evento,grafico);
        }
    }
    
    private void pintarEvento(Evento evento,Graphics grafico) {
        Posicion coordenada = calcularCoordenadas(evento.getPosicion());
        BufferedImage imagenEvento = Imagenes.pngDesdeObjeto(evento);
        grafico.drawImage(imagenEvento, coordenada.getCoordenadaX(), coordenada.getCoordenadaY(), null);
        
    }
    private void pintarJugador(Graphics jugador){
        // PINTAR AL JUGADOR
    }
    
}