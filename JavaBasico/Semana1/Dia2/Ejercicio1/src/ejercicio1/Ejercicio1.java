package clase1dia2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        Ejercicio1 ej1=new Ejercicio1();
        ej1.calculoMayorDeEdad();
        
    }
    
    public void calculoMayorDeEdad(){
        
        try{
            
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Introduce la edad, tiene que ser un numero entero");
        int edad=sc.nextInt();
        if(edad>=18){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("Eres menor de edad");
        }
        
        }catch(InputMismatchException e){
        System.out.println("Error , debes introducir un numero entero"+e.getMessage());
        calculoMayorDeEdad();
    }
    }
    
}
