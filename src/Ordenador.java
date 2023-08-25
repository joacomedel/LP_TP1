import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable<T[]> {

    private AlgoritmoOrdenamiento<T> algoritmo;
    private T[] arreglo;

    public Ordenador (AlgoritmoOrdenamiento<T> algoritmo, T[] arreglo){
        this.algoritmo = algoritmo;
        this.arreglo = arreglo;

    }
    @Override
    public T[] call() throws Exception {
        return algoritmo.ordenar(arreglo);
    }
}
