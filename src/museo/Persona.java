package museo;

/**
 *
 * @author Edgar Moya
 */
public class Persona extends Thread{
    
    private GestorSala gestor;

    public Persona(GestorSala gestor) {    
        this.gestor = gestor;
    }

    @Override
    public void run() {
         while(true) {            
             try {
                 gestor.entrarSala();
                 Thread.sleep((long) (Math.random() * 4000));
                 gestor.salirSala();
                 Thread.sleep((long) (Math.random() * 2000));
                 gestor.entrarSalaJubilado();
             } catch (InterruptedException ex) {
             }
         }  
    }
   
}
