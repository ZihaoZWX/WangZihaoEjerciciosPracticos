package ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        Persona[] personas=new Persona[5];
        
        Persona persona1=new Persona(1,"Adrian",22,"Direcion1",1);
        Persona persona2=new Persona(1,"Alfredo",23,"Direcion2",2);
        Persona persona3=new Persona(1,"Raul",21,"Direcion3",3);
        Persona persona4=new Persona(1,"Jose",24,"Direcion4",4);
        Persona persona5=new Persona(1,"Juan",35,"Direcion5",5);
        
        personas[0]=persona1;
        personas[1]=persona2;
        personas[2]=persona3;
        personas[3]=persona4;
        personas[4]=persona5;
        
        for(Persona guy : personas){
            System.out.println("Nombre : "+guy.getNombre()+" Edad : "+guy.getEdad());
        }
        
        System.out.println("\nAntes \nNombre : "+personas[0].getNombre()+"\nNombre : "+personas[1].getNombre());
        
        personas[0].setNombre("NuevoNombre1");
        personas[1].setNombre("NuevoNombre2");
        
        System.out.println("Despues \nNombre : "+personas[0].getNombre()+"\nNombre : "+personas[1].getNombre());
        
        for(Persona guy : personas){
            if(guy.getEdad()>30)
                System.out.println("\nLos mayores de 30 son :\n"+guy.toString());
        }
        
    }
    
}
