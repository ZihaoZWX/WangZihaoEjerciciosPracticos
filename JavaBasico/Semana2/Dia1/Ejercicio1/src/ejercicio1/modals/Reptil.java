package ejercicio1.modals;

import ejercicio1.modals.Animal;

public class Reptil extends Animal{
    
    private double longitud;
    private String tipoDeEscamas;
    private String tipoVeneno;
    private String habitat;

    public Reptil() {
    }

    public Reptil(double longitud, String tipoDeEscamas, String tipoVeneno, String habitat, int id, String nombre, int edad, String tipoPiel, String tipoAlimentacion) {
        super(id, nombre, edad, tipoPiel, tipoAlimentacion);
        this.longitud = longitud;
        this.tipoDeEscamas = tipoDeEscamas;
        this.tipoVeneno = tipoVeneno;
        this.habitat = habitat;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getTipoDeEscamas() {
        return tipoDeEscamas;
    }

    public void setTipoDeEscamas(String tipoDeEscamas) {
        this.tipoDeEscamas = tipoDeEscamas;
    }

    public String getTipoVeneno() {
        return tipoVeneno;
    }

    public void setTipoVeneno(String tipoVeneno) {
        this.tipoVeneno = tipoVeneno;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un reptil");
    }
    
}
