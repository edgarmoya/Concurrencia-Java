package dining_philosophers;

/**
 *
 * @author Edgar Moya
 */
public class Main {

    public static void main(String[] args) {
        Table m = new Table(5);
        for (int i = 0; i < 5; i++) {
            Philosopher f = new Philosopher(m, i);
            f.start();          
        }          
    }
    
}
