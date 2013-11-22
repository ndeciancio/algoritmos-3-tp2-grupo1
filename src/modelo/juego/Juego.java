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
    
    public static void reiniciar(){
        instancia.setDificultad(null);
        instancia.setJugador(null);
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
        FACIL(80, 1),
        MODERADO(50, 2),
        DIFICIL(35, 3);
        
        private int limiteDeMovimientos;
        private int puntosPorMovimientoSobrante;
        
        private Dificultad(int limiteDeMovimientos, int puntosPorMovimientoSobrante){
            this.limiteDeMovimientos = limiteDeMovimientos;
            this.puntosPorMovimientoSobrante = puntosPorMovimientoSobrante;
        }
        
        public int calcularPuntuacion(int movimientosRealizados){
            int movimientosSobrantes = limiteDeMovimientos - movimientosRealizados;
            int puntuacion = puntosPorMovimientoSobrante*movimientosSobrantes;
            return puntuacion > 0 ? puntuacion : 0;     
        }
        
        public boolean superaElLimiteDeMovimientos(int movimientosRealizados){
            return movimientosRealizados > limiteDeMovimientos;
        }
        
    }
    
}
