<%-- 
    Document   : adminUsuarios
    Created on : 20 ene. 2022, 21:00:52
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css">-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>-->
        <!--<link rel="stylesheet" type="text/css" href="sweetalert/sweetalert2.min.css">-->
        <!--<script type="text/javascript" src="sweetalert/sweetalert2.min.js" ></script>-->
        <script src="sweetalert2.all.min.js" type="text/javascript"></script>
        <link href="sweetalert2.min.css" rel="stylesheet" type="text/css"/>
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
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="administrador.html">Inicio</a>
                           
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
                <li> <button id="cerrarSesion" onclick="cerrarSesion() "  href='ControladorLogin?registreseOcrear=logout'>Cerrar sesión </button></li>
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
        <br/><br/>
        
    <center>    
        <h1 style="color: rgb(12, 213, 172)">Administrar categorías</h1><br>
        <form action="ControladorCategorias" method="POST">
            
            <input type="submit" name="accion" value="Listar" class="btn btn-outline-primary">
            <input type="submit" name="accion" value="Nuevo" class="btn btn-outline-primary">
        </form>
        <br/>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">ID CATEGORIAS</th>
                    <th scope="col">NOMBRE CATEGORIA</th>
                    <th scope="col">ACCIONES</th>
                </tr>
            </thead>
            
            
                
            <c:forEach var="dato" items="${datos}">
                <tr>
                   <td id="idCat">${dato.getId_categoria()}</td>
                    <td id="nomCat">${dato.getNombre_categoria()}</td>
                    
                    
                <td>
                 
                    <form action="ControladorCategorias" method="POST" class="float-start pe-2 ">
                        <input type="hidden" name="id" value="${dato.getId_categoria()}">
                       
                        <input type="submit" name="accion" value="Editar" class="btn btn-outline-warning">
                       
                    </form>  
                    <form action="ControladorCategorias?accion=Eliminar" method="POST" class="deleteForm float-start " id="formDelete">   
                        <input type="hidden" name="id" value="${dato.getId_categoria()}">
                        <input type="submit" name="accion" value="Eliminar" id="deleteBtn" class="btn btn-outline-danger " >
                    </form>     
                  
                </td>
                </tr>
            </c:forEach>
            <c:if test="${loginError}">
                <script>

                    Swal.fire({
                      icon: 'error',
                      title: 'Oops...',
                      text: 'No se puede eliminar categoria debido a bolsillos asociados!',
                      confirmButtonColor: '#0CD5AC'
                    });
                </script>
            </c:if>
            <c:if test="${success}">
                <script>
                    Swal.fire({
                       icon: 'success',
                       title: 'Eliminado!',
                       text: 'La categoria fue eliminada correctamente.',
                       confirmButtonColor: 'success'
                    });
                </script>
            </c:if>
      


    </center>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="adminCategorias.js" type="text/javascript"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <script>

        $('.deleteForm').submit(function (e) {
            e.preventDefault();

            Swal.fire({
                title: '¿Estas seguro?',
                text: "¡La categoria se eliminara definitivamente!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0CD5AC',
                cancelButtonColor: '#DF2C2C',
                confirmButtonText: '¡Sí, eliminar!',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    this.submit();
                    document.createElement('form').submit.call(document.getElementById(deleteBtn));
                }
            });
       });
    </script>
</body>
</html>

