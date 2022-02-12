<%-- 
    Document   : ensayoCate
    Created on : 4 feb. 2022, 9:37:19
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Categorias</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="navegacion.jsp" %>
    <center>
        <div class=" col-s-12 col-12"><h1 class="titulo-categorias">Categorías</h1></div>
    </center>
    <br>

    <table class="text-dark">
        <tr>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=1&nomCate=Hogar" id="hogar">
                    <img src="Img_Catego/Hogar.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, comida, transporte etc."> Hogar </span>
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=2&nomCate=Salud" id="Salud">
                    <img src="Img_Catego/Salud.png" alt=""/><br>
                    Salud
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=3&nomCate=Alimentacion" id="Alimentacion">
                    <img src="Img_Catego/Alimentacion.png" alt=""/><br>
                    Alimentación
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=4&nomCate=Viajes" id="Viajes">
                    <img src="Img_Catego/Viajes.png" alt=""/><br>
                    Viajes
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=5&nomCate=Transporte" id="Transporte">
                    <img src="Img_Catego/Transporte.png" alt=""/><br>
                    Transporte
                </a>
            </td>
        </tr>

        <tr>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=6&nomCate=Cuidado" id="Cuidado">
                    <img src="Img_Catego/Cuidado personal.png" alt=""/><br>
                    Cuidado
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=7&nomCate=Antojos" id="Antojos">
                    <img src="Img_Catego/Antojos.png" alt=""/><br>
                    <span class="text-center"> Antojos </span>
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=8&nomCate=Hobbies" id="Hobbies">
                    <img src="Img_Catego/Hobbies.png" alt=""/><br>
                    Hobbies
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=9&nomCate=Mascotas" id="Mascotas">
                    <img src="Img_Catego/Mascotas.png" alt=""/><br>
                    Mascotas
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=10&nomCate=Prestamos" id="Viajes">
                    <img src="Img_Catego/Prestamos.png" alt=""/><br>
                    Prestamos
                </a>
            </td>
            <td></td>

        </tr>

        <tr>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=11&nomCate=Inversiones" id="Inversiones">
                    <img src="Img_Catego/Inversiones.png" alt=""/><br>
                    Inversiones
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=12&nomCate=Regalos" id="Regalos">
                    <img src="Img_Catego/Regalos y donativos.png" alt=""/><br>
                    <span class="text-center"> Regalos y donativos </span>
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=13&nomCate=Educacion" id="Educacion">
                    <img src="Img_Catego/Educacion.png" alt=""/><br>
                    Educación
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=14&nomCate=Imprevistos" id="Imprevistos">
                    <img src="Img_Catego/Imprevistos.png" alt=""/><br>
                    Imprevistos
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=15&nomCate=Ahorros" id="Ahorros">
                    <img src="Img_Catego/Ahorros.png" alt=""/><br>
                    Ahorros
                </a>
            </td>
            <td></td>
        </tr>


    </table>
    <script>
        // Initialize tooltips
        var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
        var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
            return new bootstrap.Tooltip(tooltipTriggerEl);
        });
    </script>
</body>
</html>
