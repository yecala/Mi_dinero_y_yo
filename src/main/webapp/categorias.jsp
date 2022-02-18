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
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 10% de tu presupuesto a un bolsillo, puede ser un viaje, una casa, un coche 
                          y practicamente sin enterarte estaras contruyendo tu fondo de emergencia"> Salud </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=3&nomCate=Alimentacion" id="Alimentacion">
                    <img src="Img_Catego/Alimentacion.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, alimentacion, transporte etc."> Alimentación </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=4&nomCate=Viajes" id="Viajes">
                    <img src="Img_Catego/Viajes.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="debes destinar un 10% de tus ingresos para actividades de ocio o viajes,
                          así no tendras que privarte de alguna salida con amigos o un viaje con tu familia"> Viajes </span>
                    
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
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="recuerda destinar un 10% de tus ingresos para tu cuidado y uso personal
                          es sano consentirse te lo mereces"> Cuidado </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=7&nomCate=Antojos" id="Antojos">
                    <img src="Img_Catego/Antojos.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Debes destinar un 10% de tus ingresos para el ocio
                          con este dinero podras ir al cine, comer un helado, salir de fiesta etc."> Antojos </span>
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=8&nomCate=Hobbies" id="Hobbies">
                    <img src="Img_Catego/Hobbies.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar un 10% de tus ingresos para tus hoobies
                          con este dinero puedes disfrutar de lo que te gusta sin gastar de mas etc."> Hobbies </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=9&nomCate=Mascotas" id="Mascotas">
                    <img src="Img_Catego/Mascotas.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda que es importante tener fondos adicionales para una emergencia 
                          que pueda ocurrir con tu mascota."> Mascotas </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=10&nomCate=Prestamos" id="Viajes">
                    <img src="Img_Catego/Prestamos.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Guarda cada mes un 10 por ciento de tus ingresos 
                          y cuando tengas una determinada cantidad,evalúa las diferentes opciones
                          y escoge la que mejor se adecúe a tus necesidades"> Prestamos </span>
                    
                </a>
            </td>
            <td></td>

        </tr>

        <tr>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=11&nomCate=Inversiones" id="Inversiones">
                    <img src="Img_Catego/Inversiones.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title=" Es importante y se recomienda  poder sacar partido de tu dinero
                          y que te vaya generando ingresos"> Inversiones </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=12&nomCate=Regalos" id="Regalos">
                    <img src="Img_Catego/Regalos y donativos.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, comida, transporte etc."> Regalos y donativos </span>
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=13&nomCate=Educacion" id="Educacion">
                    <img src="Img_Catego/Educacion.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, comida, transporte etc."> Educación </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=14&nomCate=Imprevistos" id="Imprevistos">
                    <img src="Img_Catego/Imprevistos.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, comida, transporte etc."> Imprevistos </span>
                    
                </a>
            </td>
            <td></td>
            <td class="col-1">
                <a href="ControladorCategorias?idCategoria=15&nomCate=Ahorros" id="Ahorros">
                    <img src="Img_Catego/Ahorros.png" alt=""/><br>
                    <span class="text-center" data-bs-toggle="tooltip" 
                          title="Recuerda destinar el 55% de tu presupuesto para gastos 
                          indispensables del hogar como facturas, comida, transporte etc."> Ahorros </span>
                    
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
