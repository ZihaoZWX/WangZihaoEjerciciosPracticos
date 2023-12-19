package ejercicio2jbs2d2.models;

import java.util.ArrayList;
import java.util.List;

public class Funciones {

    public static void start() {
        crearProductos();
        precios();
        borrarPosicion5();
    }
    
    static List<Producto> productos = new ArrayList<>();

    public static void crearProductos() {
        productos.add(new Producto(1, "SCJ3", "Sangsung", "A", 300, 700, 1000));
        productos.add(new Producto(2, "S7", "Sangsung", "A", 500, 1200, 1200));
        productos.add(new Producto(3, "SL2", "Sangsung", "B", 200, 500, 2000));
        productos.add(new Producto(4, "G3", "LG", "C", 50, 120, 10000));
        productos.add(new Producto(5, "HR5", "HP", "A", 1000, 1700, 500));
        productos.add(new Producto(6, "HB3000", "Huawei", "A", 400, 800, 1500));
        productos.add(new Producto(7, "HL3000", "Huawei", "C", 400, 800, 1500));
        productos.add(new Producto(8, "i3", "Iphone", "A", 10, 100, 50000));
        productos.add(new Producto(9, "iu2", "Iphone", "B", 12, 120, 50000));
        productos.add(new Producto(10, "s1", "Supreme", "A", 2, 300, 100000));
    }
    
    public static double mayorPrecioVenta(){
        double precioMax=0;
        for(Producto data:productos){
            if(precioMax<data.getPrecioVenta()){
                precioMax=data.getPrecioVenta();
            }
        }
        return precioMax;
    }
    
    public static double menorPrecioCosto(){
        double precioMin=0;
        for(Producto data:productos){
            if(precioMin<data.getPrecioCosto()){
                precioMin=data.getPrecioCosto();
            }
        }
        return precioMin;
    }
    
    public static int mayorCantidadStock(){
        int mayorStock=0;
        for(Producto data:productos){
            if(mayorStock<data.getCantidadEnStock()){
                mayorStock=data.getCantidadEnStock();
            }
        }
        
        return mayorStock-3;
    }
    
    public static void precios(){
        System.out.println("El precio mas alto de venta es de "+mayorPrecioVenta()+"\nEl precio mas bajo de coste "+
                menorPrecioCosto()+"\nLa mayor cantidad de stock es de "+mayorCantidadStock()+" restado 3 unidades");
    }
    
    public static void borrarPosicion5(){
        productos.remove(4);
        System.out.println("Nueva lista de productos ");
        for(Producto data:productos){
            System.out.println(data.toString());
        }
    }

}
