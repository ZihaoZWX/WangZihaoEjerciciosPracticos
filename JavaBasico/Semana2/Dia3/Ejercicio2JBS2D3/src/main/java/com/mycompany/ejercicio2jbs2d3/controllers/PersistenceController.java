package com.mycompany.ejercicio2jbs2d3.controllers;

import com.mycompany.ejercicio2jbs2d3.controllers.exceptions.NonexistentEntityException;
import com.mycompany.ejercicio2jbs2d3.models.Platillos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class PersistenceController {
    
    PlatillosJpaController platosJPA=new PlatillosJpaController();
    
    public void createPlatillo(Platillos platillo) {
        platosJPA.create(platillo);
    }
    
    public void deletePlatillo(int id) {
        try {
            platosJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editPlatillo(Platillos platillo) {
        try {
            platosJPA.edit(platillo);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Platillos verPlato(int id){
        return platosJPA.findPlatillos(id);
    }
    
    public ArrayList<Platillos> verPlatos(){
        List<Platillos> temp=platosJPA.findPlatillosEntities();
        ArrayList<Platillos> platos=new ArrayList<>(temp);
        return platos;
    }
    
}
