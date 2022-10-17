<%-- 
    Document   : edit
    Created on : 21 ene. 2022, 10:15:23
    Author     : Usuario
--%>
<%@page import="modelo.POJO.Usuario"%>
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
            <form action="ControladorUsuarios" method="POST" >
                ID USUARIO:<br>
                <input type="text" name="txtid" value="${usuario.getId_usuario()}" class="form-control col-2" id="idUs" readonly ><br>
                Nombre:<br>
                <input type="text" name="txtnom" value="${usuario.getNombre_usuario()}" class="form-control col-2" id="nombre" required><br>
                Correo:<br>
                <input type="email" name="txtcorreo" value="${usuario.getCorreo()}"  class="form-control col-2"id="correo"  required><br>
                Contrasena:<br>
                <input type="text" name="txtcontrasena" value="${usuario.getPassword()}"  class="form-control col-2" id="password" required><br>
                Presupuesto total:<br>
                <input type="text" name="txtpresupuesto" value="${usuario.getPresupuesto_total()}"  class="form-control col-2" id="presupuesto" required><br><br>
                Estado:<br>
                <input type="text" name="txtestado" value="${usuario.getEstado()}"  class="form-control col-2" id="estado" required><br><br>
                Bit admin<br>
                <input type="text" name="txtadmin" value="${usuario.getBit_admin()}"  class="form-control col-2" id="bit_admin" required><br><br>
                <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-warning" id="botonEnviar">
            </form>
        </div>
    </center>
</body>
</html>