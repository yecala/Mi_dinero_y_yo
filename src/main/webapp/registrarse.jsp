<%-- 
    Document   : registrarse
    Created on : 9 feb. 2022, 12:20:36
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="EstilosBolsillos.css" rel="stylesheet" type="text/css"/>
        <title>Registrarse</title>
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <script src="scripts.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light barra_color p-3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"> 
                    <span class="T_color fs-2 fw-bold ">Mi dinero y yo </span>
                    <img class="img-fluid col-3" src="Img_menu/mano.png" alt=""/>
                </a>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active fw-bold fs-4" aria-current="page" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="categorias.jsp">Categorias</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="#">Reportes</a>
                        </li>
                    </ul>


                </div>
            </div>
        </nav>
        <div class="container col-3">
            <div class="text-center">
                <h1>Registrarse</h1>
            </div>
            <form action="ControladorRegistros" method="POST">
                <div class="form-group">
                    <label for="Name">Nombre de usuario</label>
                    <input type="text" class="form-control" id="Name" name="Name"  placeholder="Nombre de usuario">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Correo</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Correo">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Contraseña</label>
                    <input type="password" class="form-control " id="exampleInputPassword1" name="exampleInputPassword1" placeholder="Contraseña">
                </div>
                <div class="form-group">
                    <label for="confirmPass">Contraseña</label>
                    <input type="password" class="form-control" id="confirmPass" name="confirmPass" placeholder="Confirme Contraseña">
                </div>
                <div class="form-group">
                    <label for="budget">Presupuesto total</label>
                    <input type="number" class="form-control" id="budget" name="budget" placeholder="Presupuesto total">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
                </form>
                <%//                        
                    // Si el nombre de usuario o password es invalido muestra el siguiente mensaje
                    String usuarioExistente="usuarioInexistente";
                    usuarioExistente = (String)  session.getAttribute("usuarioExistente");
                    
                    if (usuarioExistente.equals("usuarioExistente")) {
                        out.print("<br/>");
                        out.print("<center>");
                        out.print("<span style='color:red'>El email ya esta registrado</span>");
                        out.print("</center>");
                    }
                %>
            
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

