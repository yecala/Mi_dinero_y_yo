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
    </head>
    <body>
        <!--------------------------barra de navegacion--------------------------------------->
        <nav class="navbar navbar-expand-lg navbar-light barra_color p-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"> 
                    <span class="T_color fs-2 fw-bold ">Mi dinero y yo </span>
                    <img class="img-fluid col-3" src="Img_menu/mano.png" alt=""/>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="administrador1.html">INICIO</a>

                        </li>

                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="adminUsuarios.jsp">Administrar usuarios</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="adminCategorias.jsp">Administrar categorías</a>

                        </li>

                    </ul>


                </div>
            </div>
        </nav>


        <section id="caja" class="caja">     
            <ul>
                <li> <button id="cerrarSesion" onclick="cerrarSesion()">Cerrar sesión</button></li>
                <li><b>Nombre</b></li>
                <li>Correo</li>
                <li>  </li>
                <li> Cambiar contraseña  <img class="editar"  src="Img_menu/editar.png" alt="Editar"/> </li>

                <li> Presupuesto mensual <img class="editar" src="Img_menu/editar.png" alt="Editar"/></li>
                <li> </li>
                <li>Mis categorias</li>

            </ul>
        </section>

        <section id="caja2" class="caja2"> 
            <h3 id="tituloNoti">Notificaciones</h3>
        </section>   
        <!--------------------------FIN barra de navegacion--------------------------------------->
    <center>
        <div>
            <div>

            </div>

            <form action="ControladorCategorias" method="POST">
                <div class="field_container">
                ID:<br>
                <input type="text" name="txtid" id="idcat" class="form-control col-2"  required=""><br>
                
                Nombre:<br>
                <input type="text" name="txtnombres" id="nombre"  class="form-control col-2" required=""><br>
                Consejo<br>
                <input type="text" name="txtconsejo" id="consejo"  class="form-control col-2" required=""><br>
                
                
                </div>
                <input type="submit" name="accion" value="Enviar" class="btn btn-outline-success" id="botonEnviar">

            </form>
        </div> 
    </center>
</body>

</html>
