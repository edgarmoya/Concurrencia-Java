package otros;


public class QueueModificada {

    private static final int size = 10;
    private int[] items = new int[size];
    private int out = 0;
    private int in = 0;
    private int count = 0;
    private Object full = new Object();
    private Object empty = new Object();
    private Object lock = new Object();

    public void enQueue(int e) throws InterruptedException {
        synchronized (full) {
            while (count == items.length) {
                full.wait();//esto saca al while de la cpu, no se evalua hasta tanto full no se notifique
            }
        }
        synchronized (lock) {
            items[in] = e;
            //Entra en la seccion critica
            in = (in + 1) % size;

            count++;
        }
        //Salir de la region critica
        empty.notifyAll();//notifica a todos los que estan esperando que la pila está vacía y desbloquea lo que contenga 
        //el empty.wait()

    }

    public int deQueue() throws InterruptedException {
        int result;

        synchronized (empty) {
            while (count == 0) {
                empty.wait();
            }
        }
        synchronized (lock) {
            ///Aqui empieza la region critica
            result = items[out];
            out = (out + 1) % size;

            count--;
            //Aqui termina la seccion critica
        }

        full.notify();//eso va a desbloquear los hilos que estaba esperando por full, es decir los que estaban en 
        //full.wait()
        return result;
    }

}
