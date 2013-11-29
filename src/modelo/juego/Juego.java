package modelo.juego;

public class Juego {
    
    private static Juego instancia = new Juego();
    private Dificultad dificultad;
    private Jugador jugador;
    
    private Juego(){
        // Singleton, usar getInstance();
    }
    
    public static Juego getInstance(){
        return instancia;
    }
    
    public void ponerPorDefecto(){
        // Opciones por defecto...
        instancia.setDificultad(Juego.Dificultad.MODERADO);
        instancia.setJugador(Jugador.crearPorDefecto());
    }
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }
    
    public Jugador getJugador(){
        return jugador;        
    }
    
    public void setDificultad(Dificultad dificultad){
        this.dificultad = dificultad;
    }
    
    public Dificultad getDificultad(){
        return dificultad;
    }

    public enum Dificultad {
        FACIL(80, 1, "data/mapafacil.xml"),
        MODERADO(50, 2, "data/mapamoderado.xml"),
        DIFICIL(35, 3, "data/mapadificil.xml");
        
        private int limiteDeMovimientos;
        private int puntosPorMovimientoSobrante;
        private String archivoDelMapa;
        
        private Dificultad(int limiteDeMovimientos, int puntosPorMovimientoSobrante, String archivoDelMapa){
            this.limiteDeMovimientos = limiteDeMovimientos;
            this.puntosPorMovimientoSobrante = puntosPorMovimientoSobrante;
            this.archivoDelMapa = archivoDelMapa;
        }
        
        public int calcularPuntuacion(int movimientosRealizados){
            int movimientosSobrantes = limiteDeMovimientos - movimientosRealizados;
            int puntuacion = puntosPorMovimientoSobrante*movimientosSobrantes;
            return puntuacion > 0 ? puntuacion : 0;     
        }
        
        public int getLimiteDeMovimientos() {
            return limiteDeMovimientos;
        }
        
        public boolean superaElLimiteDeMovimientos(int movimientosRealizados){
            return movimientosRealizados > limiteDeMovimientos;
        }
        
        public String getArchivoDelMapa(){
            return archivoDelMapa;
        }
        
    }
    
}
