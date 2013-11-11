package modelo.juego;

//import modelo.general.Mapa;

public class Jugador {

	//	private Mapa mapaDeJuego = Mapa.getInstance();
	private Integer movimientos;
	
    public void sumarMovimientos(int movimientos){
        this.movimientos += movimientos;
    }

}
