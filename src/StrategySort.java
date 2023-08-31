public abstract class StrategySort<T> {
    public Arreglo<T> sort(T[] arregloOriginal){
        T[] arregloOrdenado = this.ordenar(arregloOriginal);
        return new Arreglo<T>(arregloOrdenado,this.getClass().getName());
    }
    protected abstract T[] ordenar(T[] arregloOriginal);
}
