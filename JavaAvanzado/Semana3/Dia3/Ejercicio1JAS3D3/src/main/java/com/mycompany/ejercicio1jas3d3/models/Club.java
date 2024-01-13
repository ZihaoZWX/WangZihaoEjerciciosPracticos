
package com.mycompany.ejercicio1jas3d3.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zihao Wang
 */
@Entity
@Table(name="club")
public class Club implements Serializable {
    
    @Id
    @Column(name="name",nullable=false)
    private String name;
    
    @OneToMany(mappedBy="club")
    List<GamesPlayed> games;

    public Club() {
    }

    public Club(String name, List<GamesPlayed> games) {
        this.name = name;
        this.games = games;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GamesPlayed> getGames() {
        return games;
    }

    public void setGames(List<GamesPlayed> games) {
        this.games = games;
    }
    
}
