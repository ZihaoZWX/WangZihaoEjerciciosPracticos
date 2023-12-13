package ejercicio1;

public class Ejercicio1 {

    public static void main(String[] args) {

        Electrodomestico televisor = new Electrodomestico("sada21331", "Sangsung", "HDS", "79kw/h", "plateado");
        Electrodomestico secadora = new Electrodomestico("sda2dsa2", "Sangsung", "HDS", "120kw/h", "rojo");
        Electrodomestico lavadora = new Electrodomestico("faff2342", "Sangsung", "HDS", "111kw/h", "blanco");
        Electrodomestico dvd = new Electrodomestico();

        System.out.println(televisor.toString());
        System.out.println(secadora.toString());
        System.out.println(lavadora.toString());
        System.out.println(dvd.toString());     //Al no tener ningun parametro vamos a tener null
    }

}
