import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable {
    private AlgoritmoOrdenamiento algoritmo;
    private int[] arreglo;
    public Ordenador (AlgoritmoOrdenamiento algoritmoOrdenamiento ,int[] arreglo){
        this.algoritmo = algoritmo;
        this.arreglo = arreglo;

    }
    @Override
    public Object call() throws Exception {
        return algoritmo.ordenar(arreglo);
    }
}
