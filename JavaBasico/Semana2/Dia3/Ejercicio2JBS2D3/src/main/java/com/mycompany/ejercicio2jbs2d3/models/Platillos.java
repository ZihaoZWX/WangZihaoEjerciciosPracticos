
package com.mycompany.ejercicio2jbs2d3.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Zihao Wang
 */

@Entity
@Table(name="platillos")
public class Platillos implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre",nullable=false)
    private String nombre;
    private String receta;
    private Double precio;

    public Platillos() {
    }

    public Platillos(Integer id, String nombre, String receta, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.receta = receta;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Platillos{" + "id=" + id + ", nombre=" + nombre + ", receta=" + receta + ", precio=" + precio + '}';
    }
    
}
