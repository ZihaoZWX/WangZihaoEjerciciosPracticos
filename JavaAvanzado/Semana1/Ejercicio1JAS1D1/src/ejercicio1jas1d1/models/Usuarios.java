
package ejercicio1jas1d1.models;

import java.time.LocalDate;

/**
 *
 * @author Zihao Wang
 */
public class Usuarios {
    
    String name;
    String destination;
    LocalDate travelDate;
    int seats;

    public Usuarios() {
    }

    public Usuarios(String name, String destination, LocalDate travelDate, int seats) {
        this.name = name;
        this.destination = destination;
        this.travelDate = travelDate;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

}
