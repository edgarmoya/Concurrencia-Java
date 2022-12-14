package bank;

/**
 *
 * @author Edgar Moya
 */
public class Person extends Thread {

    private Bank bank;

    public Person(Bank b) {
        bank = b;
    }

    @Override
    public void run() {
        while (true) {
            try {
                double d = (Math.random() * 100);
                bank.deposit(d);
                System.out.println("(+"+d+")");
                
                double w = (Math.random() * 100);
                Thread.sleep((long) (Math.random() * 4000));
                bank.withdrawal(w);
                System.out.println("(-"+w+")");
                
                Thread.sleep((long) (Math.random() * 4000));
                System.out.println("" + bank.getMoney());
            } catch (InterruptedException ex) {}
        }
    }

}
