package ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        double precio=1;
        double total=0;
        Scanner sc=new Scanner(System.in);
        try{
        while(precio!=0){
            System.out.println("Introduce precios de los productos\nIntroduce 0  para finalizar");
            precio=sc.nextDouble();
            total=total+precio;
            System.out.println("La cuenta total es de "+total+" €\n");
        }
	sc.close();
        }catch(InputMismatchException e){
            System.out.println("Error debes introducir un numero entero");
        }
    }
    
}
