public class Arreglo<T> {
    private String nombre;
    private T[] arreglo;
    public Arreglo(T[] arreglo ,String nombre){
        this.nombre = nombre;
        this.arreglo= arreglo;
    }
    public T[] getArreglo() {
        return arreglo;
    }
    public String getNombre() {
        return nombre;
    }
}
