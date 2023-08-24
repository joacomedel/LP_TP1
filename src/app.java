public class app {
    public static void main(String[] args) {
        int[] arreglo = {10,4,8,9,5};
        int [] arregloOrdenado = MergeSort.ordenar(arreglo);
        mostrarArreglo(arregloOrdenado);
    }
    private static void mostrarArreglo(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
        }
        System.out.println();
    }
}
