package ejercicio1jbs2d2.models;

import ejercicio1jbs2d2.models.Vehiculo;

public class Moto extends Vehiculo implements Combustion{
    
    private double cilindrada;
    private String tipoMotor;

    public Moto() {
    }

    public Moto(double cilindrada, String tipoMotor, int id, String placa, String marca, String modelo, int productionYear, int year, double coste) {
        super(id, placa, marca, modelo, productionYear, year, coste);
        this.cilindrada = cilindrada;
        this.tipoMotor = tipoMotor;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    
    @Override
    public void calculoAntiguedad() {
        System.out.println("Esta moto tiene "+(super.getYear()-super.getProductionYear())+" years");
    }
    
    @Override
    public void recargarCombustible() {
        System.out.println("Esta cargando combustible");
    }
    
}
