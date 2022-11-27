package sumar_arrays;

public class Adder extends Thread {

    private int[] items;//atributos que se le pasn
    int lo, hi;
    public int result;

    public Adder(int[] theArray, int from, int to) {
        items = theArray;
        lo = from;
        hi = to;
    }

    public void run() {
        result = 0;
        for (int i = lo; i < hi; i++) {
            result += items[i];
        }

    }
}
