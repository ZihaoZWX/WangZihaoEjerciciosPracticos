<%-- 
    Document   : index
    Created on : 11 ene 2024, 15:50:19
    Author     : Zihao Wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ZWX Votes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Votes</h1>
            <p>Choose your vote:</p>

            <form action="SvVotes" method="post">
                <div class="form-group">
                    <input type="radio" name="option" value="VOX"/><label>VOX</label>
                </div>
                <div class="form-group">
                    <input type="radio" name="option" value="PP"/><label>PP</label>
                </div>
                <div class="form-group">
                    <input type="radio" name="option" value="PSOE"/><label>PSOE</label>
                </div>
                <button type="submit" class="btn btn-primary">VOTE</button>
            </form>

            <br/>

            <form action="SvVotes" method="get">
                <button type="submit" class="btn btn-success">SHOW</button>
            </form>
            
            <br/>
            
            <table class="table" border="1" >
                <thead>
                    <tr>
                        <th>Parties</th>
                        <th>Votes</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>VOX</td>
                        <td><%=request.getAttribute("voxVotes")%></td>
                    </tr>
                    <tr>
                        <td>PP</td>
                        <td><%=request.getAttribute("ppVotes")%></td>
                    </tr>
                    <tr>
                        <td>PSOE</td>
                        <td><%=request.getAttribute("psoeVotes")%></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
