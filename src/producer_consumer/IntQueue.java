package producer_consumer;

public class IntQueue {

    private final int size;
    private final int[] items;
    private int out;
    private int in;
    private int count;
    private final Object full = new Object();
    private final Object empty = new Object();
    private final Object lock = new Object();

    public IntQueue(int size) {
        this.size = size;
        items = new int[size];
        out = 0;
        in = 0;
        count = 0;
    }

    // CÓDIGO CON ERRORES
    /*public void enQueue(int e) {
        while (count == items.length){}
        items[in] = e;
        in = (in + 1) % size;
        count++;
    }

    public int deQueue() {
        int result;
        while (count == 0) {}
        result = items[out];
        out = (out + 1) % size;
        count--;
        return result;
    }*/
    
    public void enQueue(int e) throws InterruptedException {
        synchronized (full) {
            while (count == items.length) {
                full.wait();
            }
        }
        synchronized (lock) {
            items[in] = e;
            in = (in + 1) % size;
            count++;
        }
        synchronized (empty) {
            empty.notify();
        }
    }

    public int deQueue() throws InterruptedException {
        int result = 0;
        synchronized (empty) {
            while (count == 0) {
                empty.wait();
            }
        }
        synchronized (lock) {
            result = items[out];
            out = (out + 1) % size;
            count--;
        }
        synchronized (full) {
            full.notify();
        }
        return result;
    }
}
