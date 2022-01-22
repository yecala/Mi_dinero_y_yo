<%-- 
    Document   : edit
    Created on : 21 ene. 2022, 10:15:23
    Author     : Usuario
--%>
<%@page import="modelo.POJO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div>
            <h3></h3>
        </div>
        <hr><!-- comment --> 
        <div>
            <form action="ControladorUsuarios" method="POST" >
                ID USUARIO:<br>
                <input type="text" name="txtid" value="${usuario.getId_usuario()}"><br>
                Nombre:<br>
                <input type="text" name="txtnom" value="${usuario.getNombre_completo()}"><br>
                Correo:<br>
                <input type="email" name="txtcorreo" value="${usuario.getCorreo()}"><br>
                Contrasena:<br>
                <input type="password" name="txtcontrasena" value="${usuario.getPassword()}"><br>
                Presupuesto total:<br>
                <input type="text" name="txtpresupuesto" value="${usuario.getPresupuesto_total()}"><br><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
