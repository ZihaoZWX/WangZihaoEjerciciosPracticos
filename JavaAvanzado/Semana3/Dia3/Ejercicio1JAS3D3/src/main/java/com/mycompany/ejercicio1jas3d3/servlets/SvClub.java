
package com.mycompany.ejercicio1jas3d3.servlets;

import com.mycompany.ejercicio1jas3d3.logic.ClubController;
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
@WebServlet(name = "SvClub", urlPatterns = {"/SvClub"})
public class SvClub extends HttpServlet {
    ClubController cc=new ClubController();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if(!request.getParameter("clubName").isBlank()){
            String clubName=request.getParameter("clubName");
            List<GamesPlayed> games=new ArrayList<>();
            Club club=new Club(clubName,games);
            cc.createClub(club);
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
