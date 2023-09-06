import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable<Arreglo<T>> {

    private StrategySort<T> algoritmo;
    private T[] arreglo;

    public Ordenador (){

    }
    public void setAlgoritmo(StrategySort<T> algoritmo) {
        this.algoritmo = algoritmo;
    }
    public void setArreglo(T[] arreglo) {
        this.arreglo = arreglo;
    }
    @Override
    public Arreglo<T> call() throws Exception {
        Arreglo<T> retornar = null;
        if(arreglo != null && algoritmo != null){
            retornar = algoritmo.sort(arreglo);
        }
        return retornar;
    }
}
