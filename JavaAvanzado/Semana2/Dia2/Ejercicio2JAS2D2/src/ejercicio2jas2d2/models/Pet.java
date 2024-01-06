
package ejercicio2jas2d2.models;

/**
 *
 * @author Zihao Wang
 * @param <T>
 */
public class Pet<T> {
    
    private int id;
    private String name;
    private int years;
    private T spicies;

    public Pet() {
    }

    public Pet(int id, String nombre, int edad, T spicies) {
        this.id = id;
        this.name = nombre;
        this.years = edad;
        this.spicies = spicies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public T getSpicies() {
        return spicies;
    }

    public void setSpicies(T spicies) {
        this.spicies = spicies;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name=" + name + ", years=" + years + ", spicies=" + spicies + '}';
    }
    
}
