package ejercicio1jbs2d2.models;

import ejercicio1jbs2d2.models.Combustion;
import ejercicio1jbs2d2.models.Vehiculo;

public class Camioneta extends Vehiculo implements Combustion{
    
    private int capacidadTanque;
    private int consumoCombustible;

    public Camioneta() {
    }

    public Camioneta(int capacidadTanque, int consumoCombustible, int id, String placa, String marca, String modelo, int productionYear, int year, double coste) {
        super(id, placa, marca, modelo, productionYear, year, coste);
        this.capacidadTanque = capacidadTanque;
        this.consumoCombustible = consumoCombustible;
    }

    public int getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public int getConsumoCombustible() {
        return consumoCombustible;
    }

    public void setConsumoCombustible(int consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }
    
    @Override
    public void calculoAntiguedad() {
        System.out.println("Esta camioneta tiene "+(super.getYear()-super.getProductionYear())+" years");
    }
    
    @Override
    public void recargarCombustible() {
        System.out.println("Esta cargando combustible");
    }
    
}
