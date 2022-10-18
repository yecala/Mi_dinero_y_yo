<%-- 
    Document   : tablaBolsillos
    Created on : 2 feb. 2022, 14:22:13
    Author     : Usuario
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navegacion.jsp" %>

        <!-------------------------- barra de PRESUPUESTO--------------------------------------->
      <center>
        <div class="p-1 mt-2 barraPresupuesto h-50" >
            <table >
                <tr class=" table-active">

                    <td class="col-6" >
                        <div class="col-xs-2 me-3">
                            <label for="ex1" class="mb-1">Presupuesto total</label>
                            <input class="form-control" id="ex1" type="text" value="${Usuario.getPresupuesto_total()}" disabled="">
                        </div>

                    </td>
                    <td class="col-6" >
                        <div class="col-xs-2">
                            <label for="ex1" class="mb-1"> Presupuesto disponible </label>
                            <input class="form-control" type="text" value="${Usuario.getPresupuesto_disponible()}" disabled="">
                        </div>

                    </td>
                </tr>
            </table>
        </div>
    </center>
    <!--------------------------FIN barra de PRESUPUESTO--------------------------------------->

    <br/>
    <%        String nomCate = (String) session.getAttribute("nom_categoria");


    %>

    <h1 class='titulo mb-4'> 
        <%            out.println(nomCate);
        %> 
    </h1>

    <center>
        <table >
            <tr class=" table-active">

                <td class="col-6 " >
                    <div class="col-xs-2 me-3">
                        <label for="ex1" class="mb-1 ">Presupuesto 
                            <%            out.println(nomCate);
                            %> 

                        </label>
                            <br/>
                        <form action="ControladorBolsillos" method="POST">   
                            <input class="form-control" id="ex1" type="text" value="${Categoria.getPresupuesto_categoria()}" disabled="">
                        </form> 
                    </div>
                </td>
                <td class="col-6" >
                    <div class="col-xs-2">
                        <label for="ex1" class="mb-1">Gasto 
                            <%            out.println(nomCate);
                            %> 

                        </label>
                        <form action="ControladorBolsillos" method="POST">   
                            <input class="form-control" id="ex1" type="text" value="${Categoria.getGasto_categoria()}" disabled="">
                        </form> 
                    </div>
                </td>
            </tr>
        </table>
    </center>  

        <br/><br/>

    </center>  

    <!-------------------------------------------->
    <center>
        <form action="ControladorBolsillos" method="POST">
            <center>
                <table >
                    <tr class=" table-active">
                        <td class="col-6 " >
                            <div class="col-xs-2 me-3">
                               <button type="submit" name="accion" class="btn btn-outline-primary" id="btnListar" value="Listar">Ver mis bolsillos</button><!-- comment -->
                            </div>
                        </td>
                        <td class="col-6" >
                            <div class="col-xs-2">
                               <button type="submit" name="accion" class="btn btn-outline-primary" id="btnGuardar" value="Nuevo">Nuevo</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </center>  
            
            <input class="col-5 text-center text-danger bg-white border-0" type="text" value="${error}" disabled="" ></input>
            <br>
            <br>
            <br><!-- comment -->
            <c:forEach var="dato" items="${datos}">
                <center>
                    <div class="p-1 mb-1  h-50" >
                        <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                            <tr class=" table-active" id="fila">

                                <td  >
                                    <div class="p-4 col-xs-4">
                                        <label for="ex3">Nombre bolsillo</label>
                                        <input name="txtnombre" class="form-control col-3" id="ex3" type="text" value="${dato.getNombre_bolsillo()}" disabled="">
                                    </div>

                                </td>
                                <td>
                                    <div class=" p-4 col-xs-3">
                                        <label for="ex2">Presupuesto</label>
                                        <input name="txtpresupuesto" class="form-control" id="inputpresu" type="number" value="${dato.getPresupuesto_bolsillo()}" disabled="">
                                    </div>
                                </td>
                                <td>
                                    <div class="p-4 col-xs-3">
                                        <label for="ex2">Gasto real</label>
                                        <input name="txtgasto" class="form-control" id="inputgasto" type="number" value="${dato.getGasto_bolsillo()}" disabled="">
                                    </div>
                                </td>
                                <td>
                                    <form action="ControladorBolsillos" method="POST">
                                        <input type="hidden" name="id" value="${dato.getId_bolsillo()}">
                                        <input type="submit" name="accion" value="Editar" class="btn btn-outline-warning">                                  
                                    </form>
                                     
                                    <form action="ControladorBolsillos?accion=Delete" method="POST" class="deleteFormU " id="formDelete">
                                        <input type="hidden" name="id" value="${dato.getId_bolsillo()}">
                                        <input type="submit" name="accion" value="Delete" id="deleteBt" class="btn btn-outline-danger">
                                    </form>
                                </td>

                            </tr>

                        </table>
                    </div>
                </center>
            </c:forEach>
        </form>
    </center>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <!<!-- Alertas -->
    <script>

        $('.deleteFormU').submit(function (e) {
            e.preventDefault();

            Swal.fire({
                title: '¿Estas seguro?',
                text: "¡El bolsillo se eliminara definitivamente!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#0CD5AC',
                cancelButtonColor: '#DF2C2C',
                confirmButtonText: '¡Sí, eliminar!',
                cancelButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    this.submit();
                    document.createElement('form').submit.call(document.getElementById(deleteBt));
                }
            });
       });
    </script>
    
    <c:if test="${successDelete}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Eliminado!',
               text: 'El bolsillo fue eliminado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if>
        
    <c:if test="${successUpdate}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Actualizado!',
               text: 'El bolsillo ha sido actualizado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if>
        
    <c:if test="${successNew}">
        <script>
            Swal.fire({
               icon: 'success',
               title: 'Agregado!',
               text: 'El bolsillo ha sido creado correctamente.',
               confirmButtonColor: 'success'
            });
        </script>
    </c:if> 
        
    <c:if test="${successBolsillos}">
       <!--  <script>
            Swal.fire({
               icon: 'success',
               title: 'Bolsillos!',
               text: 'No hay bolsillos disponibles para mostrar.',
               confirmButtonColor: 'success'
            });
        </script>  -->
    </c:if>     
</body>
</html>
