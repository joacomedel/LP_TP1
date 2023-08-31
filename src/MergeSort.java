
public class MergeSort<T extends Comparable<T>> extends StrategySort<T> {

    protected T[] ordenar(T[] array) 
    {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    public void mergeSort(T[] arr, int left, int right) 
    {
        if (left < right) 
        {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    @SuppressWarnings("unchecked")
    public void merge(T[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Object[] leftArr = new Object[n1];
        Object[] rightArr = new Object[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        
        for (int j = 0; j < n2; j++) 
            rightArr[j] = arr[middle + 1 + j];
        

        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (((T) leftArr[i]).compareTo((T) rightArr[j]) <= 0) {
                arr[k] = (T) leftArr[i];
                i++;
            } else {
                arr[k] = (T) rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = (T) leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = (T) rightArr[j];
            j++;
            k++;
        }
    }
}
