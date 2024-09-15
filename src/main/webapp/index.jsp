<%-- 
    Document   : index
    Created on : 28 ene. 2022, 17:02:34
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
        <link href="EstilosIndex.css" rel="stylesheet" type="text/css"/>
        <title>Mi dinero y yo</title>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body >

        <!-- encabezado -->
        <!--<img class="container-fluid" src="Pagina de inicio fondo.png" alt="Pagina de inicio fondo" />-->

        <nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"> 
                    <span class="color fs-2 fw-bold ">Menú</span>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href='ControladorCate?accion=listarTodo'>Categorías</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="ControladorReportes?accion=Listar">Reportes</a>
                        </li>


                    </ul>
                    <form action="ControladorIndex" metAhod="POST" class="d-flex">
                        <span id="loginLogoutRegistrese">
                            <h3 class="fw-bold">
                                <%
                                    // Recupera el tipo de usuario de las variables de session
                                    String tipoUsuario = (String) session.getAttribute("tipoUsuario");

                                    if (tipoUsuario == null) {
                                        // El usuario que está navegando es anónimo
                                        out.print("<a class='btn btn-dark b_color' href='login.jsp' role='button'>Iniciar sesion</a>");
                                        // Se invoca el método get del ControladorLogin con el parámetro registrese
                                        

                                        out.print("  <a class='btn btn-dark margin-left b_color' href='registrarse.jsp' role='button'>Registrar</a>");

                                    } else {
                                        // El usuario que está navegando está registrado o es administrador
                                        String nombreUsuario = (String) session.getAttribute("nombreUsuario");
                                        out.print("Bienvenido  " + nombreUsuario);
                                    }

                                %>

                            </h3> 
                        </span>  

                        <!--<a class="btn btn-dark b_color " href="IniciarSesion.html" role="button">Iniciar sesion</a> -->
                        <!--<a class="btn btn-dark margin-left b_color" href="registrarse.html" role="button">Registrar</a>-->

                    </form>
                </div>
            </div>
        </nav>
        <img  src="Img_index/pag1.png" class="img-fluid " alt="Responsive image"> 



        <div class="  w-100 float-sm-start text-center fw-bold "><h2 class="consejo">Consejo</h2></div>
        <div class="  w-100 float-sm-start text-center bg-light pt-5 pb-5">
            <h4 > Si nunca has establecido un presupuesto 
                de ingresos y gastos,<br> ¡ahora es el momento para comenzar! </h4></div>
        <img src="Img_index/BROCHURE - MI DINERO Y YO .png" class="img-fluid " alt=""/>

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
