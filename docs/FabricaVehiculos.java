// Ejemplo de uso:
// Vehiculo unVehiculo = FabricaVehiculos.MOTOCICLETA.obtenerNuevo();
// unVehiculo.aumentarMovimientos(1);
// FabricaVehiculos.AUTOMOVIL.reemplazar(unVehiculo);
// En este punto, unVehiculo tiene una referencia a un objeto Vehiculo
// en estado de automovil, con un movimiento realizado.

package modelo.vehiculos

public enum FabricaVehiculos {
    MOTOCICLETA(new EstadoMotocicleta()),
    AUTOMOVIL(new EstadoAutomovil()),
    CUATRO_POR_CUATRO(new Estado4x4());

    private EstadoVehiculo estadoPorDefecto;

    private FabricaVehiculos(EstadoVehiculo estadoPorDefecto){
        this.estadoPorDefecto = estadoPorDefecto;
    }

    public Vehiculo obtenerNuevo(){
        return new Vehiculo(estadoPorDefecto);
    }

    public void reemplazar(Vehiculo unVehiculo){
        unVehiculo.setEstado(estadoPorDefecto);
    }

}
