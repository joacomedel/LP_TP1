package Acciones;
import OtrasClases.Aldeano;


public class RecolectarComida extends Accion {
    public Object ejecutar(Aldeano aldeano) { 
        while(!aldeano.getCanasta().canastaLlena() && aldeano.getEnergia() > 0){
            aldeano.gastarEnergia();
            aldeano.getCanasta().guardarComida();
        }
        return aldeano.getCanasta();
    }
}
