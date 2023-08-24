import java.util.concurrent.Callable;

public class Ordenador<T> implements Callable {
    

    public Ordenador (){
    }
    @Override
    public Object call() throws Exception {
        T.ordenar();
    }
}
