<%-- 
    Document   : agregar.jsp
    Created on : 21/01/2022, 04:51:05 PM
    Author     : pipe_
--%>

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
        <div>
            
        </div>
           
            <form action="controladorUsuarios" method="POST">
                ID:
                <input type="text" name="txtid">
                NOMBRES:
                <input type="text" name="txtnombres">
                CORREO:
                <input type="email" name="txtcorreo">
                PASSWORD:
                <input type="password" name="txtpassword">
                PRESUPUESTO:
                <input type="text" name="txtpresupuesto"><br>
                
                <input type="submit" name="accion" value="submit">
                      
            </form>
        </div> 
    </center>
    </body>
    
    
    
</html>
