import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class app {
    public static void main(String[] args) {
        int[] arreglo = {10,4,8,9,5};
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Collection<Ordenador<String>> callables = new ArrayList<>();
        callables.add(new Ordenador<>(new MergeSort(), arreglo));
        mostrarArreglo(executor.invokeAny(callables));
    }
    private static void mostrarArreglo(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
        }
        System.out.println();
    }
}
