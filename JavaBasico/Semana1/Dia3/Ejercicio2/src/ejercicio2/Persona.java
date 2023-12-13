package ejercicio2;

public class Persona {
    
    private int id;
    private String nombre;
    private int edad;
    private String direccion;
    private int numero;
    
    public Persona() {
        
    }
    
    public Persona(int id,String nombre,int edad,String direccion,int numero) {
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
        this.direccion=direccion;
        this.numero=numero;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", numero=" + numero + '}';
    }
    
}
