<%-- 
    Document   : edit
    Created on : 21 ene. 2022, 10:15:23
    Author     : Usuario
--%>
<%@page import="modelo.POJO.Categoria"%>
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
            <form action="ControladorCategorias" method="POST" >
                ID categoria:<br>
                <input type="text" name="txtid" value="${Categoria.getId_categoria()}"><br>
                Nombre:<br>
                <input type="text" name="txtnom" value="${Categoria.getNombre_categoria()}"><br>
                presupuesto:<br>
                <input type="text" name="txtpresupuesto" value="${Categoria.getPresupuesto_categoria()}"><br>
                gasto:<br>
                <input type="text" name="txtgasto" value="${Categoria.getGasto_categoria()}"><br>
                
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
