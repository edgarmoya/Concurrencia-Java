package museo;

/**
 *
 * @author Edgar Moya
 */
public class Temperatura extends Thread {
    
    private GestorSala gestor;

    public Temperatura(GestorSala gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {
         while(true) {
             try {
                 Thread.sleep(3500);
                 gestor.notificarTemperatura((int)(Math.random() * 40));
             } catch (InterruptedException ex) {                
             }            
         }
    }
    
    
}
