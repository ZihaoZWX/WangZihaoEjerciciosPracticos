package ejercicio1.modals;

public class Ave extends Animal{
    
    private double embergadurasAlas;
    private String tipoVuelo;
    private String colorPlumaje;
    private String tipoPico;

    public Ave() {
    }

    public Ave(double embergadurasAlas, String tipoVuelo, String colorPlumaje, String tipoPico, int id, String nombre, int edad, String tipoPiel, String tipoAlimentacion) {
        super(id, nombre, edad, tipoPiel, tipoAlimentacion);
        this.embergadurasAlas = embergadurasAlas;
        this.tipoVuelo = tipoVuelo;
        this.colorPlumaje = colorPlumaje;
        this.tipoPico = tipoPico;
    }

    public double getEmbergadurasAlas() {
        return embergadurasAlas;
    }

    public void setEmbergadurasAlas(double embergadurasAlas) {
        this.embergadurasAlas = embergadurasAlas;
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public String getColorPlumaje() {
        return colorPlumaje;
    }

    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    public String getTipoPico() {
        return tipoPico;
    }

    public void setTipoPico(String tipoPico) {
        this.tipoPico = tipoPico;
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un ave");
    }
    
}
