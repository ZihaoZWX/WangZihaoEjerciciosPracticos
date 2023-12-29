package ejercicio3jas1d1.services;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class DataManagement {
    
    public DataManagement() {
        dataManagement();
    }

    public void dataManagement() {
        try{
        String[] data = {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position you want to see");
        System.out.println(data[sc.nextInt()]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error, that position does not exist\n"+e.getMessage());
        }catch(InputMismatchException e){
            System.out.println("Error, you cannot put a String in position\n"+e.getMessage());
        }
    }

}
