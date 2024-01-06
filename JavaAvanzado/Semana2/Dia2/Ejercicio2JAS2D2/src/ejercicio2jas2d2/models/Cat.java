
package ejercicio2jas2d2.models;

/**
 *
 * @author Zihao Wang
 */
public class Cat extends Pet{
    
    private final String spicies="cat";
    private final String breed;
    private final String color;
    
    public Cat(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }
    
    @Override
    public String getSpicies(){
        return spicies;
    }

    @Override
    public String toString() {
        return "Cat{ breed=" + breed + ", color=" + color + '}';
    }

}
