
package ejercicio2jas2d2.models;

/**
 *
 * @author Zihao Wang
 */
public class Reptile extends Pet{
    
    private final String spicies="reptile";
    private final String breed;
    private final String color;
    
    public Reptile(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    
    @Override
    public String getSpicies(){
        return spicies;
    }

    @Override
    public String toString() {
        return "Reptile{ breed=" + breed + ", color=" + color + '}';
    }

}
