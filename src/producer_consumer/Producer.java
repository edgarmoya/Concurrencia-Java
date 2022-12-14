package producer_consumer;

public class Producer extends Thread {

    private IntQueue q;

    public Producer(IntQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                Thread.sleep(500);
                q.enQueue(i);
                System.out.println("Input: "+ i);
            } catch (InterruptedException e) {
                // error
            }
        }
    }

}
