
public class MergeSort implements AlgoritmoOrdenamiento {

    public static <T extends Comparable<T>> int[] ordenar(int[] arreglo) {
        int[] arregloRetornar;
        if (arreglo == null || arreglo.length <= 1) {
            arregloRetornar = null;
        } else {
            arregloRetornar = arreglo.clone();
            mergeSort(arregloRetornar, 0, arreglo.length);
        }
        return arregloRetornar;
    }

   public static void mergeSort(int[] arreglo, int inicio, int fin) {
        int medio = (fin+inicio) / 2;
        if (inicio==fin) {
        }else{
            mergeSort(arreglo, inicio, medio);
            mergeSort(arreglo, medio+1, fin);
            merge(arreglo, inicio, medio, fin);
        }
        
    }

    public  static void merge(int[] arregloOriginal, int inicio, int medio, int fin) {
        int[] arregloIzq = clonRango(arregloOriginal, inicio, medio+1);
        int[] arregloDer = clonRango(arregloOriginal, medio+1 , fin+1);
        int indIzq = 0;
        int indDer = 0;
        int indOriginal = inicio;
        while (indIzq < arregloIzq.length && indDer < arregloDer.length) {
            if (arregloIzq[indIzq]>arregloDer[indDer]) {
                arregloOriginal[indOriginal] = arregloIzq[indIzq];
                indIzq++;
                indOriginal++;
            } else {
                arregloOriginal[indOriginal] = arregloDer[indDer];
                indDer++;
                indOriginal++;
            }
        }
        while (indIzq < arregloIzq.length) {
            //Si no termine de copiar el arregloIzq lo termino de copiar
            arregloOriginal[indOriginal] = arregloIzq[indIzq];
            indIzq++;
            indOriginal++;
        }
        while (indDer < arregloDer.length) {
            //Si no termine de copiar el arregloDer lo termino de copiar
            arregloOriginal[indOriginal] = arregloDer[indDer];
            indDer++;
            indOriginal++;
        }
    }

    public static  int[] clonRango(int[] arreglo, int inicio, int fin) {
        // Ingresa un arreglo con un rango , devuelve un clon del arreglo con el rango
        // de esos valores
        int length = fin - inicio  ;
        int[] arregloRetornar = new int[length];
        int i = 0;
        while (i<length) {
            arregloRetornar[i] = arreglo[inicio+i];
            i++;
        }
        return arregloRetornar;
    };
}
