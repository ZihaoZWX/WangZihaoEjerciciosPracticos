
package ejercicio1jas1d2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        Agente agente1=new Agente("Agente1");
        Agente agente2=new Agente("Agente2");
        Agente agente3=new Agente("Agente3");
        Agente agente4=new Agente("Agente4");
        agente1.start();
        agente2.start();
        agente3.start();
        agente4.start();
    }
    
}
