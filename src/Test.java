import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Test {

    private static final Random random = new Random();

    // Retorna un arreglo de tamaño n con numeros aleatorios
    static private Integer[] randomArray(int n)
    {
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++)
            arr[i] = random.nextInt(1000);
        return arr;
    }

    public static boolean isOrdered(Integer[] arr) 
    {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    private static void testForXElements(int x) throws InterruptedException, ExecutionException, TimeoutException
    {
        System.out.printf("Para un arreglo de %d elementos...", x);
        Integer[] array = randomArray(x);
        ConcurrentSort<Integer> concurrentSort = new ConcurrentSort<>();
        concurrentSort.sort(array);

        System.out.printf("\nSe ordeno? %s\n", isOrdered(array) ? "SI" : "NO");
    }

    static public void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException
    {
        testForXElements(10);
        testForXElements(100);
        testForXElements(1000);
        testForXElements(10000);
        testForXElements(1000000);

        System.out.println("Good Bye!");
     //   System.exit(0);
    }
}