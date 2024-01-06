
package ejercicio2jas2d2.models;

/**
 *
 * @author Zihao Wang
 */
public class Dog extends Pet{
    
    private final String spicies="dog";
    private final String breed;
    private final String color;
    
    public Dog(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    
    @Override
    public String getSpicies(){
        return spicies;
    }

    @Override
    public String toString() {
        return "Dog{ breed=" + breed + ", color=" + color + '}';
    }
    
}
