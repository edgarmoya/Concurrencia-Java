package imprimir_cadena;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        Cadena a = new Cadena("edgar", 5000);
        Cadena b = new Cadena("joaquin", 5000);
        
        a.start();
        b.start();
        
        a.join();
        b.join();
       
    } 
}
