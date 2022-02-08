<%-- 
    Document   : error
    Created on : 29 ene. 2022, 15:24:17
    Author     : Usuario
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi dinero y yo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
        <style>
            table{
                margin: auto;
            }
            td {
                padding:5px;
            }
        </style>
    </head>
    <body>
        <header class="col-12 col-s-12">
            <%@include  file="loginLogout.jsp" %>
        </header>
        <div class="row">
            
            <main class="col-6 col-s-10">       
                <h1 style="text-align: center">Uppps ocurrió una excepción en la aplicación</h1>
                <h1 style="text-align: center">Estamos trabajando en la solución</h1>
                <%                    // Obtiene el mensaje de error y lo escribe en la pagina error.jsp
                    String mensage = (String) request.getAttribute("mensage");
                    if (mensage != null) {
                        out.print("El mensaje de error es: ");
                        out.print(mensage + "<br/>");
                    }

                    // Obtiene la traza de la pila y la escribe en la pagina
                    String trazaPila = (String) request.getAttribute("trazaPila");
                    if (trazaPila != null) {
                        out.print("La traza de la pila es: " + "<br/>");
                        out.print(trazaPila);
                    }
                %>

            </main>
            <aside class="col-3 col-s-12">
                <p><b>¿Qué?</b></p>
                <p>Hotel Playa Blanca queda ubicado en la playa Taganga </p>
                <p><b>¿Dónde?</b></p>
                <p>Taganga es una playa del oceano Atlantico ubicada a 40 minutos de Santa Marta, Colombia</p>
                <p><b>¿Cómo?</b></p>
                <p>Puedes viajar en avión hasta Santa Marta y luego tomas un carro</p>
            </aside>
        </div>
        <footer>
            <p>Todos los derechos reservados &copy; 2020</p>
        </footer>
    </body>
</html>
