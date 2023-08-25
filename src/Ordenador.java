import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable<Comparable<T>[]> {

    private AlgoritmoOrdenamiento<T> algoritmo;
    private Comparable<T>[] arreglo;

    public Ordenador (AlgoritmoOrdenamiento<T> algoritmo, Comparable<T>[] arreglo){
        this.algoritmo = algoritmo;
        this.arreglo = arreglo;

    }
    @Override
    public Comparable<T>[] call() throws Exception {
        return algoritmo.ordenar(arreglo);
    }
}
