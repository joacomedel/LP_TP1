import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class ConcurrentSort<T extends Comparable<T>> {
    

    private Collection<Ordenador<T>> callables;

    public ConcurrentSort()
    {
        callables = new ArrayList<>();
        callables.add(new Ordenador<T>());
        callables.add(new Ordenador<T>());
        callables.add(new Ordenador<T>());

        setModeMitigation();
    }

    /** Algoritmos con mejor caso en arreglos oredanados y MergeSort de seguridad */
    public void setModePartiallyOrdered()
    {
        var it = callables.iterator();
        it.next().setAlgoritmo(new BubbleSort<>());
        it.next().setAlgoritmo(new InsertionSort<>());
        it.next().setAlgoritmo(new MergeSort<>());
    }

    /** Algoritmos no adecuados para arreglos de considerablemente grandes */
    public void setModeQuadratic()
    {
        var it = callables.iterator();
        it.next().setAlgoritmo(new BubbleSort<>());
        it.next().setAlgoritmo(new SelectionSort<>());
        it.next().setAlgoritmo(new InsertionSort<>());
    }

    /** Algoritmos adecuados para arreglos de considerablemente grandes */
    public void setModeSubQuadratic()
    {
        var it = callables.iterator();
        it.next().setAlgoritmo(new QuickSort<>());
        it.next().setAlgoritmo(new HeapSort<>());
        it.next().setAlgoritmo(new MergeSort<>());
    }

    /** Mix de algoritmos para sortear situaciones generales */
    public void setModeMitigation()
    {
        var it = callables.iterator();
        it.next().setAlgoritmo(new BubbleSort<>());
        it.next().setAlgoritmo(new QuickSort<>());
        it.next().setAlgoritmo(new MergeSort<>());
    }

    /** Ordena el arreglo de manera concurrente utilizando los algoritmos establecidos en los metodos
     * setMode<mode_name> | Mitigation(default), Quadratic, SubQudratic, PartiallyOrdered
     */
    public String sort(T[] array) throws InterruptedException, ExecutionException, TimeoutException
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        var it = callables.iterator();

        while(it.hasNext())
            it.next().setArreglo(array.clone());

        Arreglo<T> arreglo = executor.invokeAny(callables);
        T[] result = arreglo.getArreglo();
        System.arraycopy(result, 0, array, 0, array.length);
 
        executor.shutdownNow();
        return arreglo.getNombre();
    }
}
