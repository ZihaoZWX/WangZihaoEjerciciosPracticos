package ejercicio2.modals;

public class Camiseta extends Vestimenta{
    
    private String manga;
    private boolean cuello;

    public Camiseta() {
    }

    public Camiseta(String manga, boolean cuello, int codigo, String nombre, double precio, String marca, int talla, String color) {
        super(codigo, nombre, precio, marca, talla, color);
        this.manga = manga;
        this.cuello = cuello;
    }

    public String getManga() {
        return manga;
    }

    public void setManga(String manga) {
        this.manga = manga;
    }

    public boolean getCuello() {
        return cuello;
    }

    public void setCuello(boolean cuello) {
        this.cuello = cuello;
    }
    
    @Override
    public void mostrarMarca(){
        System.out.println("Esta camiseta es de la marca "+super.getMarca());
    }
    
}
