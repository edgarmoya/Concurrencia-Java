package zapatos;

/**
 *
 * @author Edgar Moya
 */
public class Empaquetador extends Thread {

    private Cesto cesto;

    public Empaquetador(Cesto cesto) {
        this.cesto = cesto;
    }

    @Override
    public void run() {
        while (true) {
            cesto.empaquetar();
        }

    }
}
