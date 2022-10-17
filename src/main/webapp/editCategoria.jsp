<%-- 
    Document   : edit
    Created on : 21 ene. 2022, 10:15:23
    Author     : Usuario
--%>
<%@page import="modelo.POJO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><!--
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="EstilosBolsillos.css" rel="stylesheet" type="text/css"/>
        <title>Administrar categorias</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <!--------------------------barra de navegacion--------------------------------------->
        <%@include file="navegacionAdmin.jsp" %>
        <!--------------------------FIN barra de navegacion--------------------------------------->
        
    <center>
        <div>
            <h3></h3>
        </div>
        <hr><!-- comment --> 
        <div>
            <form action="ControladorCategorias" method="POST" >
                ID categoria:<br>
                <div class="field_container">
                <input type="text" name="txtid"  value="${Categoria.getId_categoria()}" class="form-control col-2" id="idcat" readonly  ><br>
                </div>
                Nombre:<br>
                <input type="text" name="txtnom" value="${Categoria.getNombre_categoria()}" class="form-control col-2" id="nombre" required><br>
                Consejo:<br>
                <input type="text" name="txtconsejo" value="${Categoria.getConsejo()}" class="form-control col-2" id="consejo" required><br>
                

                <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-warning" id="botonEnviar" >
            </form>
        </div>
    </center>
</body>
</html>
