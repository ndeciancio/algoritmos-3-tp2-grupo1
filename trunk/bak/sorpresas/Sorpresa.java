package modelo.sorpresas;

import modelo.general.Posicion;

public abstract class Sorpresa {
        private Posicion posicion;
       
        public Sorpresa(Posicion posicion){
                this.posicion = posicion;
        }
}

