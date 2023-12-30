
package ejercicio2jas1d2;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        Fabrica fabrica=new Fabrica();
        Fabrica fabrica2=new Fabrica();
        Fabrica fabrica3=new Fabrica();
        Trabajador trabajador1=new Trabajador("Juan",fabrica);
        Trabajador trabajador2=new Trabajador("Jose",fabrica2);
        Trabajador trabajador3=new Trabajador("Fernanda",fabrica3);
        Thread juan=new Thread(trabajador1);
        Thread jose=new Thread(trabajador2);
        Thread fernanda=new Thread(trabajador3);
        juan.start();
        jose.start();
        fernanda.start();
    }
    
}
