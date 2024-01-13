<%-- 
    Document   : index
    Created on : 12 ene 2024, 11:59:14
    Author     : Zihao Wang
--%>

<%@page import="com.mycompany.ejercicio1jas3d3.logic.GamesController"%>
<%@page import="com.mycompany.ejercicio1jas3d3.models.GamesPlayed"%>
<%@page import="com.mycompany.ejercicio1jas3d3.logic.ClubController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.ejercicio1jas3d3.models.Club"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BasketBall</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Club Registration</h1>
            <form action="SvClub" method="post">
                <div class="form-group">
                    <input type="text" name="clubName"/><label>Enter the club name</label>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
            <h1>Game Registration</h1>
            <form action="SvGamesPlayed" method="post">
                <div class="form-group">

                    <select name="firstClub" id="firstClub">
                        <%
                            ClubController cb = new ClubController();
                            List<Club> clubs = new ArrayList<>(cb.findAllClub());
                            for (Club data : clubs) {
                        %>
                        <option value="<%=data.getName()%>"><%=data.getName()%></option>
                        <%}%>
                    </select>
                    <label>Select the first club</label>
                    <select name="secondClub" id="secondClub"></select>
                    <label>Select the second club</label>
                    <script>
                        function updateSecondSelect() {
                            var firstSelect = document.getElementById("firstClub");
                            var secondSelect = document.getElementById("secondClub");
                            var selectedOption = firstSelect.value;

                            var currentSelection = secondSelect.value;

                            secondSelect.innerHTML = "";

                            var restoreSelection = false;

                        <% for (Club data : clubs) {%>
                            if ("<%= data.getName()%>" !== selectedOption) {
                                var option = document.createElement("option");
                                option.value = "<%= data.getName()%>";
                                option.text = "<%= data.getName()%>";
                                secondSelect.add(option);

                                if ("<%= data.getName()%>" === currentSelection) {
                                    restoreSelection = true;
                                }
                            }
                        <% }%>

                            if (restoreSelection) {
                                secondSelect.value = currentSelection;
                            }
                        }

                        updateSecondSelect();

                        document.getElementById("firstClub").addEventListener("change", function () {
                            updateSecondSelect();
                        });
                    </script>
                </div>
                <div class="form-group">
                    <input type="date" name="date"/><label>Enter the date</label>
                </div>
                <div class="form-group">
                    <input type="number" min="0" max="100" name="team1Score"/><label>Enter the first club score</label>
                    <input type="number" min="0" max="100" name="team2Score"/><label>Enter the second one club score</label>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <br/>
            <form action="SvGamesPlayed" method="get">
                <button type="submit" class="btn btn-success">Show</button>
            </form>
            <br/>
            <% if (request.getAttribute("listGames") != null) { %>
            <table class="table" border="1" >
                <thead>
                    <tr>
                        <th>Games</th>
                        <th>Date</th>
                        <th>Results</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        GamesController gc = new GamesController();
                        List<GamesPlayed> listGames = gc.findAllGames();
                        for (GamesPlayed games : listGames) {
                    %>
                    <tr>
                        <td><%=games.getGames()%></td> 
                        <td><%=games.getDate()%></td>
                        <td><%=games.getResults()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
            <%}%>
        </div>
    </body>
</html>
