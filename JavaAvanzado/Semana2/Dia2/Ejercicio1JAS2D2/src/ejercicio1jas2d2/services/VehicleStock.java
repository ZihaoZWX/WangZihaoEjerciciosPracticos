package ejercicio1jas2d2.services;

import ejercicio1jas2d2.models.Vehicle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Zihao Wang
 */
public class VehicleStock<D, T extends Vehicle> {

    private final List<T> inventario = new ArrayList<>();

    public VehicleStock() {
    }

    public void addCar(T vehicle) {
        inventario.add(vehicle);
    }
    
    public List getCar(){
        return inventario;
    }

    public void findCar(D data,List<T> vehicle) {
        if(data instanceof String){
        vehicle.stream().filter(car->car.getBrand().equals(data)).collect(Collectors.toList()).forEach(carList->System.out.println(carList));
        }
        if(data instanceof Integer){
           vehicle.stream().filter(car->car.getYear()==(int)data).collect(Collectors.toList()).forEach(carList->System.out.println(carList)); 
        }
        if(data instanceof Double){
           vehicle.stream().filter(car->car.getPrice()==(double)data).collect(Collectors.toList()).forEach(carList->System.out.println(carList)); 
        }
    }
    
    public void stockValue(List<T> vehicles){
        double stockValue=vehicles.stream().mapToDouble(T::getPrice).sum();
        DecimalFormat format=new DecimalFormat("#,###.00");
        String formatedValue=format.format(stockValue);
        System.out.println("Our stock value is "+formatedValue+" €");
    }

}