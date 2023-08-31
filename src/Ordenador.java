import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable<Arreglo<T>> {

    private StrategySort<T> algoritmo;
    private T[] arreglo;

    public Ordenador (StrategySort<T> algoritmo, T[] arreglo){
        this.algoritmo = algoritmo;
        this.arreglo = arreglo;

    }
    @Override
    public Arreglo<T> call() throws Exception {
        return algoritmo.sort(arreglo);
    }
}
