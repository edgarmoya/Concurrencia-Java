package otros;


public class ProducerConsummer {

    public static void main(String[] args) {

        Queue q = new Queue();
        Producer p = new Producer(q);
        Consummer c = new Consummer(q);

        /* 
        p.doIt();//invoca a un metodo con ciclo infinito por tanto la sig sentencia no se ejecuta
        c.doIt();
         */
        try {
            p.start();
            c.start();
            p.join();  //para que el hilo principal espere a que p termine de ejecutar el run
            c.join();
        } catch (InterruptedException e) {

        }
        /*para hacer un proceso ligero en java hay que crar una clase con un metodo*/
 /*CREACON DE HILOS
    1- Heredar de la clase Thread
    2- El metodo que ejecuta el paralelo se llama RUN y tiene el sig protiotipo
     public void run()
    3- para iniciar el funcionamiento concurrernte no se puede llamar directamente a run:
    crear una innstancia de la clase y llamar al metodo heredado start(inmediatamente se bifurca el proceso en dos procesos ligeros
    se ejecuta el metodo run y la sentencia siguiente)
         */
    }
}
