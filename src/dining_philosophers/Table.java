package dining_philosophers;

/**
 *
 * @author Edgar Moya
 */
public class Table {

    private boolean[] forks;
    private Object mutex = new Object();

    public Table(int count) {
        forks = new boolean[count];
    }

    public int getLeft(int diner) {
        if (diner == 0) {
            return forks.length - 1;
        }
        return diner - 1;
    }

    public int getRigth(int diner) {
        if (diner == forks.length - 1) {
            return 0;
        }
        return diner + 1;
    }

    public void need(int diner) {
        while (forks[getLeft(diner)] || forks[getRigth(diner)]) esperar();
        synchronized(mutex){
            forks[getLeft(diner)] = true;
            forks[getRigth(diner)] = true;
            System.out.println("Filósofo " + diner + " está comiendo");
            System.out.println("Con los tenedores: "+getLeft(diner) +"-"+ getRigth(diner));
        }
    }
    
    public void put(int diner){
        synchronized(mutex){
            forks[getLeft(diner)] = false;
            forks[getRigth(diner)] = false;            
            System.out.println("Filósofo " + diner + " está pensando");
            System.out.println("Deja de utilizar los tenedores: "+getLeft(diner) +"-"+ getRigth(diner));
            mutex.notify();
        }
    }

    private void esperar() {
        synchronized (mutex) {
            try {
                mutex.wait();
            } catch (InterruptedException ex) {}
        }
    }
}
