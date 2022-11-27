package imprimir_cadena;

public class Cadena extends Thread{
    
    private String cadena;
    private int cantidad;
    
    public Cadena(String cadena, int cantidad){
        this.cadena = cadena;
        this.cantidad = cantidad;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < cantidad; i++) {
            System.out.println(cadena);
        }
    }
    
}
