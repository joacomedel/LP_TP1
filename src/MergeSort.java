
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
        if (inicio+1>=fin) {
        }else{
            mergeSort(arreglo, inicio, medio);
            mergeSort(arreglo, medio, fin);
            merge(arreglo, inicio, medio, fin);
        }
        
    }

    public  static void merge(int[] arregloOriginal, int inicio, int medio, int fin) {
        int[] arregloClon = clonRango(arregloOriginal, inicio, fin);
        int indIzq = 0;
        int finClon = arregloClon.length;
        int medioClon = finClon/2;
        int indDer = medioClon;
        
        int indOriginal = inicio;
        while (indIzq < medioClon && indDer < finClon) {
            if (arregloClon[indIzq]>arregloClon[indDer]) {
                arregloOriginal[indOriginal] = arregloClon[indIzq];
                indIzq++;
                indOriginal++;
            } else {
                arregloOriginal[indOriginal] = arregloClon[indDer];
                indDer++;
                indOriginal++;
            }
        }
        while (indIzq < medioClon) {
            //Si no termine de copiar el arregloIzq lo termino de copiar
            arregloOriginal[indOriginal] = arregloClon[indIzq];
            indIzq++;
            indOriginal++;
        }
        while (indDer < finClon) {
            //Si no termine de copiar el arregloDer lo termino de copiar
            arregloOriginal[indOriginal] = arregloClon[indDer];
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
