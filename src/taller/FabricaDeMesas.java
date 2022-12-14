package taller;

/**
 *
 * @author Edgar Moya
 */
public class FabricaDeMesas {

    public static void main(String[] args) {

        Taller t = new Taller(100, 10);
        ProductorDePatas pdp1 = new ProductorDePatas(t);
        ProductorDePatas pdp2 = new ProductorDePatas(t);
        ProductorDeTableros pdt = new ProductorDeTableros(t);
        EnsambladorDeMesas e = new EnsambladorDeMesas(t);
        
        pdp1.start();
        pdp2.start();
        pdt.start();
        e.start();
        
        try {
            pdp1.join();
            pdp2.join();
            pdt.join();
            e.join();
        } catch (InterruptedException ex) {}
    }

}
