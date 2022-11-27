package otros;


public class Consummer extends Thread{
    private Queue q;

    public Consummer(Queue q) {
        this.q = q;
    }
    
    public void run(){
        int r;
        while(true){
            r=q.deQueue();
            consumeAnItem(r);
        }
    }

    private void consumeAnItem(int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
