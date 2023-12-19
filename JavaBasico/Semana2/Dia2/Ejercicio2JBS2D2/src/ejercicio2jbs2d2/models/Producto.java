package ejercicio2jbs2d2.models;

public class Producto {
    private int codigo;
    private String nombre;
    private String marca;
    private String tipo;
    private double precioCosto;
    private double precioVenta;
    private int cantidadEnStock;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String marca, String tipo, double precioCosto, double precioVenta, int cantidadEnStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", tipo=" + tipo + ", precioCosto=" + precioCosto + ", precioVenta=" + precioVenta + ", cantidadEnStock=" + cantidadEnStock + '}';
    }
    
}
