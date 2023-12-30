
package ejercicio1jas1d1.services;

import ejercicio1jas1d1.models.Usuarios;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public final class Reservar {
    
    public Reservar() throws ReservaInvalidaException{
        reservarVuelo();
    }
    
    public void reservarVuelo() {
        Scanner sc=new Scanner(System.in);
        Usuarios pasajero=new Usuarios();
        try{
        System.out.println("Introduce the name");
        pasajero.setName(sc.nextLine());
        if(pasajero.getName().isBlank()){
            throw new ReservaInvalidaException("Error, empty name");
        }
        }catch(ReservaInvalidaException e){
            e.printStackTrace();
            System.exit(0);
        }
        try{
        System.out.println("Introduce the destination");
        pasajero.setDestination(sc.nextLine());
        if(pasajero.getDestination().isBlank()){
            throw new ReservaInvalidaException("Error, empty destination");
        }
        }catch(ReservaInvalidaException e){
            e.printStackTrace();
            System.exit(0);
        }
        try{
        System.out.println("Introduce un dia");
        int day=sc.nextInt();
        System.out.println("Introduce un mes");
        int month=sc.nextInt();
        System.out.println("Introduce un año");
        int year=sc.nextInt();
        pasajero.setTravelDate(LocalDate.of(year, month, day));
        }catch(InputMismatchException e){
            System.out.println("Error, you cannot put String in date format");
            System.exit(0);
        }
        try{
        if(pasajero.getTravelDate().isBefore(LocalDate.now())){
            throw new ReservaInvalidaException("Error, the date cannot be before currently");
        }
        }catch(ReservaInvalidaException e){
            e.printStackTrace();
            System.exit(0);
        }
        try{
        System.out.println("Enter the number of seats you need");
        pasajero.setSeats(sc.nextInt());
        if(pasajero.getSeats()>5){
            throw new ReservaInvalidaException("Error, insufficient seats");
        }
        }catch(InputMismatchException e){
            System.out.println("Error, you cannot enter a String in Seats");
            System.exit(0);
        }catch(ReservaInvalidaException e){
            e.printStackTrace();
            System.exit(0);
        }
        
    }
    

}
