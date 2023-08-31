import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class ConcurrentSort<T extends Comparable<T>> {
    

    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private Collection<Callable<Arreglo<T>>> callables;


    public void sort(T[] array) throws InterruptedException, ExecutionException, TimeoutException
    {
        callables = new ArrayList<>();

        callables.add(new Ordenador<T>(new BubbleSort<T>(), array.clone()));
        callables.add(new Ordenador<T>(new MergeSort<T>(), array.clone()));
        callables.add(new Ordenador<T>(new QuickSort<T>(), array.clone()));

        Arreglo<T> arreglo = executor.invokeAny(callables);
        System.out.println(arreglo.getNombre());
        T[] result = arreglo.getArreglo();
        System.arraycopy(result, 0, array, 0, array.length);
 
        executor.shutdownNow();

        return result;
    }
}
