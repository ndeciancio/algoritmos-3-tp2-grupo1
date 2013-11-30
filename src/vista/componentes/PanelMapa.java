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

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;

import controladores.ControladorBotonGuardarPartida;
import controladores.ControladorKeyListener;

public class PanelMapa extends JPanel {

    private static final long serialVersionUID = 1L;
    
    protected FramePrincipal framePrincipal;
    private final int DISTANCIA_ENTRE_CUADRAS = 40; // px
    private int cuadrasEnX;
    private int cuadrasEnY;
    private JLabel labelMovimientos;
    
    public PanelMapa(FramePrincipal framePrincipal) {
       this.setLayout(null);
       this.framePrincipal = framePrincipal;
       configurarMapa();
       configurarComponentes();
    }
    
    private void configurarMapa(){
        Mapa mapa = Mapa.getInstance();
        this.cuadrasEnX = (mapa.getAncho() + 3) /2;
        this.cuadrasEnY = (mapa.getAlto() + 3) /2;
    }
    

    private JButton crearBotonGuardar(){
        JButton boton = new JButton("Guardar Partida");
        boton.addActionListener(new ControladorBotonGuardarPartida(this));
        boton.setBounds(480, 12, 150, 25);
        return boton;
    }
    
    private JLabel crearLabelMovimientos(){
        Juego juego = Juego.getInstance();
        Jugador jugador = juego.getJugador();
        int cantidadDeMovimientos = jugador.getMovimientos();
        labelMovimientos = new JLabel("Movimientos: " + cantidadDeMovimientos);
        labelMovimientos.setBounds(180, 0, 200, 50);
        return labelMovimientos;
    }
    
    private JLabel crearLabelMovimientosLimite(){
        int cantidadDeMovimientos = Juego.getInstance().getDificultad().getLimiteDeMovimientos();
        JLabel labelMovimientosLimites = new JLabel("Movimientos Limites: " + cantidadDeMovimientos);
        labelMovimientosLimites.setBounds(300, 0, 200, 50);
        labelMovimientosLimites.setForeground(Color.RED);
        return labelMovimientosLimites;
    }
    
    private JLabel crearLabelInstrucciones(){
        JLabel labelInstrucciones = new JLabel( "<html><body>Para moverse utilice <br> las flechas del Teclado</body></html>");
        labelInstrucciones.setBounds(650, 0, 200, 50);
        return labelInstrucciones;
    }
    
    protected void configurarComponentes(){
        this.add(crearLabelInstrucciones());
        this.add(crearBotonGuardar());
        this.add(crearLabelMovimientos());
        setFocusable(true);
        requestFocusInWindow();
        this.addKeyListener(new ControladorKeyListener(framePrincipal));
        this.add(crearLabelMovimientosLimite());
    }

    @Override
    protected void paintComponent(Graphics grafico) {
        super.paintComponent(grafico);
        pintarCuadras(grafico);
        pintarEventos(grafico);
        pintarJugador(grafico);
        actualizarMovimientos();
        pintarAreaInvisible(grafico);
        
    }
    
    private void actualizarMovimientos(){
        int movimientos = Juego.getInstance().getJugador().getMovimientos();
        labelMovimientos.setText("Movimientos: " + Integer.toString(movimientos));
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
    
    private void pintarAreaInvisible(Graphics grafico){
        int auxEnX = calcularXParaCentrarElMapa();
        int auxEnY = calcularYParaCentrarElMapa();
        BufferedImage imagenAreaInvisible = Imagenes.AREA_INVISIBLE.obtenerImagen();
        for (int i = 0; i < cuadrasEnX*2; i++) {
            for (int j = 0; j < cuadrasEnY*2; j++) {
                if (esAreaNegra(auxEnX,auxEnY))
                    grafico.drawImage(imagenAreaInvisible, auxEnX, auxEnY, null);
                auxEnY = auxEnY + DISTANCIA_ENTRE_CUADRAS/2;
            }
            auxEnX = auxEnX + DISTANCIA_ENTRE_CUADRAS/2;
            auxEnY = calcularYParaCentrarElMapa();
        }
    }
    
    private boolean esAreaNegra(int x, int y) {
        Posicion posMeta = calcularCoordenadas (Mapa.getInstance().getPosicionDeLaMeta());
        Posicion posJugador = calcularCoordenadas(Juego.getInstance().getJugador().getPosicionActual());
        if ( Math.abs(x - posJugador.getCoordenadaX()) <  DISTANCIA_ENTRE_CUADRAS*2) {
            if ( Math.abs(y - posJugador.getCoordenadaY()) <  DISTANCIA_ENTRE_CUADRAS*2)
            return false;
        }
        if ( Math.abs(x - posMeta.getCoordenadaX()) <  DISTANCIA_ENTRE_CUADRAS) {
            if ( Math.abs(y - posMeta.getCoordenadaY()) <  DISTANCIA_ENTRE_CUADRAS)
            return false;
        }
        return true;
    }
    

    private int calcularXParaCentrarElMapa(){
        int anchoVentana = framePrincipal.getWidth();
        int anchoMapa = calcularAnchoDelGraficoDelMapa();
        return ((anchoVentana - anchoMapa)/2);
    }
    
    private int calcularYParaCentrarElMapa(){
        /*
        int altoVentana = framePrincipal.getHeight();
        int altoMapa = calcularAltoDelGraficoDelMapa();
        return ((altoVentana - altoMapa)/2);
        */
        return 50;
    }
    
    private Posicion calcularCoordenadas (Posicion posicion) {
        int y = DISTANCIA_ENTRE_CUADRAS/2 + calcularYParaCentrarElMapa() + posicion.getCoordenadaY()*( (DISTANCIA_ENTRE_CUADRAS)/2 );
        int x = DISTANCIA_ENTRE_CUADRAS/2 + calcularXParaCentrarElMapa() + posicion.getCoordenadaX()*( DISTANCIA_ENTRE_CUADRAS/2 );
        
        Posicion coordenadas = new Posicion(x,y);
        return coordenadas;
   }
    private int calcularAnchoDelGraficoDelMapa(){
        return ((cuadrasEnX)*DISTANCIA_ENTRE_CUADRAS);
    }
    
    private int calcularAltoDelGraficoDelMapa(){
        return ((cuadrasEnY)*DISTANCIA_ENTRE_CUADRAS);
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