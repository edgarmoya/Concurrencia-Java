package dining_philosophers;

/**
 *
 * @author Edgar Moya
 */
public class Table {

    private boolean[] forks;
    private Object mutex = new Object();
    private Object dinerCond = new Object();

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
        return diner;
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
        }
        synchronized(dinerCond){
            dinerCond.notify();
        }
    }

    private void esperar() {
        synchronized (dinerCond) {
            try {
                dinerCond.wait();
            } catch (InterruptedException ex) {}
        }
    }
}
