
package ejercicio1jas2d2;

import ejercicio1jas2d2.models.Vehicle;
import ejercicio1jas2d2.services.VehicleStock;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        VehicleStock vehicleStock=new VehicleStock<>();
        vehicleStock.addCar(new Vehicle("BMW","S1",2012,10000));
        vehicleStock.addCar(new Vehicle("Mercedes","Benz",2023,56000));
        vehicleStock.addCar(new Vehicle("Volkswagen","T-roc",2020,36000));
        vehicleStock.addCar(new Vehicle("Audi","A3",2017,24000));
        vehicleStock.addCar(new Vehicle("BMW","S2",2014,14000));
        vehicleStock.findCar(2023, vehicleStock.getCar());
        vehicleStock.findCar("BMW", vehicleStock.getCar());
        vehicleStock.findCar((double)10000,vehicleStock.getCar());
        vehicleStock.stockValue(vehicleStock.getCar());
    }
    
}
