import java.util.concurrent.Callable;

public class Ordenador implements Callable<Object[]> {

    private AlgoritmoOrdenamiento algoritmo;
    private Object[] arreglo;

    public Ordenador (AlgoritmoOrdenamiento algoritmo, Object[] arreglo){
        this.algoritmo = algoritmo;
        this.arreglo = arreglo;

    }
    @Override
    public Object[] call() throws Exception {
        return algoritmo.ordenar(arreglo);
    }
}
