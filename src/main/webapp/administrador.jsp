<%-- 
    Document   : administrador
    Created on : 14 oct. 2022, 21:51:34
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
        <link href="EstilosBolsillos.css" rel="stylesheet" type="text/css"/>
        <title>INICIO</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <!--------------------------barra de navegacion--------------------------------------->
        <%@include file="navegacionAdmin.jsp" %>

        <section id="caja" class="caja">     
            <ul>
                <li> <button id="cerrarSesion" onclick="cerrarSesion()">Cerrar sesión</button></li>
                <li><b>Nombre</b></li>
                <li>Correo</li>
                <li>  </li>
                <li> Cambiar contraseña  <img class="editar"  src="Img_menu/editar.png" alt="Editar"/> </li>

                <li> Presupuesto mensual <img class="editar" src="Img_menu/editar.png" alt="Editar"/></li>
                <li> </li>
                <li>Mis categorías</li>

            </ul>
        </section>

        <section id="caja2" class="caja2"> 
            <h3 id="tituloNoti">Notificaciones</h3>
        </section>   
        <!--------------------------FIN barra de navegacion--------------------------------------->
    <center>
        <br/>
        <br/>

        <br/>
        <br/>
        <br/>

        <div style=" font-size: 150px">
            Bienvenido
        </div>
    </center>    
</body>
</html>
