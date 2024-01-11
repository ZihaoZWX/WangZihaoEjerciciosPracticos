
package com.mycompany.ejercicio1jas3d2.logic;

import com.mycompany.ejercicio1jas3d2.models.Votes;
import com.mycompany.ejercicio1jas3d2.persistence.PersistenceController;
import java.util.ArrayList;

/**
 *
 * @author Zihao Wang
 */
public class Controller {
    
    PersistenceController pc=new PersistenceController();
    
    public void createVote(Votes votes){
        pc.createVotes(votes);
    }
    
    public void deleteVote(Integer id){
        pc.deleteVotes(id);
    }
    
    public ArrayList<Votes> showAllVotes(){
        ArrayList<Votes> listVotes=new ArrayList<>(pc.showAllVotes());
        return listVotes;
    }
    
    public void editVote(Votes votes){
        pc.editVotes(votes);
    }
    
}
