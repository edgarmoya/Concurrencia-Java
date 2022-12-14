package producer_consumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        IntQueue q = new IntQueue(20);
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        p.start();
        c.start();

        p.join();
        c.join();
    }
}
