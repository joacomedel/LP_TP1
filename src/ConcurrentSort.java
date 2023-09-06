import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class ConcurrentSort<T extends Comparable<T>> {
    

    private Collection<Ordenador<T>> callables;

    public ConcurrentSort(){
        callables = new ArrayList<>();
        callables.add(new Ordenador<T>());
        callables.add(new Ordenador<T>());
        callables.add(new Ordenador<T>());
    }
    public void setModoCasiOrdenado(){
        var it = callables.iterator();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
    }
    public void setModoCuadrado(){
        var it = callables.iterator();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
    }
    public void setModoLog(){
        var it = callables.iterator();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
        //it.next().setAlgoritmo();
    }
    public String sort(T[] array) throws InterruptedException, ExecutionException, TimeoutException
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        var it = callables.iterator();
        int tamaño = callables.size();
        for (int i = 0; i < tamaño; i++) {
            it.next().setArreglo(array);
        }
        Arreglo<T> arreglo = executor.invokeAny(callables);
        T[] result = arreglo.getArreglo();
        System.arraycopy(result, 0, array, 0, array.length);
 
        executor.shutdownNow();
        return arreglo.getNombre();
    }
}
