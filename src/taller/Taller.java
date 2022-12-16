package taller;

/**
 *
 * @author Edgar Moya
 */
public class Taller {

    private int capacidadDePatas;
    private int capacidadDeTableros;
    private int nPatas;
    private int nTableros;
    private Object patasCond = new Object();
    private Object tablasCond = new Object();
    private Object mesasCond = new Object();
    private Object mutexP = new Object();
    private Object mutexT = new Object();

    public Taller(int patas, int tableros) {
        capacidadDePatas = patas;
        capacidadDeTableros = tableros;
    }

    private void esperarPatas() {
        synchronized (patasCond) {
            try {
                patasCond.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    private void esperarTablas() {
        synchronized (tablasCond) {
            try {
                tablasCond.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    private void esperarMesas() {
        synchronized (mesasCond) {
            try {
                mesasCond.wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    public void agregarPata() {
        while (nPatas >= capacidadDePatas) esperarPatas();
        synchronized (mutexP) {
            nPatas++;
            System.out.println("Pata agregada!. Ahora hay: " + nPatas);
        }
        synchronized (mesasCond) {
            mesasCond.notify();
        }       
    }

    public void agregarTablero() {
        while (nTableros >= capacidadDeTableros) esperarTablas();
        synchronized (mutexT) {
            nTableros++;
            System.out.println("Tablero agregado!. Ahora hay: " + nTableros);
        }
        synchronized (mesasCond) {
            mesasCond.notify();
        }      
    }

    public void ensamblarMesa() {
        while (nPatas < 4 || nTableros < 1) esperarMesas();
        synchronized (mutexP) {
            synchronized (mutexT) {
                nPatas -= 4;
                nTableros -= 1;
                System.out.println("Mesa ensamblada!. Ahora hay " + nPatas + " patas y " + nTableros + " tableros");
            }
        }
        synchronized (patasCond) {
            patasCond.notify();
        }
        synchronized (tablasCond) {
            tablasCond.notify();
        }       
    }
}
