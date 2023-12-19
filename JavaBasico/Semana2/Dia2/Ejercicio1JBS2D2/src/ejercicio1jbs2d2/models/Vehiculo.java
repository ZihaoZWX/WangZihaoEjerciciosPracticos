package ejercicio1jbs2d2.models;

public abstract class Vehiculo {
    
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int productionYear;
    private int year;//Las palabras con n las pongo en ingles para evitar errores
    private double coste;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String marca, String modelo, int productionYear, int year, double coste) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.productionYear = productionYear;
        this.year = year;
        this.coste = coste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    
    public abstract void calculoAntiguedad();
}
