
package com.mycompany.ejercicio1jas3d3.logic;

import com.mycompany.ejercicio1jas3d3.models.GamesPlayed;
import com.mycompany.ejercicio1jas3d3.persistence.GamesPersistenceController;
import java.util.ArrayList;

/**
 *
 * @author Zihao Wang
 */
public class GamesController {
    
    GamesPersistenceController gpc=new GamesPersistenceController();
    
    public void createGames(GamesPlayed games){
        gpc.createGames(games);
    }
    
    public void deleteGames(int id){
        gpc.deleteGamesPlayed(id);
    }
    
    public ArrayList<GamesPlayed> findAllGames(){
        ArrayList<GamesPlayed> gamesList=new ArrayList<>(gpc.findAllGames());
        return gamesList;
    }
    
    public void editGames(GamesPlayed games){
        gpc.createGames(games);
    }

}
