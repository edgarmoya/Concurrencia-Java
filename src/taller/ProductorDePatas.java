package taller;

/**
 *
 * @author Edgar Moya
 */
public class ProductorDePatas extends Thread {

    private Taller taller;

    public ProductorDePatas(Taller t) {
        taller = t;
    }

    @Override
    public void run() {
        while (true) producirUnaPata(taller);        
    }

    public void producirUnaPata(Taller t) {
        t.agregarPata();
    }

}
