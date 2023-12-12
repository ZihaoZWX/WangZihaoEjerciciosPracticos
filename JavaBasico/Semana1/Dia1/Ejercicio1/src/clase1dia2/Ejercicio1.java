package clase1dia2;

import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        String saludo="Hola, bienvenido al sistema";
        System.out.println(saludo);
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca el nombre");
        String nombre = scan.nextLine();
        System.out.printf("Hola %s, bienvenida al sistema\n",nombre);
        scan.close();
        
    }
    
}
