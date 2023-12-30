package ejercicio1jas1d2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class Agente extends Thread {

    private final String name;

    public Agente(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int tiempoTrabajo = 0;
        int llamadasRecibidas = 0;
        while (true) {
            int randomNumLlamada = ThreadLocalRandom.current().nextInt(4);
            int randomNumAtender = ThreadLocalRandom.current().nextInt(11);
            try {
                sleep(randomNumLlamada * 1000);
                System.out.println(name + " recibiendo llamada");
                sleep(randomNumAtender * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(name + " atendiendo llamadas, a tardado " + randomNumAtender + "s");
            tiempoTrabajo = randomNumLlamada + randomNumAtender;
            llamadasRecibidas += 1;
            System.out.println(name + " lleva " + llamadasRecibidas + " llamadas atendidas y en " + calculoLlamada(tiempoTrabajo));
        }
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
