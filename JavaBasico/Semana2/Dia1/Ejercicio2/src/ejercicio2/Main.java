package ejercicio2;

import ejercicio2.modals.Zapato;
import ejercicio2.modals.Vestimenta;
import ejercicio2.modals.Sombrero;
import ejercicio2.modals.Pantalon;
import ejercicio2.modals.Camiseta;

public class Main {

    public static void main(String[] args) {
        
        Vestimenta zapato=new Zapato("Piel","Plano",1,"LM10 Wedding Edition",3000,"Adidas",39,"Blanco");
        Vestimenta zapato2=new Zapato("Tela","Plano",1,"LM10 GOAT White Edition",2000,"Adidas",39,"Blanco");
        Vestimenta zapato3=new Zapato("Tela","Plano",1,"LM10 GOAT Black Edition",2000,"Adidas",39,"Negro");
        Vestimenta pantalon=new Pantalon("Vaquero","Liso",1,"LM10",100,"Adidas",39,"Blanco");
        Vestimenta pantalon2=new Pantalon("Deportivo","Liso",1,"CR7",20,"Nike",39,"Blanco");
        Vestimenta pantalon3=new Pantalon("Informal","Plano",1,"Crazy",20,"Adidas",39,"Blanco");
        Vestimenta camiseta=new Camiseta("Futbol",false,1,"LM10 World Cup 2022 GOAT Edition",3000,"Adidas",39,"Celeste y blanco");
        Vestimenta camiseta2=new Camiseta("Informal",false,1,"Koeman",5,"Nike",39,"Blanco");
        Vestimenta sombrero=new Sombrero("Paja",20,1,"FakeGolden straw hat",30,"Adidas",20,"Marron");
        Vestimenta[] vestimenta={zapato,zapato2,zapato3,pantalon,pantalon2,pantalon3,camiseta,camiseta2,sombrero};
        
        for(Vestimenta data:vestimenta){
            data.mostrarMarca();
        }
        
    }
    
}
