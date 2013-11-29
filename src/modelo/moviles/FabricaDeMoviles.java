package modelo.moviles;

import java.util.HashMap;

public enum FabricaDeMoviles {
    AUTOMOVIL(new Automovil()),
    MOTO(new Moto()),
    CUATRO_X_CUATRO(new CuatroXCuatro());
    
    private static HashMap<String, Movil> mapaDesdeString;
    static {
        mapaDesdeString = new HashMap<String, Movil>();
        for(FabricaDeMoviles entrada : FabricaDeMoviles.values()){
            mapaDesdeString.put(entrada.movil.toString(), entrada.movil);
        }
    }
    
    private Movil movil;
    
    private FabricaDeMoviles(Movil movil){
        this.movil = movil;
    }
    
    public Movil getInstance(){
        return movil;
    }
    
    public static Movil desdeString(String tipoDeMovil){
        return mapaDesdeString.get(tipoDeMovil);
    }

}
