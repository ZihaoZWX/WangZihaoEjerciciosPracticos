package ejercicio1jbs2d3.models;

/**
 *
 * @author Zihao Wang
 */
public class Estudiantes {

    private int id;
    private String nombre;
    private int edad;
    private double calificación;

    public Estudiantes() {
    }

    public Estudiantes(int id, String nombre, int edad, double calificación) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.calificación = calificación;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCalificación() {
        return calificación;
    }

    public void setCalificación(double calificación) {
        this.calificación = calificación;
    }
    
}
