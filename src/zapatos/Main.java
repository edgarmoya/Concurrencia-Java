package zapatos;

/**
 *
 * @author Edgar Moya
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cesto c = new Cesto(5);
        ObreroIzquierdo oi = new ObreroIzquierdo(c);
        ObreroDerecho od = new ObreroDerecho(c);
        Empaquetador e = new Empaquetador(c);

        oi.start();
        od.start();
        e.start();

        oi.join();
        od.join();
        e.join();
    }

}
