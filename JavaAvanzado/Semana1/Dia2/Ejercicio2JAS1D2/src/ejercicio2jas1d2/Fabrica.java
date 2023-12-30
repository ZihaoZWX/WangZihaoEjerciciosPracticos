package ejercicio2jas1d2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class Fabrica {

    public Fabrica() {

    }
    private int time;
    private int totalTime;
    private int amountOfProducts;

    public synchronized void ensamblar(String nombre) {
        System.out.println(nombre + " a empezando a emsamblar");
        time = ranDomNum(11) + 5;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " a terminado de esamblar en " + time+'s');
        totalTime=totalTime+time;
    }

    public synchronized void controlCalidad(String nombre) {
        System.out.println(nombre + " a empezando el control de calidad");
        time = ranDomNum(4) + 2;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " a terminado el control de calidad en " + time+'s');
        totalTime=totalTime+time;
    }

    public synchronized void embalarProductos(String nombre) {
        System.out.println(nombre + " a empezando embalaje de productos");
        time = ranDomNum(6) + 3;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Fabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " a terminado de embalar en " + time+'s');
        amountOfProducts+=1;
        totalTime=totalTime+time;
        System.out.println(nombre+" a fabricado "+amountOfProducts+" productos en "+calculoLlamada(totalTime));
    }

    public synchronized int ranDomNum(int time) {
        int randomNum = ThreadLocalRandom.current().nextInt(time);
        return randomNum;
    }

    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;
    public String calculoLlamada(int tiempo) {
        segundos = segundos + tiempo;
        if (segundos >= 60) {
            minutos = segundos / 60 + minutos;
            segundos = segundos % 60;
        } else if (minutos > 60) {
            horas = minutos / 60;
            minutos = minutos % 60;
        }
        return horas + "h " + minutos + "m " + segundos + "s";
    }

}
