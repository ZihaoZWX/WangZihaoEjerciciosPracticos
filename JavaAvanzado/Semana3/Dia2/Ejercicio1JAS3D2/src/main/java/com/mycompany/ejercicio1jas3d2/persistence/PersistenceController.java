
package com.mycompany.ejercicio1jas3d2.persistence;

import com.mycompany.ejercicio1jas3d2.models.Votes;
import com.mycompany.ejercicio1jas3d2.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class PersistenceController {
    
    VotesJpaController vjc=new VotesJpaController();
    
    public void createVotes(Votes votes){
        vjc.create(votes);
    }
    
    public void deleteVotes(Integer id){
        try {
            vjc.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Votes> showAllVotes(){
        return vjc.findVotosEntities();
    }
    
    public void editVotes(Votes votes){
        try {
            vjc.edit(votes);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
