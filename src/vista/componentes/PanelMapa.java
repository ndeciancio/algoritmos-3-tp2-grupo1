package vista.componentes;

import java.awt.image. BufferedImage;

import vista.imagenes.Imagenes;
import modelo.evento.Evento;
import modelo.general.Mapa;
import modelo.general.Posicion;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.moviles.Movil;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;

import controladores.ControladorBotonMoverDerecha;
import controladores.ControladorBotonMoverAbajo;
import controladores.ControladorBotonMoverIzquierda;
import controladores.ControladorBotonMoverArriba;

public class PanelMapa extends JPanel {

    private static final long serialVersionUID = 1L;
    
    protected FramePrincipal framePrincipal;
    private final int DISTANCIA_ENTRE_CUADRAS = 40; // px
    private int cuadrasEnX;
    private int cuadrasEnY;
    
    public PanelMapa(FramePrincipal framePrincipal) {
       this.framePrincipal = framePrincipal;
       configurarMapa();
       configurarComponentes();
    }
    
    private void configurarMapa(){
        Mapa mapa = Mapa.getInstance();
        this.cuadrasEnX = (mapa.getAncho() + 3) /2;
        this.cuadrasEnY = (mapa.getAlto() + 3) /2;
    }
    
    private JButton crearBotonMoverAbajo(){
        JButton boton = new JButton("Abajo");
        boton.addActionListener(new ControladorBotonMoverAbajo(framePrincipal));
        return boton;
    }
    
    private JButton crearBotonMoverDerecha(){
        JButton boton = new JButton("Derecha");
        boton.addActionListener(new ControladorBotonMoverDerecha(framePrincipal));
        return boton;
    }
    
    private JButton crearBotonMoverIzquierda(){
        JButton boton = new JButton("Izquierda");
        boton.addActionListener(new ControladorBotonMoverIzquierda(framePrincipal));
        return boton;
    }
    
    private JButton crearBotonMoverArriba(){
        JButton boton = new JButton("Arriba");
        boton.addActionListener(new ControladorBotonMoverArriba(framePrincipal));
        return boton;
    }
    
    private JLabel crearLabelMovimientos(){
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        int cantidadDeMovimientos = jugador.getMovimientos();
        JLabel label = new JLabel("Movimientos: " + cantidadDeMovimientos);
        return label;
    }
    
    protected void configurarComponentes(){
        this.add(crearBotonMoverIzquierda());
        this.add(crearBotonMoverAbajo());
        this.add(crearBotonMoverArriba());
        this.add(crearBotonMoverDerecha());     
        this.add(crearLabelMovimientos());
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
        int centradoEnX= imagenEvento.getWidth()/2;
        int centradoEnY= imagenEvento.getHeight()/2;
        grafico.drawImage(imagenEvento, coordenada.getCoordenadaX() + centradoEnX, coordenada.getCoordenadaY() + centradoEnY, null);
    }        

    private void pintarJugador(Graphics grafico){
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        Movil movil = jugador.getMovil();
        BufferedImage imagenMovil = Imagenes.pngDesdeObjeto(movil);
        Posicion coordenada = calcularCoordenadas(jugador.getPosicionActual());
        grafico.drawImage(imagenMovil, coordenada.getCoordenadaX() , coordenada.getCoordenadaY() , null);
    }
    
}