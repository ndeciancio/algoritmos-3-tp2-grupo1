package modelo.jugador;

public class Posicion {

    private Integer x;
    private Integer y;
    
    public Posicion(int coordX, int coordY){
        this.x = coordX;
        this.y = coordY;
    }

    public Integer getCoordX(){
        	return this.x;
    }

    public Integer getCoordY(){
    		return this.y;
    }

    @Override
    public boolean equals(Object obj) {
        	Posicion other = (Posicion) obj;
        	if (x == null) {
        			if (other.x != null)
        					return false;
        	} else if (!x.equals(other.x))
                return false;
        	if (y == null) {
                	if (other.y != null)
                        	return false;
        	} else if (!y.equals(other.y))
                	return false;
        	return true;
    }
    
    // Visibilidad de paquete.
    // Solo el jugador puede modificar su propia posición.
    
    void setx(Integer x){
        this.x = x;
    }
    
    void sety(Integer y){
        this.y = y;
    }
}
