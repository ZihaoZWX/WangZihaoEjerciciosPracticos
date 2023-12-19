package ejercicio1jbs2d2;

import ejercicio1jbs2d2.models.Camioneta;
import ejercicio1jbs2d2.models.Coche;
import ejercicio1jbs2d2.models.Combustion;
import ejercicio1jbs2d2.models.Electrico;
import ejercicio1jbs2d2.models.Moto;
import ejercicio1jbs2d2.models.Vehiculo;

public class Main {

    public static void main(String[] args) {
        Vehiculo coche = new Coche(100, 500, 1, "ahd2311", "Volvo", "XC60", 2020, 2023, 50000);
        Vehiculo moto = new Moto(100, "CVC", 2, "wds3425", "BMW", "C1", 2017, 2023, 30000);
        Vehiculo camioneta = new Camioneta(100, 10, 3, "pof3245", "Mercedes", "Benz", 2010, 2023, 17000);
        
        Vehiculo[] vehiculos={coche,moto,camioneta};
        
        for(Vehiculo data:vehiculos){
            data.calculoAntiguedad();
            if(data instanceof Electrico){
                ((Electrico) data).cargarEnergia();
            }else if(data instanceof Combustion){
                ((Combustion) data).recargarCombustible();
            }
        }
        
    }

}
