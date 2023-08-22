package OtrasClases;
import java.util.concurrent.*;
import Acciones.*;

import Acciones.Accion;
public class Aldeano implements Callable {
    private int energia;
    private Canasta canasta;
    private Accion accion;
    public  Aldeano(int energia) {
        this.energia = energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
    public int getEnergia() {
        return energia;
    }
    public Canasta getCanasta() {
        return canasta;
    }
    public void setAccion(Accion accion) {
        this.accion = accion;
    }
    public void gastarEnergia(){
        energia--;
    }
    @Override
    public Object call() throws Exception {
        return accion.ejecutar(this);
    }
}
