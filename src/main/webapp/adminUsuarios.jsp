<%-- 
    Document   : adminUsuarios
    Created on : 20 ene. 2022, 21:00:52
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.POJO.Usuario"%>
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
        <title>Administrar usuarios</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js" type="text/javascript"></script>
        <link href="sweetalert2.min.css" rel="stylesheet" type="text/css"/>
   
    </head>
    <body>
        <!--------------------------barra de navegacion--------------------------------------->
        <%@include file="navegacionAdmin.jsp" %>
        <!--------------------------FIN barra de navegacion--------------------------------------->
        <br/><br/>
        
    <center>    
        <h1 style="color: rgb(12, 213, 172)">Administrar usuarios</h1><br>
        <form action="ControladorUsuarios" method="POST">
            <input type="submit" name="accion" value="Nuevo" class="btn btn-outline-primary">
        </form>
        <br/>
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID USUARIO</th>
                        <th scope="col">NOMBRE</th>
                        <th scope="col">CORREO</th>
                        <th scope="col">CONTRASENA</th>
                        <th scope="col">PRESUPUESTO TOTAL</th>
                        <th scope="col">ESTADO</th>
                        <th scope="col">BIT ADMIN</th>
                        <th scope="col">ACCIONES</th>
                    </tr>
                </thead>

                <c:forEach var="dato" items="${datos}">
                    <tr>
                       <td>${dato.getId_usuario()}</td>
                        <td>${dato.getNombre_usuario()}</td>
                        <td>${dato.getCorreo()}</td>
                        <td>${dato.getPassword()}</td>
                        <td>${dato.getPresupuesto_total()}</td>
                        <td>${dato.getEstado()}</td>
                        <td>${dato.getBit_admin()}</td>

                    <td>
                        <form action="ControladorUsuarios" method="POST" class="float-start pe-2 ">
                            <input type="hidden" name="id" value="${dato.getId_usuario()}">
                            <input type="submit" name="accion" value="Editar" class="btn btn-outline-warning">
                        </form>  
                        <form action="ControladorUsuarios?accion=Eliminar" method="POST" class="deleteForm float-start " id="formDelete">   
                            <input type="hidden" name="id" value="${dato.getId_usuario()}">
                            <input type="submit" name="accion" value="Eliminar" id="deleteBtn" class="btn btn-outline-danger " >
                        </form>     
                    </td>
                    </tr>
                </c:forEach>
            </table>   
        </div>
    </center>   
    
    <c:if test="${successDelete}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Desactivado!',
               text: 'El usuario fue desactivado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if>
    <c:if test="${successCreate}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Agregado!',
               text: 'El usuario fue creado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if>
    <c:if test="${successUpdate}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Actualizado!',
               text: 'El usuario fue actualizado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if>     
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <script>

        $('.deleteForm').submit(function (e) {
            e.preventDefault();

            Swal.fire({
                title: '¿Estas seguro?',
                text: "¡El usuario quedará desactivado!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0CD5AC',
                cancelButtonColor: '#DF2C2C',
                confirmButtonText: '¡Sí, desactivar!',
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

