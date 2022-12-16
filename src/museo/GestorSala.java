package museo;

/**
 *
 * @author Edgar Moya
 */
public class GestorSala {

    private int cantMax = 50;
    private int cantPersonas;
    private int temp;
    private Object mutex = new Object();
    private Object entrarCond = new Object();

    public GestorSala(int temp) {
        this.temp = temp;
        this.cantPersonas = 0;
    }

    // se invoca cuando una persona 
    // quiere entrar en la sala.
    public void entrarSala() {
        while (cantPersonas >= cantMax) {
            esperarEntrar();
        }
        synchronized (mutex) {
            cantPersonas++;
            System.out.println("Entra persona, ahora son " +cantPersonas);
        }
    }

    // se invoca cuando una persona jubilada
    // quiere entrar en la sala.
    public void entrarSalaJubilado() {
        synchronized (mutex) {
            while (cantPersonas >= cantMax) {
                esperarEntrar();
            }
            cantPersonas++;
            System.out.println("Entra jubilado, ahora son" +cantPersonas);
        }

    }

    // se invoca cuando una persona, jubilada o no, 
    // quiere salir de la sala.
    public void salirSala() {
        if (cantPersonas > 0) {
            synchronized (mutex) {
                cantPersonas--;
                System.out.println("Salir persona, quedan "+cantPersonas);
            }
        }
    }

    // lo invoca la hebra que mide la temperatura 
    // de la sala para indicar el último valor medido.
    public void notificarTemperatura(int temperatura) {
        System.out.println("Nueva temperatura: " + temperatura);
        temp = temperatura;
        if (temp > 30) {
            cantMax = 35;
        } else {
            cantMax = 50;
        }
    }

    private void esperarEntrar() {
        synchronized (entrarCond) {
            try {
                entrarCond.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

}
