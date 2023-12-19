package ejercicio1;

import ejercicio1.modals.Reptil;
import ejercicio1.modals.Animal;
import ejercicio1.modals.Mamifero;
import ejercicio1.modals.Ave;

public class Main {

    public static void main(String[] args) {
        
        Animal[] animales=new Animal[3];
        
        Animal mamifero=new Mamifero();//Si es posible y se le llama poliformismo si te refiere al reves no.Usamos poliformismo y un array de Animales para facilitar la impresion de datos
        Animal ave=new Ave();
        Animal reptil=new Reptil();
        
        animales[0]=mamifero;
        animales[1]=ave;
        animales[2]=reptil;
        
        for(Animal datos:animales){
            //Si cambiamos los metodos public a private basicamente peta, ya que el modificador de acceso private impide que esos metodos se puedan usar fuera de esa clase
            datos.saludar();
        }
        
    }

}
