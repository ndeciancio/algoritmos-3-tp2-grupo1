package modelo.evento;

import modelo.evento.obstaculos.Bache;
import modelo.evento.obstaculos.ControlPolicial;
import modelo.evento.obstaculos.Piquete;
import modelo.evento.sorpresas.MovimientosAdicionales;
import modelo.evento.sorpresas.ReduccionDeMovimientos;
import modelo.evento.sorpresas.RotacionDeVehiculo;
import modelo.general.Posicion;

public class FabricaDeEventos {
    
    public Evento crearBache(Posicion posicion){
        return new Bache(posicion);
    }
    
    public Evento crearPiquete(Posicion posicion){
        return new Piquete(posicion);
    }
    
    public Evento crearControlPolicial(Posicion posicion){
        return new ControlPolicial(posicion);
    }
    
    public Evento crearMovimientosAdicionales(Posicion posicion){
        return new MovimientosAdicionales(posicion);
    }
    
    public Evento crearReduccionDeMovimientos(Posicion posicion){
        return new ReduccionDeMovimientos(posicion);
    }
    
    public Evento crearRotacionDeVehiculo(Posicion posicion){
        return new RotacionDeVehiculo(posicion);
    }
    
    public Evento desdeString(String nombre, Posicion posicion){
        
        switch(nombre){
        
        case "Bache": 
            return crearBache(posicion);
        
        case "ControlPolicial": 
            return crearControlPolicial(posicion);
        
        case "Piquete": 
            return crearPiquete(posicion);
        
        case "MovimientosAdicionales": 
            return crearMovimientosAdicionales(posicion);
        
        case "ReduccionDeMovimientos": 
            return crearReduccionDeMovimientos(posicion);
        
        case "RotacionDeVehiculo": 
            return crearRotacionDeVehiculo(posicion);
            
        default:
            return null;
            
        }
        
    }
    
}
