<%@page import="modelo.POJO.Bolsillo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <%@include file="navegacion.jsp"%>

        <!-------------------------- barra de PRESUPUESTO--------------------------------------->
    <center>
        <div class="p-1 mt-2 barraPresupuesto h-50" >
            <table >
                <tr class=" table-active">

                    <td class="col-6 " >
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



        <center>
            <div>
                <h3></h3>
            </div>
            <hr><!-- comment --> 
            <div>
                <form action="ControladorBolsillos" method="POST">
                    <center>
                        <div class="p-1 mb-1  h-50" >
                            <table id="tablaBolsillo" class="table-bordered bg-secondary  bg-opacity-10">
                                <tr class=" table-active">

                                    <td class="col-6" >
                                        <div class="p-4 col-xs-4">
                                            <label for="ex3">Nombre bolsillo</label>
                                            <input value="${Bolsillo.getNombre_bolsillo()}" name="txtnombre" class="form-control" id="ex3" type="text" required="">
                                        </div>

                                    </td>
                                    <td>
                                        <div class=" p-4 col-xs-3">
                                            <label for="ex2">Presupuesto</label>
                                            <input value="${Bolsillo.getPresupuesto_bolsillo()}" name="txtpresupuesto" class="form-control" id="ex2" type="number" required="">
                                        </div>
                                    </td>
                                    <td>
                                        <div class="p-4 col-xs-3">
                                            <label for="ex2">Gasto real</label>
                                            <input value="${Bolsillo.getGasto_bolsillo()}" name="txtgasto" class="form-control" id="ex2" type="number" required="">
                                            
                                        </div>
                                    </td>

                                </tr>

                            </table>
                        </div>
                    </center>
                    <input type="hidden" name="id" value="${Bolsillo.getId_bolsillo()}">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-outline-warning" id="botonEnviar" >
                </form>
            </div>
        </center>
</html>
