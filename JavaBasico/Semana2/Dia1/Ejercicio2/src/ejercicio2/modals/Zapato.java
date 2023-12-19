package ejercicio2.modals;

import ejercicio2.modals.Vestimenta;

public class Zapato extends Vestimenta{
    
    private String material;
    private String tipoCorte;

    public Zapato() {
    }

    public Zapato(String material, String tipoCorte, int codigo, String nombre, double precio, String marca, int talla, String color) {
        super(codigo, nombre, precio, marca, talla, color);
        this.material = material;
        this.tipoCorte = tipoCorte;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }
    
    @Override
    public void mostrarMarca(){
        System.out.println("Estos zapatos son de la marca "+super.getMarca());
    }
    
}
