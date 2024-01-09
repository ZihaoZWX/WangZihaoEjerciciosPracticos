
package ejercicio1jas2d3.services;

import ejercicio1jas2d3.models.Directory;
import ejercicio1jas2d3.models.Node;
import java.util.List;

/**
 *
 * @author Zihao Wang
 */
public class DirectoryExplorer {
    
    public DirectoryExplorer(){
        
    }
    
    public Node crearNodos(){
        Directory subdirectory=new Directory(1,"Juegos",List.of("GTAV","Farcry4","LOL"));
        Directory subdirectory2=new Directory(2,"Juegos2",List.of("DiabloII","Age of EmpiresII","CSGO"));
        Directory subdirectory3=new Directory(3,"Juegos3",List.of("Terraria","GTA Vice City","Ajedrez"));
        Directory subdirectory4=new Directory(4,"IDES",List.of("Eclipse","Netbeans","IntelliJ"));
        Directory subdirectory5=new Directory(5,"Editores de textos",List.of("Bloc de notas","Visual Studio","VIM"));
        Directory subdirectory6=new Directory(6,"GOAT",List.of("Lionel Andres","Messi","Couccitini"));
        Directory subdirectory7=new Directory(7,"Ejercicios",List.of("Ejercicio1","Ejercicio2","Ejercicio3"));
        Directory subdirectory8=new Directory(8,"Ejercicios",List.of("Ejercicio4","Ejercicio5","Ejercicio6"));
        Directory subdirectory9=new Directory(9,"Ejercicios",List.of("Ejercicio7","Ejercicio8","Ejercicio9"));
        Directory directory=new Directory("Directorio1",List.of(subdirectory,subdirectory2,subdirectory3));
        Directory directory2=new Directory("Directorio2",List.of(subdirectory4,subdirectory5,subdirectory6));
        Directory directory3=new Directory("Directorio3",List.of(subdirectory7,subdirectory8,subdirectory9));
        Node node1=new Node(directory);
        Node node2=new Node(directory2);
        Node node3=new Node(directory3);
        
        node1.setNext(node2);
        node2.setNext(node3);
        return node1;
    }
    
    public void directoryExplorer(Node node){
        if(node==null){
            System.out.println("Directorio explorado");
        }else{
            System.out.println(node.getValue());
            directoryExplorer(node.getNext());
        }
    }

}
