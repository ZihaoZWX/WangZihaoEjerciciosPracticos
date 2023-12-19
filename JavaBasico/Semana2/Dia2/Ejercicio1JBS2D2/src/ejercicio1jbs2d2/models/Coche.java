package ejercicio1jbs2d2.models;

import ejercicio1jbs2d2.models.Electrico;
import ejercicio1jbs2d2.models.Vehiculo;

public class Coche extends Vehiculo implements Electrico{
    
    private int capacidadBateria;
    private int autonoMia;

    public Coche() {
    }

    public Coche(int capacidadBateria, int autonoMia, int id, String placa, String marca, String modelo, int productionYear, int year, double coste) {
        super(id, placa, marca, modelo, productionYear, year, coste);
        this.capacidadBateria = capacidadBateria;
        this.autonoMia = autonoMia;
    }

    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(int capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public int getAutonoMia() {
        return autonoMia;
    }

    public void setAutonoMia(int autonoMia) {
        this.autonoMia = autonoMia;
    }
    
    @Override
    public void calculoAntiguedad(){
        System.out.println("Este coche tiene "+(super.getYear()-super.getProductionYear())+" years");
    }
    
    @Override
    public void cargarEnergia(){
        System.out.println("Esta cargando energia electrica");
    }
}
