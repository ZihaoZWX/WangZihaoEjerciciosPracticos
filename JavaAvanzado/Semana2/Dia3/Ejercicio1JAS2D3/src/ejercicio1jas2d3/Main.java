
package ejercicio1jas2d3;

import ejercicio1jas2d3.services.DirectoryExplorer;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DirectoryExplorer explorer=new DirectoryExplorer();
        explorer.directoryExplorer(explorer.crearNodos());
        
    }
    
}
