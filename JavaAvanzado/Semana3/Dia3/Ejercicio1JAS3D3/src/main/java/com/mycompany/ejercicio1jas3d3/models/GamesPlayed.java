
package com.mycompany.ejercicio1jas3d3.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Zihao Wang
 */
@Entity
@Table(name="gamesplayed")
public class GamesPlayed implements Serializable {
    
    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="games",nullable=false)
    private String games;
    @Column(name="date",nullable=false)
    private LocalDate date;
    @Column(name="results",nullable=false)
    private String results;
    
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;
    @ManyToOne
    @JoinColumn(name="club_id2")
    private Club club2;

    public GamesPlayed() {
    }

    public GamesPlayed(String games, LocalDate date, String results, Club club, Club club2) {
        this.games = games;
        this.date = date;
        this.results = results;
        this.club = club;
        this.club2 = club2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Club getClub2() {
        return club2;
    }

    public void setClub2(Club club2) {
        this.club2 = club2;
    }
    
}
