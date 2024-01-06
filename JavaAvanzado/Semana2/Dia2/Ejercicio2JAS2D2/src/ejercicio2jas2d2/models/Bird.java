
package ejercicio2jas2d2.models;

/**
 *
 * @author Zihao Wang
 */
public class Bird extends Pet{
    
    private final String spicies="bird";
    private final String breed;
    private final String color;
    
    public Bird(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    
    @Override
    public String getSpicies(){
        return spicies;
    }

    @Override
    public String toString() {
        return "Bird{ breed=" + breed + ", color=" + color + '}';
    }

}
