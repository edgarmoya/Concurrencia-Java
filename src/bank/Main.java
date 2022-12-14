package bank;

/**
 *
 * @author Edgar Moya
 */
public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(5000.0);
        Person p1 = new Person(bank);
        Person p2 = new Person(bank);
        Person p3 = new Person(bank);
        
        p1.start();p2.start();p3.start();
        
        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException ex) {}
    }
    
}
