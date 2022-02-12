<%-- 
    Document   : reportes2
    Created on : 2/02/2022, 08:55:02 PM
    Author     : pipe_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="chart.js"></script>

    </head>
    <body>
        <%@include file="navegacion.jsp" %>

        <%                // Recupera el tipo de usuario de las variables de session
            String tipoU = (String) session.getAttribute("tipoUsuario");

            if (tipoUsuario == null) {

        %>

        <h3>Para ver los reportes debes iniciar sesión</h3>
        <%        } else {
        %> 

        <h1>Hello World!</h1>
        <canvas id="myChart"></canvas>
    </body>

        <%
            }
        %>

</html>
