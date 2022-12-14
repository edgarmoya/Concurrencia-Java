package sumar_arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        int[] largeArray = new int[5000];
        rellenarArray(largeArray);
        
        AdderModificado a = arraySum(largeArray, 0, largeArray.length / 2);
        AdderModificado b = arraySum(largeArray, (largeArray.length / 2), largeArray.length);

        a.join(); //Espera a que termine el a
        b.join(); //Espera a que termine el b
        
        System.out.println("La suma es: " + (a.result + b.result));

           
    }

    /*private static int arraySum(int[] largeArray, int inicio, int fin) {
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
    
    // Inicializa un hilo de "AdderModificado" y lo retorna
    private static AdderModificado arraySum(int[] largeArray, int inicio, int fin) {
        AdderModificado addThread = new AdderModificado(largeArray, inicio, fin);
        addThread.start();
        return addThread;
    }
    
    // Rellena el arreglo de elementos 1
    private static void rellenarArray(int[] largeArray){
        for (int i = 0; i < 5000; i++) {
            largeArray[i] = 1;
        }
    }
}
