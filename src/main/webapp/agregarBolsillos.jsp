<%-- 
    Document   : agregarBolsillos
    Created on : 2 feb. 2022, 14:26:02
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>

    <body>
        <%@include file="navegacion.jsp"%>

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

    <!-- comment -->
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
        <br><!-- comment -->
        <br>
        <!--------------------------BOLSILLO------------------------------------->
        <form action="ControladorBolsillos" method="POST">
            <center>
                <div class="p-1 mb-1  h-50" >
                    <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                        <tr class=" table-active">

                            <td >
                                <div class="p-4 col-xs-3">
                                    <label for="ex3">Nombre bolsillo</label>
                                    <input name="txtnombre" class="form-control" id="ex3" type="text" required="">
                                </div>

                            </td>
                            <td>
                                <div class=" p-4 col-xs-3">
                                    <label for="ex2">Presupuesto</label>
                                    <input name="txtpresupuesto" class="form-control" id="ex2" type="number" required="">
                                </div>
                            </td>
                            <td>
                                <div class="p-4 col-xs-3">
                                    <label for="ex2">Gasto real</label>
                                    <input name="txtgasto" class="form-control" id="ex2" type="number" data-bs-toggle="tooltip" title="Si no has tenido un gasto pon 0 (cero)" required="">
                                </div>
                            </td>
                            <td>
                                <div class="p-4 col-xs-3">
                                <%        // Recupera el tipo de usuario de las variables de session
                                    String tipoUsu = (String) session.getAttribute("tipoUsuario");
                                    if (tipoUsu != null) {
                                %>
                                <button type="submit" name="accion" class="btn btn-outline-success" id="btnGuardar" value="Guardar">Guardar</button><!-- comment -->
                                <%
                                } else {
                                %>
                                <p>Debe iniciar sesión para guardar un bolsillo</p>
                                <%
                                    }
                                %>  
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </center>
            </form>                
            <!--------------------------FIN BOLSILLO--------------------------------------->
            
        

        <script>
            // Initialize tooltips
            var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
            var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
                return new bootstrap.Tooltip(tooltipTriggerEl);
            });
        </script>
    </body>
    
</html>
