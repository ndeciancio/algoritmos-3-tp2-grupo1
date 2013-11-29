package modelo.evento;

import java.util.HashMap;

import modelo.evento.obstaculos.Bache;
import modelo.evento.obstaculos.ControlPolicial;
import modelo.evento.obstaculos.Piquete;
import modelo.evento.sorpresas.MovimientosAdicionales;
import modelo.evento.sorpresas.ReduccionDeMovimientos;
import modelo.evento.sorpresas.RotacionDeVehiculo;
import modelo.general.Posicion;

public enum FabricaDeEventos {
    BACHE                       (new Bache(null)),
    PIQUETE                     (new Piquete(null)),
    CONTROL_POLICIAL            (new ControlPolicial(null)),
    MOVIMIENTOS_ADICIONALES     (new MovimientosAdicionales(null)),
    ROTACION_DE_VEHICULO        (new RotacionDeVehiculo(null)),
    REDUCCION_DE_MOVIMIENTOS    (new ReduccionDeMovimientos(null));
    
    private static HashMap<String, FabricaDeEventos> mapa;
    static {
        mapa = new HashMap<String, FabricaDeEventos>();
        for(FabricaDeEventos entrada : FabricaDeEventos.values()){
            mapa.put(entrada.evento.toString(), entrada);
        }
    }
    
    private Evento evento;
    
    private FabricaDeEventos(Evento evento){
        this.evento = evento;
    }
    
    public Evento obtenerEnPosicion(Posicion posicion){
        Evento devuelto = evento.copiar();
        devuelto.setPosicion(posicion);
        return devuelto;
    }
    
    public static Evento desdeString(String eventoString, Posicion posicion){
        return mapa.get(eventoString).obtenerEnPosicion(posicion);
    }
}
