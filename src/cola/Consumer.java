package cola;

public class Consumer extends Thread{
    
    private IntQueue q;

    public Consumer(IntQueue q) {
        this.q = q;
    }
    
    @Override
    public void run(){
        while(true){
            int r = 0;
            try {
                Thread.sleep(1000);
                r = q.deQueue();
                System.out.println("Output: "+r);
            } catch (InterruptedException ex) {
                // error
            }
        }
    }
}
