package OtrasClases;
public class Canasta {
    private int comida;
    private int madera;
    private final static int maximo = 100;
    public void guardarMadera(){
        madera++;
    }
    public void guardarComida(){
        comida++;
    }
    public boolean canastaLlena(){
        return comida >= maximo || madera >= maximo;
    }
}
