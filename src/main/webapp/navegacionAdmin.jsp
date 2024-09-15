<%-- 
    Document   : navegacionAdmin
    Created on : 14 oct. 2022, 21:45:49
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link href="EstilosCategorias.css" rel="stylesheet" type="text/css"/>
        <title>Mi dinero</title>
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
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="administrador.jsp">Inicio</a>

                        </li>

                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4"  aria-current="page" href="ControladorUsuarios?accion=Listar">Administrar usuarios</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4"  aria-current="page" href="ControladorCategorias?accion=Listar">Administrar categorías</a>

                        </li>
                        <br>
                        <br>
                        <li class="nav-item"><a class="nav-link active fw-bold fs-5"  href='ControladorLogin?registreseOcrear=logout'>
                                <button  id="cerrarSesion" onclick="cerrarSesion()"  >Cerrar sesión</button>
                            </a>
                        </li>

                    </ul>


                </div>
            </div>
        </nav>
    </body>
</html>

