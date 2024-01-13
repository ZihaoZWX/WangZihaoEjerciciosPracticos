
package com.mycompany.ejercicio1jas3d3.persistence;

import com.mycompany.ejercicio1jas3d3.models.GamesPlayed;
import com.mycompany.ejercicio1jas3d3.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class GamesPersistenceController {
    GamesPlayedJpaController gpjc=new GamesPlayedJpaController();
    
    public void createGames(GamesPlayed games){
        gpjc.create(games);
    }
    
    public List<GamesPlayed> findAllGames(){
        return gpjc.findGamesPlayedEntities();
    }
    
    public void deleteGamesPlayed(int id){
        try {
            gpjc.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GamesPersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editGamesPlayed(GamesPlayed games){
        try {
            gpjc.edit(games);
        } catch (Exception ex) {
            Logger.getLogger(GamesPersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
