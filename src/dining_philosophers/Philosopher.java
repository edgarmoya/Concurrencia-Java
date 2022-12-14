package dining_philosophers;

import static java.lang.Thread.sleep;

/**
 *
 * @author Edgar Moya
 */
public class Philosopher extends Thread {

    private Table table;
    private int diner;

    public Philosopher(Table m, int diner) {
        this.table = m;
        this.diner = diner;
    }

    public void run() {
        while (true) {
            pensando();
            table.need(diner);
            comiendo();
            table.put(diner);
        }
    }

    public void pensando() {
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {}
    }

    public void comiendo() {
        try {
            sleep((long) (Math.random() * 4000));
        } catch (InterruptedException ex) {}
    }
}
