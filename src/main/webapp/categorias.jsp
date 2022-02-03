<%-- 
    Document   : categorias
    Created on : 29 ene. 2022, 21:21:47
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href="EstilosCategorias.css" rel="stylesheet" type="text/css"/>
        <title>Categorias</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
         <%@include file="navegacion.jsp" %>


        <a href="ControladorCategorias?idCategoria=1&nomCate=Hogar" id="hogar">
            
            Hogar
        
        </a>
        
        
        
        <a href="ControladorCategorias?idCategoria=2&nomCate=Mascotas" id="mascotas">Mascotas</a>
        
        <a href="bolsillos.jsp" id="Ahorros">Ahorros</a><!-- comment -->
        <a href="bolsillos.jsp" id="Salud">Salud</a>
        <a href="bolsillos.jsp" id="Educacion">Educacion</a>
        <a href="bolsillos.jsp" id="Transporte">Transporte</a>
        
        <br><!-- comment -->
        
        <br>
        
        

        <a href="administrador.html">Administrador</a>

        <!-- Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>
