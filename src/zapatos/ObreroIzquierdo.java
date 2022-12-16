package zapatos;

/**
 *
 * @author Edgar Moya
 */
public class ObreroIzquierdo extends Thread{
    
    private Cesto cesto;
    
    public ObreroIzquierdo(Cesto cesto){
        this.cesto = cesto;
    }

    @Override
    public void run() {
        while (true) {
            // fabricar un zapato izq Z cesto
            cesto.meterZapatoIzquierdo(new Zapato());
        }
    }
    
}
