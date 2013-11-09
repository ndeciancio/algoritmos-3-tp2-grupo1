package modelo.jugador;

public class Posicion {

    private int x;
    private int y;
    
    public Posicion(int xInicial, int yInicial){
        this.x = xInicial;
        this.y = yInicial;
    }
    
    public Posicion(Posicion posicion) {
        this.x = posicion.x();
        this.y = posicion.y();
    }

    public int x(){
        return x;
    }
    
    public int y(){
        return y;
    }
    
    // Visibilidad de paquete.
    // Solo el jugador puede modificar su propia posición.
    
    void setx(int x){
        this.x = x;
    }
    
    void sety(int y){
        this.y = y;
    }
}
