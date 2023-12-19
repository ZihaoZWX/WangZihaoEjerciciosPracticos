package ejercicio1.modals;

public class Mamifero extends Animal{
    
    private int numeroPatas;
    private String tipoReproducion;
    private String colorPelaje;
    private String habitat;

    public Mamifero() {
    }

    public Mamifero(int numeroPatas, String tipoReproducion, String colorPelaje, String habitat, int id, String nombre, int edad, String tipoPiel, String tipoAlimentacion) {
        super(id, nombre, edad, tipoPiel, tipoAlimentacion);
        this.numeroPatas = numeroPatas;
        this.tipoReproducion = tipoReproducion;
        this.colorPelaje = colorPelaje;
        this.habitat = habitat;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    public String getTipoReproducion() {
        return tipoReproducion;
    }

    public void setTipoReproducion(String tipoReproducion) {
        this.tipoReproducion = tipoReproducion;
    }

    public String getColorPelaje() {
        return colorPelaje;
    }

    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un mamifero");
    }
    
}