import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class app {
    public static void main(String[] args) throws Exception 
    {
        Integer[] arreglo = {10,4,8,9,5};
        mostrarArreglo(arreglo);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Collection<Callable<Integer[]>> callables = new ArrayList<>();

        var ord = new Ordenador<>(new BubbleSort<>(), arreglo.clone());
        callables.add(ord);

        var a = executor.invokeAny(callables);
    
        mostrarArreglo(a);

        executor.shutdown();
    }

    
    private static void mostrarArreglo(Object[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " - ");
        }
        System.out.println();
    }
}
