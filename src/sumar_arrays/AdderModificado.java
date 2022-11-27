package sumar_arrays;

public class AdderModificado extends Thread {

    private int[] items; //atributos que se le pasn
    int lo, hi;
    public int result;

    public AdderModificado(int[] theArray, int from, int to, Integer result) {
        items = theArray;
        lo = from;
        hi = to;
        this.result = result;
    }

    public void run() {
        result = 0;
        for (int i = lo; i < hi; i++) {
            result += items[i];
        }
    }
}
