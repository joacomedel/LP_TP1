public class QuickSort<T extends Comparable<T>> implements AlgoritmoOrdenamiento<T> {
    
    public T[] ordenar(T[] arregloOriginal) 
    {
        quickSort(arregloOriginal, 0, arregloOriginal.length - 1);
        return arregloOriginal;
    }

    private void quickSort(T[] array, int left, int right) 
    {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private int partition(T[] array, int left, int right) 
    {
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) 
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
