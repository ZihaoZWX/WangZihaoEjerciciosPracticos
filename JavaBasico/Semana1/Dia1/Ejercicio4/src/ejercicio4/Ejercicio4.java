package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        try{
        
        Scanner  input=new Scanner(System.in);
        System.out.println("Introduce el numero1");
        int numero1= input.nextInt();
        System.out.println("Introduce el numero2");
        int numero2= input.nextInt();
        int suma=numero1+numero2;
        int resta=numero1-numero2;
        int multiplicacion=numero1*numero2;
        double division=numero1/numero2;
        
        System.out.println("La suma da "+suma+"\nLa resta da "+resta+
                "\nLa multiplicacion da "+multiplicacion+"\nLa division da "+division);
        
        input.close();
        
        }catch(ArithmeticException e){  //Creamos el ArithmeticException para el error de dividir entre 0
            System.out.println("No puedes dividir entre cero"+e.getMessage());
        }
        
    }
    
}
