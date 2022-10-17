<%-- 
    Document   : ensayoCate
    Created on : 4 feb. 2022, 9:37:19
    Author     : Usuario
--%>
<%@page import="java.util.List"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="EstilosCategorias.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Categorias</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
        <style>
            .b_color{
                background-color: rgb(12, 213, 172);
                color:black;
            }
           
        </style>
    </head>
    <body>
        <%@include file="navegacion.jsp" %>
    <center>
        <div class=" col-s-12 col-12 mt-3"><h1 class="titulo-categorias">Categorías</h1></div>
    </center>
    <br>
    
    <div class="row mx-5">
        <c:forEach var="dato" items="${datos}">
            <div class="col-sm-1 ms-5 mb-5 px-1 text-center">
              <div class="card ">
                <div class="card-body ">
                    <!--<input type="hidden" id="catId" name="catId" value="${dato.getId_categoria()}">-->
                    <img src="Img_Catego/folder.png" class="card-img-top" alt=""/>
                    <a href="ControladorCate?accion=bolsillo&idCategoria=${dato.getId_categoria()}&nomCate=${dato.getNombre_categoria()}" id="${dato.getNombre_categoria()}" class="btn btn-outline-dark text-center mt-2 btn-sm" style=" background-color: rgb(12, 213, 172); color:black;">
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="${dato.getConsejo()}">
                        ${dato.getNombre_categoria()}
                    </span>
                    </a>
                </div>
              </div>
            </div>
        </c:forEach>
    </div>
 
    <br><!-- comment -->
    <center>
        <span style=" font-size: 10px">
        Imagenes tomadas de: www.flaticon.es 
        Para más información ver referencias del documento
         <a href="https://www.flaticon.com/free-icons/files-and-folders" title="files and folders icons">Files and folders icons created by itim2101 - Flaticon</a>
                    
        </span>
    </center>
    <script>
        // Initialize tooltips
        var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
        var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
            return new bootstrap.Tooltip(tooltipTriggerEl);
        });
    </script>
</body>
</html>
