package ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args){
    
        ArrayList<Double> temperatura=new ArrayList<>();
        
        System.out.println("Introduce las temperaturas máximas");
        
        Scanner sc=new Scanner(System.in);
        
        while(temperatura.size()<7) {
            temperatura.add(sc.nextDouble());
        }
        sc.close();
        for(double temp : temperatura) {
            System.out.print(temp+" ");
        }
        
        
    }
    
}
