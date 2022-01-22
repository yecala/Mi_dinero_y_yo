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
        <title>Nueva categoria</title>
    </head>
    <body>
    <center>
        <div>
        <div>
            
        </div>
           
            <form action="ControladorCategorias" method="POST">
                ID:<br>
                <input type="text" name="txtid"><br>
                NOMBRE:<br>
                <input type="text" name="txtnombres"><br>
                PRESUPUESTO:<br>
                <input type="text" name="txtpresupuesto"><br>
                GASTO REAL:<br>
                <input type="text" name="txtgasto"><br>
                
                
                <input type="submit" name="accion" value="submit">
                      
            </form>
        </div> 
    </center>
    </body>
    
</html>
