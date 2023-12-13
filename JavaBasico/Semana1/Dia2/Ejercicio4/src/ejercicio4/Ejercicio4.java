package ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        Ejercicio4 ej4=new Ejercicio4();
        Scanner  sc=new Scanner(System.in);
        String[][] asientos=new String[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                asientos[i][j]=ej4.ocupacionRandom();
            }
        }
        boolean salir=false;
        String compra="si";
        try {
        while(!compra.equals("no")) {
            if(!compra.equals("si")&&!compra.equals("no")){
                System.out.println("Error , debes de introducir un si o no");
            }
            System.out.println("Deseas comprar un billete ?");
            compra=sc.next();
            if(compra.equals("si")){
                System.out.println("Introduce el numero de fila");
                int fila=sc.nextInt()-1;
                System.out.println("Introduce el numero de asiento");
                int asiento=sc.nextInt()-1;
        
                if(asientos[fila][asiento].equals("O")){
                    System.out.println("Asiento libre");
                    asientos[fila][asiento]="X";
                    System.out.println("Acabas de ocupar el asiento en la fila "+fila+" y el asiento numero "+asiento);
                }else{
                    System.out.println("Asiento ocupado, por favor elija otro asiento");
                    while(!asientos[fila][asiento].equals("O")){
                        System.out.println("Introduce el numero de fila");
                        fila=sc.nextInt()-1;
                        System.out.println("Introduce el numero de asiento");
                        asiento=sc.nextInt()-1;
                        if(asientos[fila][asiento].equals("X"))
                        System.out.println("Asiento ocupado, por favor elija otro asiento");
                    }
                }
            }else if(compra.equals("no")){
                salir=true;
            }
            for(String[] data : asientos){
                System.out.println();
                for(String data2 : data) {
                    System.out.print(data2);
                }
            }
            System.out.println("\n");
            if(salir)
                System.out.println("Saliendo de la app");
        }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error asiento inexistente");
        }
        
    }
    
    public String ocupacionRandom() {
        
        Random r= new Random();
        int temp=r.nextInt(2);
        if(temp==0){
            return "O";
        }else{
            return "X";
        }
        
    }
}
