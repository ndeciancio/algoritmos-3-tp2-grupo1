package modelo.general;

//import java.util.Random;

public class Posicion {
	//private static Random r = new Random();
	
	private Integer x;
	private Integer y;
	
	public Posicion(int coordX, int coordY){
		this.x = coordX;
		this.y = coordY;
	}
	
	public Posicion(Posicion posicion){
		this.x = posicion.getCoordenadaX();
		this.y = posicion.getCoordenadaY();
	}
	
	public Integer getCoordenadaX(){
		return this.x;
	}
	
	public Integer getCoordenadaY(){
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
	
	public void setx(Integer x){
		this.x = x;
	}
	
	public void sety(Integer y){
		this.y = y;
	}	
}
