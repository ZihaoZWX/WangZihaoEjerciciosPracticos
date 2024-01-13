package com.mycompany.ejercicio1jas3d3.models;

import com.mycompany.ejercicio1jas3d3.models.Club;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-12T19:48:07")
@StaticMetamodel(GamesPlayed.class)
public class GamesPlayed_ { 

    public static volatile SingularAttribute<GamesPlayed, LocalDate> date;
    public static volatile SingularAttribute<GamesPlayed, String> games;
    public static volatile ListAttribute<GamesPlayed, Club> club;
    public static volatile SingularAttribute<GamesPlayed, Integer> id;
    public static volatile SingularAttribute<GamesPlayed, String> results;

}