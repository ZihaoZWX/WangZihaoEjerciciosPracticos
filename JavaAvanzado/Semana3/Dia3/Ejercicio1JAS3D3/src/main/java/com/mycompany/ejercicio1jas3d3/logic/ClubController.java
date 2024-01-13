
package com.mycompany.ejercicio1jas3d3.logic;

import com.mycompany.ejercicio1jas3d3.models.Club;
import com.mycompany.ejercicio1jas3d3.persistence.ClubPersistenceController;
import java.util.ArrayList;

/**
 *
 * @author Zihao Wang
 */
public class ClubController {
    
    ClubPersistenceController cpc=new ClubPersistenceController();
    
    public void createClub(Club club){
        cpc.createClub(club);
    }
    
    public void deleteClub(String name){
        cpc.deleteClub(name);
    }
    
    public void editClub(Club club){
        cpc.editClub(club);
    }
    
    public ArrayList<Club> findAllClub(){
        ArrayList<Club> clubList=new ArrayList<>(cpc.findAllClubs());
        return clubList;
    }
    
    public Club findClub(String club){
        return cpc.findClub(club);
    }

}
