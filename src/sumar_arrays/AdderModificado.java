package sumar_arrays;

public class AdderModificado extends Thread {

    private int[] items; //atributos que se le pasan
    private int from, to;
    public int result;

    public AdderModificado(int[] theArray, int from, int to) {
        this.items = theArray;
        this.from = from;
        this.to = to;
        this.result = 0;
    }

    public void run() {
        result = 0;
        for (int i = from; i < to; i++) {
            result += items[i];
        }
    }
}
