
package ejercicio2jas2d2;

import ejercicio2jas2d2.models.Bird;
import ejercicio2jas2d2.models.Cat;
import ejercicio2jas2d2.models.Dog;
import ejercicio2jas2d2.models.Pet;
import ejercicio2jas2d2.models.Reptile;
import ejercicio2jas2d2.services.PetRegistration;
import java.util.Scanner;

/**
 *
 * @author Zihao Wang
 */
public class Main {

    public static void main(String[] args) {
        PetRegistration petRegistration=new PetRegistration();
        petRegistration.addPet(new Pet(1,petRegistration.randomName(),petRegistration.randomYears(Dog.class),new Dog("Husky","White")));
        petRegistration.addPet(new Pet(2,petRegistration.randomName(),petRegistration.randomYears(Dog.class),new Dog("Husky","Black")));
        petRegistration.addPet(new Pet(3,petRegistration.randomName(),petRegistration.randomYears(Cat.class),new Cat("Asiatic","Balck")));
        petRegistration.addPet(new Pet(4,petRegistration.randomName(),petRegistration.randomYears(Cat.class),new Cat("Asiatic","White")));
        petRegistration.addPet(new Pet(5,petRegistration.randomName(),petRegistration.randomYears(Bird.class),new Bird("Parakeets","Green and Yellow")));
        petRegistration.addPet(new Pet(6,petRegistration.randomName(),petRegistration.randomYears(Bird.class),new Bird("Parakeets","Green and Red")));
        petRegistration.addPet(new Pet(7,petRegistration.randomName(),petRegistration.randomYears(Reptile.class),new Reptile("Crocodile","Dark Green")));
        petRegistration.addPet(new Pet(8,petRegistration.randomName(),petRegistration.randomYears(Reptile.class),new Reptile("Crocodile","Brown")));
        String eleccion="";
        while(!eleccion.equals("0")){
        System.out.println("Enter dog,cat,bird,reptile or your Pets name\nEnter 0 if you want exits");
        Scanner sc=new Scanner(System.in);
        eleccion=sc.nextLine().toLowerCase();
        petRegistration.findPet(eleccion);
        }
        petRegistration.countPets();
    }
    
}
