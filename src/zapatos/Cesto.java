package zapatos;

/**
 *
 * @author Edgar Moya
 */
public class Cesto {
    
    private int capacidad;
    private int zapatosIzq, zapatosDer;
    private Object mutex = new Object();
    private Object izqMeterCond = new Object();
    private Object derMeterCond = new Object();
    private Object izqSacarCond = new Object();
    private Object derSacarCond = new Object();
    

    public Cesto(int capacidad){
        this.capacidad = capacidad;
    }

    public void meterZapatoDerecho(Zapato z){
        while(zapatosDer+zapatosIzq >= capacidad) esperarMeterZapatoDer();
        synchronized(mutex){
            zapatosDer++;
            System.out.println("Meter zapato derecho: "+zapatosDer);
        }    
        synchronized(derSacarCond){
            derSacarCond.notify();
        }
    }

    public void meterZapatoIzquierdo(Zapato z){
        while(zapatosDer+zapatosIzq >= capacidad) esperarMeterZapatoIzq();
        synchronized(mutex){
            zapatosIzq++;
            System.out.println("Meter zapato izquierdo: "+zapatosIzq);
        } 
        synchronized(izqSacarCond){
            izqSacarCond.notify();
        }
    }
    
    public void empaquetar(){
        while(zapatosIzq <= 0 || zapatosDer <= 0) esperarSacarZapatoIzq();
        synchronized(mutex){
            zapatosIzq --;
            zapatosDer --;
            System.out.println("Empaquetar un par");
        }  
        synchronized(derMeterCond){
            derMeterCond.notify();
        } 
        synchronized(izqMeterCond){
            izqMeterCond.notify();
        }  
    }
    
    // esperar
    public void esperarMeterZapatoIzq(){
        try {
            synchronized(izqMeterCond){
                izqMeterCond.wait();
            }  
        } catch (InterruptedException ex) {
        }
    }
    
    public void esperarMeterZapatoDer(){
        try {
            synchronized(derMeterCond){
                derMeterCond.wait();
            }  
        } catch (InterruptedException ex) {
        }
    }
    
    
    
    public void esperarSacarZapatoIzq(){
        try {
            synchronized(izqSacarCond){
                izqSacarCond.wait();
            }  
        } catch (InterruptedException ex) {
        }
    }
    
    public void esperarSacarZapatoDer(){
        try {
            synchronized(derSacarCond){
                derSacarCond.wait();
            }  
        } catch (InterruptedException ex) {
        }
    }

}
