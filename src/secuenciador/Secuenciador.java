package secuenciador;

/**
 *
 * @author Edgar Moya
 */
public class Secuenciador {

    private int numero = 0;
    private Object mutex = new Object();

    // devuelve 1 la primera vez que se invoca, 
    // 2 la segunda, etc.
    public int siguiente() {
        int res = numero;
        synchronized(mutex){
            res++;
        }
        mutex.notify();
        return res;
    }

    // suspende la ejecución de la hebra 
    // hasta que el valor sea par
    public void esperarPar() {
        while (numero % 2 != 0) esperar();
        synchronized(mutex){
            System.out.println("Par");
        }
    }

    // suspende la ejecución de la hebra 
    // hasta que el valor sea impar
    public void esperarImpar() {
        while (numero % 2 == 0) esperar();
        synchronized(mutex){
            System.out.println("Impar");
        }
    }    
    
    private void esperar() {
        synchronized (mutex) {
            try {
                mutex.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

}
