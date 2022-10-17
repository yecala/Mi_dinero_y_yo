<%-- 
    Document   : agregar.jsp
    Created on : 21/01/2022, 04:51:05 PM
    Author     : pipe_
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <script defer src="ScriptValidacionesUsuarios.js" type="text/javascript"></script>
    </head>
    <body>
        <!--------------------------barra de navegacion--------------------------------------->
        <%@include file="navegacionAdmin.jsp" %>
        <!--------------------------FIN barra de navegacion--------------------------------------->
        
    <center>
        <div>
            <div>

            </div>

            <form action="ControladorUsuarios" method="POST">
                <label class="mt-3">ID:</label>
                <br>
                <div class="field_container">
                <input type="text" name="txtid"  class="form-control col-2" id="idUs" required="" ><br>
                Nombre:<br>
                <input type="text" name="txtnombres"  class="form-control col-2" id="nombre" required=""><br>
                Correo:<br>
                <input type="email" name="txtcorreo"  class="form-control col-2" id="correo" required=""><br>
                Contraseña:<br>
                <input type="password" name="txtpassword"  class="form-control col-2" id="password" required=""><br>
                Presupuesto:<br>
                <input type="text" name="txtpresupuesto"  class="form-control col-2" id="presupuesto" required=""><br>
                Estado:<br>
                <input type="text" name="txtestado"  class="form-control col-2" id="estado" required=""><br>
                Bit admin<br>
                <input type="text" name="txtadmin"  class="form-control col-2" id="admin" required=""><br>
                </div>
                <input type="submit" name="accion" value="Enviar" class="btn btn-outline-success mb-5" id="botonEnviar">

            </form>
        </div> 
    </center>
</body>

</html>
