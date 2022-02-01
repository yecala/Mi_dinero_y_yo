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
        <nav class="navbar navbar-expand-lg navbar-light barra_color p-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"> 
                    <span class="T_color fs-2 fw-bold ">Mi dinero y yo </span>
                    <img class="img-fluid col-3" src="Img_menu/mano.png" alt=""/>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="col-5 collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="categorias.jsp">Categorias</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="#">Reportes</a>
                        </li>
                    </ul>
                </div>
                <div class="col-3">
                    <span id="iconos" >
                        <%
                            // Recupera el tipo de usuario de las variables de session
                            String tipoUsuario = (String) session.getAttribute("tipoUsuario");

                            if (tipoUsuario != null) {
                                String nombreUsuario = (String) session.getAttribute("nombreUsuario");
                                out.print(nombreUsuario);
                        %>
                        <img id="perfil" class="icono " src="Img_menu/usuario-de-perfil.png" alt="icono perfil" onclick="Mostrar_Ocultar()" />
                        <img id="notificaciones" class="icono " src="Img_menu/notificacion.png" alt="icono notificaciones" onclick="Mostrar_Ocultar2()" />
                        <%
                            }


                        %>    
                    </span>
                </div>

                <!-- Menu desplegable perfil 
                
                SE PASA AL JSP
                
                <img class="icono" src="Img_menu/usuario-de-perfil.png" alt="icono perfil" onclick="Mostrar_Ocultar()"/>
                <img class="icono" src="Img_menu/notificacion.png" alt="icono notificaciones" onclick="Mostrar_Ocultar2()" />

                 Fin Menu desplegable perfil -->

            </div>
        </nav>

        <!--<form method="get" action="ControladorLogin?registreseOcrear=logout">-->
            <section id="caja" class="caja">     
                <ul>
                    <li><a  href='ControladorLogin?registreseOcrear=logout'>
                            <button  id="cerrarSesion" onclick="cerrarSesion()"  >Cerrar sesion</button>
                        </a>
                    </li>
                    <!--<li> <button type="submit" id="cerrarSesion" onclick="cerrarSesion()"  >Cerrar sesion</button></li>-->

                    <li><b>Nombre</b></li>
                    <li>Correo</li>
                    <li>  </li>
                    <li> Cambiar contraseña  <img class="editar" src="Img_menu/editar.png" alt="Editar"/> </li>

                    <li> Presupuesto mensual <img class="editar" src="Img_menu/editar.png" alt="Editar"/></li>
                    <li> </li>
                    <li>Mis categorias</li>

                </ul>
            </section>
        <!--</form>--->

        <section id="caja2" class="caja2"> 
            <h3 id="tituloNoti">Notificaciones</h3>
        </section> 



        <a href="ControladorCategorias?idCategoria=1" id="hogar">Hogar</a>
        <a href="ControladorCategorias?idCategoria=2" id="mascotas">Mascotas</a>
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
