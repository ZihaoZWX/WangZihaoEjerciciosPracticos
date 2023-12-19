package ejercicio2.modals;

public class Pantalon extends Vestimenta{
    
    private String estilo;
    private String tipoCierre;

    public Pantalon() {
    }

    public Pantalon(String estilo, String tipoCierre, int codigo, String nombre, double precio, String marca, int talla, String color) {
        super(codigo, nombre, precio, marca, talla, color);
        this.estilo = estilo;
        this.tipoCierre = tipoCierre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }
    
    @Override
    public void mostrarMarca(){
        System.out.println("Estos pantalones son de la marca "+super.getMarca());
    }
    
}
