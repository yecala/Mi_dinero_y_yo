<%-- 
    Document   : perfil
    Created on : 17 feb. 2022, 16:08:00
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi perfil</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="navegacion.jsp" %>
    <center>
        <h1>Mi perfil</h1>
        <form action="ControladorPerfil" method="get">
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="text" name="txtnom" class=" form-control" id="floatingInput" value="${usuario.getNombre_usuario()}"  disabled="" >
                <label for="floatingInput">Nombre usuario</label>
            </div>
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="text"  class=" form-control" id="floatingInput" value="${usuario.getCorreo()}"  disabled="" >
                <label for="floatingInput">Correo</label>
            </div>
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="password" name="txtpass" class="form-control" id="floatingInput" value="${usuario.getPassword()}" disabled="" >
                <label for="floatingInput" >Contraseña</label>
            </div>
            <div class="form-floating mb-3 col-3 fs-5">
                <input type="number"  name="txtpresupuesto" class="form-control" id="floatingInput" value="${usuario.getPresupuesto_total()}" disabled="" >
                <label for="floatingInput">Presupuesto</label>
            </div>

            <input type="submit" name="accion" value="Editar" class="btn btn-outline-success fs-5" id="botonEnviar">

        </form>
    </center>
                
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>            
                
        
    
</body>
</html>
