package ejercicio2.modals;

public class Sombrero extends Vestimenta{
    
    private String tipo;
    private int size;

    public Sombrero() {
    }

    public Sombrero(String tipo, int size, int codigo, String nombre, double precio, String marca, int talla, String color) {
        super(codigo, nombre, precio, marca, talla, color);
        this.tipo = tipo;
        this.size = size;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public void mostrarMarca(){
        System.out.println("Estos sombreros son de la marca "+super.getMarca());
    }
    
}
