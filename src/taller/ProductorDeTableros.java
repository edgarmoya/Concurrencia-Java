package taller;

/**
 *
 * @author Edgar Moya
 */
public class ProductorDeTableros extends Thread {
    
    private Taller taller;
    
    public ProductorDeTableros (Taller t){
        taller = t;
    }

    @Override
    public void run() {
        while(true) producirUnTablero(taller);   
    }
      
    public void producirUnTablero(Taller t) {
        t.agregarTablero();
    }
}
