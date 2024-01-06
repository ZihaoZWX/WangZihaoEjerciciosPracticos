
package ejercicio1jas2d2.models;

/**
 *
 * @author Zihao Wang
 */
public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Autos{" + "marca=" + brand + ", modelo=" + model + ", year=" + year + ", precio=" + price + '}';
    }
    
}
