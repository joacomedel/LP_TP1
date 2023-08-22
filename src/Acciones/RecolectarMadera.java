package Acciones;
import OtrasClases.Aldeano;


public class RecolectarMadera extends Accion {
    public Object ejecutar(Aldeano aldeano) { 
        while(!aldeano.getCanasta().canastaLlena() && aldeano.getEnergia() > 0){
            aldeano.gastarEnergia();
            aldeano.getCanasta().guardarMadera();
        }
        return aldeano.getCanasta();
    }
}
