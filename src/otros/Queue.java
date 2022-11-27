package otros;


public class Queue {

    private static final int size = 10;
    private int[] items = new int[size];
    private int out = 0;
    private int in = 0;
    private int count = 0;

    public void enQueue(int e) {
        //En este while se genera un problema de espera ocupada
        while (count == items.length) {
        }//Se sigue chequeando la posicion hasta que se vacie un elemento
        items[in] = e;
        in = (in + 1) % size;//Esto es para poner correctamente el elemento usando el in
        //entrar en la seccion Critica
        count++; //esta variable es compartida entre dos procesos ligeros a la vez
        //Salir de la region critica
    }

    public int deQueue() {
        int result;
        //En este while se genera un problema de espera ocupada
        while (count == 0) {
        }//Solo se puede sacar de la pila cuando la cantidad de elementeos es > 0
        result = items[out];
        out = (out + 1) % size;//Esto es para poner correctamente el elemento usando el out
        //entrar en la seccion Critica
        count--;//esta variable es compartida entre dos procesos ligeros a la vez
        //Salir de la region critica
        //para garantizar que solo un proceso(ligero o no liegero) entre a la vez
        return result;
    }

}
