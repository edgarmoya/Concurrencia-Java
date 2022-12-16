package museo;

/**
 *
 * @author Edgar Moya
 */
public class Main {

    public static void main(String[] args) {
        GestorSala gs = new GestorSala(10);
        Persona p = new Persona(gs);
        Temperatura t = new Temperatura(gs);
        
        t.start();
        p.start();
        
        try {
            t.join();
            p.join();
        } catch (InterruptedException ex) {
        }
    }
    
}
