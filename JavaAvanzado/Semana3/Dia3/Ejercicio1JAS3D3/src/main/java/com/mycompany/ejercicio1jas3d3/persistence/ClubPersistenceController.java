
package com.mycompany.ejercicio1jas3d3.persistence;

import com.mycompany.ejercicio1jas3d3.models.Club;
import com.mycompany.ejercicio1jas3d3.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class ClubPersistenceController {
    ClubJpaController cjc=new ClubJpaController();
    
    public void createClub(Club club){
        try {
            cjc.create(club);
        } catch (Exception ex) {
            Logger.getLogger(ClubPersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Club> findAllClubs(){
        return cjc.findClubEntities();
    }
    
    public void deleteClub(String name){
        try {
            cjc.destroy(name);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ClubPersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editClub(Club club){
        try {
            cjc.edit(club);
        } catch (Exception ex) {
            Logger.getLogger(ClubPersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Club findClub(String club){
        return cjc.findClub(club);
    }

}
