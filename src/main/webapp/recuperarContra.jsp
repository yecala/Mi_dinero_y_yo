<%-- 
    Document   : recuperarContra
    Created on : 18 feb. 2022, 14:48:13
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar contraseña</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="navegacion.jsp" %>
    <center>
        <h1>Recuperar contraseña</h1>
        <form action="ControladorPerfil" method="POST">
            
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="text" name="txtcorreo" class=" form-control" value="${usuario.getCorreo()}" id="floatingInput" >
                <label for="floatingInput">Correo</label>
            </div>
              
            
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="text" name="txtpass" class="form-control" id="floatingInput" value="${usuario.getPassword()}" disabled="" >
                <label for="floatingInput" >Contraseña</label>
            </div>
            

            <input type="submit" name="accion" value="Recuperar" class="btn btn-outline-success fs-5" id="botonEnviar">

        </form>
    </center>
</body>
</html>
