<%-- 
    Document   : agregar.jsp
    Created on : 21/01/2022, 04:51:05 PM
    Author     : pipe_
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo</title>
    </head>
    <body>
    <center>
        <div>
        <div>
            
        </div>
           
            <form action="ControladorUsuarios" method="POST">
                ID:<br>
                <input type="text" name="txtid"><br>
                NOMBRES:<br>
                <input type="text" name="txtnombres"><br>
                CORREO:<br>
                <input type="email" name="txtcorreo"><br>
                PASSWORD:<br>
                <input type="password" name="txtpassword"><br>
                PRESUPUESTO:<br>
                <input type="text" name="txtpresupuesto"><br>
                
                <input type="submit" name="accion" value="submit">
                      
            </form>
        </div> 
    </center>
    </body>
    
</html>
