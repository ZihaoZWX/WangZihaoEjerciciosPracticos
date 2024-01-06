
package ejercicio2jas2d2.services;

import ejercicio2jas2d2.models.Bird;
import ejercicio2jas2d2.models.Cat;
import ejercicio2jas2d2.models.Dog;
import ejercicio2jas2d2.models.Pet;
import ejercicio2jas2d2.models.Reptile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Zihao Wang
 */
public class PetRegistration {
    
    public PetRegistration(){
        
    }
    
    private final List<Pet<? extends Pet>>pets=new ArrayList<>();
    
    public void addPet(Pet<? extends Pet> pet){
        pets.add(pet);
    }
    
    public List<Pet<? extends Pet>> getPetRegistration(){
        return pets;
    }
    
    public <T extends String> void findPet(T info){
        pets.stream().filter(pet->pet.getName().equals(info)||pet.getSpicies().getSpicies().equals(info)).forEach(findedpet->System.out.println(findedpet.toString()));
    }
    
    public void countPets(){
        System.out.println("We have registered "+pets.size()+" pets");
    }
    
    public String randomName(){
        HashMap<Integer,String> names=new HashMap<>();
        Random randomNum=new Random();
        int count=0;
        int randomSize=randomNum.nextInt(20)+1;
        String name="";
        names.put(1, "a");
        names.put(2, "b");
        names.put(3, "c");
        names.put(4, "d");
        names.put(5, "e");
        names.put(6, "f");
        names.put(7, "g");
        names.put(8, "h");
        names.put(9, "i");
        names.put(10, "j");
        names.put(11, "k");
        names.put(12, "l");
        names.put(13, "m");
        names.put(14, "n");
        names.put(15, "o");
        names.put(16, "p");
        names.put(17, "q");
        names.put(18, "r");
        names.put(19, "s");
        names.put(20, "t");
        names.put(21, "u");
        names.put(22, "v");
        names.put(23, "w");
        names.put(24, "x");
        names.put(25, "y");
        names.put(26, "z");
        while(count<=randomSize){
            int randomLetter=randomNum.nextInt(26)+1;
            int upOrDown=randomNum.nextInt(2);
            if(upOrDown==0){
                name=name+names.get(randomLetter);
            }else{
                name=name+names.get(randomLetter).toUpperCase();
            }
            count+=1;
        }
        return name;
    }
    
    public int randomYears(Object pet){
        Random randomNum=new Random();
        int year=0;
        if(pet==Dog.class){
            year=randomNum.nextInt(10)+1;
        }
        else if(pet==Bird.class){
            year=randomNum.nextInt(20)+1;
        }
        else if(pet==Reptile.class){
            year=randomNum.nextInt(50)+1;
        }
        else if(pet==Cat.class){
            year=randomNum.nextInt(12)+1;
        }
        return year;
    }

}
