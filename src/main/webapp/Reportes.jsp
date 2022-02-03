<%-- 
    Document   : Reportes
    Created on : 2/02/2022, 03:26:27 PM
    Author     : pipe_
--%>



<%@page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html> 
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Reportes</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
            <%@include file="navegacion.jsp" %>

            <%                // Recupera el tipo de usuario de las variables de session
                String tipoU = (String) session.getAttribute("tipoUsuario");

                if (tipoUsuario == null) {

            %>

            <h3>Para ver los reportes debes iniciar sesion</h3>
            <%        } else {
            %> 
            <br>
        <center>    
            <h1 style="color: rgb(12, 213, 172)">Reporte de gastos</h1><br>
            <form action="ControladorCategorias" method="POST">
                <a href="reportes2.jsp">
                    <input type="submit" name="accion" value="Ver detalles" class="btn btn-outline-primary">
                </a>
            </form>
            <br/>
            <table class="table ">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">CATEGORIAS</th> 
                        <th scope="col">PRESUPUESTO</th> 
                        <th scope="col">GASTO REAL  </th>
                    </tr>

                    <c:forEach var="dato" items="${datos}">
                        <tr>
                            <td>${dato.getId_categoria()}</td>
                            <td>${dato.getNombre_categoria()}</td>



                        </tr>
                    </c:forEach>


                    <tr class="table-primary">
                        <td scope="col">Total</td> 
                        <td scope="col"></td> 
                        <td scope="col"></td>
                    </tr>

                    <tr class="table-info">
                        <td scope="col">Presupuesto total</td> 
                        <td scope="col"></td> 
                        <td scope="col"></td>
                    </tr>

                    <tr style="background-color:#96F990">
                        <td scope="col">Ahorro</td> 
                        <td scope="col"></td> 
                        <td scope="col"></td>
                    </tr>

                </thead>
            </table>
            <%
                }
            %>

        </center>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

