package zapatos;

/**
 *
 * @author Edgar Moya
 */
public class ObreroDerecho extends Thread{
    
    private Cesto cesto;
    
    public ObreroDerecho(Cesto cesto){
        this.cesto = cesto;
    }

    @Override
    public void run() {
        while (true) {
            // fabricar un zapato derecho Z cesto
            cesto.meterZapatoDerecho(new Zapato());
        }
    }
}
