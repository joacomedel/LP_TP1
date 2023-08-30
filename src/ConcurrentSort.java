import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSort<T extends Comparable<T>> {
    
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    private Collection<Callable<Arreglo<T>>> callables;

    public T[] sort(T[] array) throws InterruptedException, ExecutionException
    {
        callables = new ArrayList<>();

        callables.add(new Ordenador<T>(new BubbleSort<T>(), array.clone()));
        callables.add(new Ordenador<T>(new MergeSort<T>(), array.clone()));
        callables.add(new Ordenador<T>(new QuickSort<T>(), array.clone()));
        
        Arreglo<T> arreglo = executor.invokeAny(callables);
        System.out.println(arreglo.getNombre());
        T[] result = arreglo.getArreglo();
        executor.shutdown();

        return result;
    }

}
