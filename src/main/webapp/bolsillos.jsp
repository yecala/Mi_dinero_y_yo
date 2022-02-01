<%-- 
    Document   : bolsillos
    Created on : 29 ene. 2022, 21:22:27
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="EstilosBolsillos.css" rel="stylesheet" type="text/css"/>
        <title>Bolsillos</title>
        <script src="jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
        <script src="bolsillos.js" type="text/javascript"></script>

    </head>

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
                        <a class="nav-link active fw-bold fs-4" aria-current="page" href="index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link fw-bold fs-4" href="categorias.jsp">Categorias</a>

                    </li>
                    <li class="nav-item">
                        <a class="nav-link fw-bold fs-4" href="#">Reportes</a>
                    </li>
                </ul>

                <!-- Menu desplegable perfil -->


                <img class="icono" src="Img_menu/usuario-de-perfil.png" alt="icono perfil" onclick="Mostrar_Ocultar()"/>
                <img class="icono" src="Img_menu/notificacion.png" alt="icono notificaciones" onclick="Mostrar_Ocultar2()" />

                <!-- Fin Menu desplegable perfil -->
            </div>
        </div>
    </nav>


    <section id="caja" class="caja">     
        <ul>
            <li> <button id="cerrarSesion" onclick="cerrarSesion()">Cerrar sesion</button></li>
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

    <!-------------------------- barra de PRESUPUESTO--------------------------------------->
    <center>
        <div class="p-1 mt-2 barraPresupuesto h-50" >
            <table >
                <tr class=" table-active">

                    <td class="col-6" >
                        <div class="col-xs-2">
                            <label for="ex1">Presupuesto total</label>
                            <input class="form-control" id="ex1" type="text" disabled="">
                        </div>

                    </td>
                    <td class="col-6" >
                        <div class="p-4 col-xs-4">
                            Presupuesto disponible
                            <input class="form-control" type="text" disabled="">
                        </div>

                    </td>
                </tr>
            </table>
        </div>
    </center>
    <!--------------------------FIN barra de PRESUPUESTO--------------------------------------->

    <br/>
    <h1 class="titulo mb-4">Hogar</h1>

    <center>
        <table >
            <tr class=" table-active">

                <td class="col-8" >
                    <div class="col-xs-2">
                        <label for="ex1">Presupuesto hogar</label>
                        <input class="form-control" id="ex1" type="text" disabled="">
                    </div>
                </td>
            </tr>
        </table>

        <div class="p-3 mb-3 ">
            <button type="button" class="btn btn-outline-primary" id="btnAgregar"> Crear bolsillo</button>

        </div>
    </center>

    <%
        // Recupera el tipo de usuario de las variables de session
        String tipoUsuario = (String) session.getAttribute("tipoUsuario");

        if (tipoUsuario == null) {
    %>
    <!--------------------------BOLSILLO--------------------------------------->
    <center>
        <div class="p-1 mb-1  h-50" >
            <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                <tr class=" table-active">

                    <td class="col-6" >
                        <div class="p-4 col-xs-4">
                            <label for="ex3">Nombre bolsillo</label>
                            <input class="form-control" id="ex3" type="text">
                        </div>

                    </td>
                    <td>
                        <div class=" p-4 col-xs-3">
                            <label for="ex2">Presupuesto</label>
                            <input class="form-control" id="ex2" type="text">
                        </div>
                    </td>
                    <td>
                        <div class="p-4 col-xs-3">
                            <label for="ex2">Gasto real</label>
                            <input class="form-control" id="ex2" type="text">
                        </div>
                    </td>

                </tr>

            </table>
        </div>
    </center>
    <!--------------------------FIN BOLSILLO--------------------------------------->
    <%
    } else {
    %>
    <form action="ControladorBolsillos" method="POST">
        <button type="submit" name="accion" class="btn btn-outline-success" id="btnListar" value="Listar">Ver mis bolsillos</button><!-- comment -->
        <button type="submit" name="accion" class="btn btn-outline-success" id="btnGuardar" >Guardar</button>
    </form>
    <br/>
    <c:forEach var="dato" items="${datos}">
        <center>
            <div class="p-1 mb-1  h-50" >
                <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                    <tr class=" table-active">

                        <td class="col-6" >
                            <div class="p-4 col-xs-4">
                                <label for="ex3">Nombre bolsillo</label>
                                <input class="form-control" id="ex3" type="text" value="${dato.getNombre_bolsillo()}">
                            </div>

                        </td>
                        <td>
                            <div class=" p-4 col-xs-3">
                                <label for="ex2">Presupuesto</label>
                                <input class="form-control" id="ex2" type="text" value="${dato.getPresupuesto_bolsillo()}">
                            </div>
                        </td>
                        <td>
                            <div class="p-4 col-xs-3">
                                <label for="ex2">Gasto real</label>
                                <input class="form-control" id="ex2" type="text" value="${dato.getGasto_bolsillo()}">
                            </div>
                        </td>

                    </tr>

                </table>
            </div>
        </center>
    </c:forEach>

    <%
        }
    %>   

    <!--------------------------BOLSILLO--------------------------------------->
    <center>
        <div class="p-1 mb-1  h-50" >
            <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                <tr class=" table-active">

                    <td class="col-6" >
                        <div class="p-4 col-xs-4">
                            <label for="ex3">Nombre bolsillo</label>
                            <input class="form-control" id="ex3" type="text">
                        </div>

                    </td>
                    <td>
                        <div class=" p-4 col-xs-3">
                            <label for="ex2">Presupuesto</label>
                            <input class="form-control" id="ex2" type="text">
                        </div>
                    </td>
                    <td>
                        <div class="p-4 col-xs-3">
                            <label for="ex2">Gasto real</label>
                            <input class="form-control" id="ex2" type="text">
                        </div>
                    </td>

                </tr>

            </table>
        </div>
    </center>
    <!--------------------------FIN BOLSILLO--------------------------------------->


    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


</html>