package bank;

/**
 *
 * @author Edgar Moya
 */
public class Bank {
    
    private double money;
    private Object mutex = new Object();

    public Bank(double money) {
        this.money = money;
    }
    
    public void deposit(double m){
        synchronized(mutex){
            money += m;
        }       
    }
    
    public void withdrawal(double m){
        synchronized(mutex){
            money -= m;
        }
    }
    
    public double getMoney(){
        synchronized(mutex){
            return money;
        }
    }
}
