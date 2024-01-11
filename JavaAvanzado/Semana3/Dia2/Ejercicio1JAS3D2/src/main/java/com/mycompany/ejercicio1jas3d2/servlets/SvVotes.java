package com.mycompany.ejercicio1jas3d2.servlets;

import com.mycompany.ejercicio1jas3d2.logic.Controller;
import com.mycompany.ejercicio1jas3d2.models.Votes;
import java.io.IOException;
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
@WebServlet(name = "SvVotes", urlPatterns = {"/SvVotes"})
public class SvVotes extends HttpServlet {
    Controller controller=new Controller();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String countVotes=request.getParameter("option");
        if(countVotes!=null){
        System.out.println(countVotes);
        Votes vote=new Votes();
        vote.setName(countVotes);
        controller.createVote(vote);
        }
        response.sendRedirect("index.jsp");
        
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Votes>listVotes=new ArrayList<>(controller.showAllVotes());
        long vox;
        long pp;
        long psoe;
        List listVox=listVotes.stream().filter(data-> data.getName().equals("VOX")).toList();
        List listPp=listVotes.stream().filter(data-> data.getName().equals("PP")).toList();
        List listPsoe=listVotes.stream().filter(data-> data.getName().equals("PSOE")).toList();
        vox=listVox.stream().count();
        pp=listPp.stream().count();
        psoe=listPsoe.stream().count();
        request.setAttribute("voxVotes", vox);
        request.setAttribute("ppVotes", pp);
        request.setAttribute("psoeVotes", psoe);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
