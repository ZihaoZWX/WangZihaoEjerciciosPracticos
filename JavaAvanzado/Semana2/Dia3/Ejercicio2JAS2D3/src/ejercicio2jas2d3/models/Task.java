
package ejercicio2jas2d3.models;

import java.util.List;

/**
 *
 * @author Zihao Wang
 */
public class Task {
    
    private String nombre;
    private List<Task> subtask;
    
    public Task(){
        
    }

    public Task(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Task> getSubtask() {
        return subtask;
    }

    public void setSubtask(List<Task> subtask) {
        this.subtask = subtask;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
