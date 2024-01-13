package com.mycompany.ejercicio1jas3d3.servlets;

import com.mycompany.ejercicio1jas3d3.logic.ClubController;
import com.mycompany.ejercicio1jas3d3.logic.GamesController;
import com.mycompany.ejercicio1jas3d3.models.Club;
import com.mycompany.ejercicio1jas3d3.models.GamesPlayed;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zihao Wang
 */
@WebServlet(name = "SvGamesPlayed", urlPatterns = {"/SvGamesPlayed"})
public class SvGamesPlayed extends HttpServlet {

    GamesController gc = new GamesController();
    ClubController cc=new ClubController();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        List<GamesPlayed> listGames=new ArrayList<>(gc.findAllGames());
        request.setAttribute("listGames", listGames);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if (!request.getParameter("firstClub").isBlank() && !request.getParameter("secondClub").isBlank() && !request.getParameter("date").isBlank() && !request.getParameter("team1Score").isBlank() && !request.getParameter("team2Score").isBlank()) {
            String firstClub = request.getParameter("firstClub");
            String secondClub = request.getParameter("secondClub");
            String match = firstClub + "-" + secondClub;
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String firstClubScore = request.getParameter("team1Score");
            String secondClubScore = request.getParameter("team2Score");
            String result = firstClubScore + "-" + secondClubScore;
            Club club=new Club();
            Club club2=new Club();
            club.setName(firstClub);
            club2.setName(secondClub);
            GamesPlayed game = new GamesPlayed(match, date, result,club,club2);
            List<GamesPlayed> games=new ArrayList<>();
            games.add(game);
            club2.setGames(games);
            club.setGames(games);
            cc.editClub(club);
            cc.editClub(club2);
            gc.createGames(game);
        }
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
