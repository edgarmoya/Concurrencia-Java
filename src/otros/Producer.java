package otros;


public class Producer extends Thread{

    private Queue q;

    public Producer(Queue q) {
        this.q = q;
    }

    public void run() { 
        while (true) {  //ciclo infinito
            int item = produceAnItem();//Metodo que produce elementos, no importa el tipo
            q.enQueue(item);           //y lo inserta en la cola; si la cola esta llena se queda esperando
        }
    }

    private int produceAnItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
