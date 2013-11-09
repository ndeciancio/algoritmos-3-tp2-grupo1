package modelo.mapa;

import modelo.mapa.eventos.Evento;

public class Mapa {

    private Evento[][] eventos;
    
    public Evento eventoEnPosicion(int x, int y){
        return eventos[x][y];
    }
}
