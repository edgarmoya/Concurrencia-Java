package taller;

/**
 *
 * @author Edgar Moya
 */
public class EnsambladorDeMesas extends Thread{

    private Taller taller;
    
    public EnsambladorDeMesas(Taller t){
        taller = t;
    }

    @Override
    public void run() {
        while(true) producirUnaMesa(taller);  
    }
    
    public void producirUnaMesa(Taller t) {
        t.ensamblarMesa();
    }
}
