public class app {
    public static void main(String[] args) throws Exception 
    {
        Integer[] arreglo = {10,4,8,9,5};
        mostrarArreglo(arreglo);

        ConcurrentSort<Integer> concurrentSort = new ConcurrentSort<>();
        
        mostrarArreglo(concurrentSort.sort(arreglo));
    }

    
    private static void mostrarArreglo(Object[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " - ");
        }
        System.out.println();
    }
}
