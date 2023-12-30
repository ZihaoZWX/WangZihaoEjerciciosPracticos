package ejercicio2jas1d2;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Zihao Wang
 */
public class Trabajador implements Runnable {

    private final String nombre;
    Fabrica fabrica;

    public Trabajador(String nombre, Fabrica fabrica) {
        this.nombre = nombre;
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        while (true) {
            fabrica.ensamblar(nombre);
            fabrica.controlCalidad(nombre);
            fabrica.embalarProductos(nombre);
        }
    }

}
