package sumar_arrays;

public class ArraySum {

    public static void main(String[] args) throws InterruptedException {
        int[] largeArray = new int[10000];
        //int sum1 = arraySum(largeArray, 0, largeArray.length / 2);
        //int sum2 = arraySum(largeArray, (largeArray.length / 2) + 1, largeArray.length);
        Integer sum1 = new Integer(0);
        Integer sum2 = new Integer(0);
        AdderModificado a = arraySum(largeArray, 0, largeArray.length / 2, sum1); //El primer hilo escribe en sum1
        AdderModificado b = arraySum(largeArray, (largeArray.length / 2) + 1, largeArray.length, sum2);//El segundo hilo escribe en sum2
        a.join();//Espera a que termine el a
        b.join();//Espera a que termine el b
        System.out.println("La suma es:" + (sum1 + sum2));
        //En este programa no hay problema porque a pesar de que ambos estan leyendo al mismo tiempo del arreglo items escriben
        //sobre variables diferentes, aparentemente la misma que es el result que se recibe, pero realmente son sum1 y sum2, por ello
        //no hay problema
    }

    /* private static int arraySum(int[] largeArray, int inicio, int fin) {
        Adder addThread = new Adder(largeArray, inicio, fin);
        addThread.start();// paso 1
        //posible join 
        //addThread.join()
        return addThread.result;// paso 2
        //Ambos se estan ejecutanto al mismo tiempo, tanto 1 y 2 pero eso da un problema ya que actuan sobre
        //la misma variable. Se puede usar un join donde esta marcado para detener el hilo principal y esto hace 
        //que el hilo principal espere a que se ejecute, pero sería como una secuencial, tampoco se puede usar
        //un while antes del return que controle si terminó el hilo porque sería espera ocupada
        
    }*/
    private static AdderModificado arraySum(int[] largeArray, int inicio, int fin, Integer result) {
        AdderModificado addThread = new AdderModificado(largeArray, inicio, fin, result);
        addThread.start();
        return addThread;
    }
}
