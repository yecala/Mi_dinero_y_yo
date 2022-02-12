<%-- 
    Document   : login
    Created on : 28 ene. 2022, 16:19:57
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi dinero y yo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="EstilosMenu.css" rel="stylesheet" type="text/css"/>
        <link href="EstilosInicio.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        <header class="col-12 col-s-12">
           
        </header><!-- comment -->
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
                            <a class="nav-link fw-bold fs-4" href="categorias.html">Categorías</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link fw-bold fs-4" href="#">Reportes</a>
                        </li>
                    </ul>



                    
                </div>
            </div>
        </nav>
        <div  id="login" >
            <div class="col-12 col-s-12">
                <h3>Iniciar sesión</h3>
            </div>
            <form id="login_form" action="ControladorLogin" method="POST">
                <div class="field_container">
                    <input name="email" id="email" type="email" placeholder="Correo Electronico" required>
                </div>

                <div class="field_container">
                    <input  name="pass" id ="pass" type="Password" placeholder="Password" required>
                    
                </div>
                <div>
                    <button type="submit" value="Enviar" name="enviar" id="sign_in_button">
                        <span class="button_text">Ingresar</span>
                    </button>
                </div>
                <div>
                    <a class="recupe" href="recuperar contra.html" >
                        <small>Recuperar contraseña</small>
                        
                    </a>
                </div>

                <%//                        
                        // Si el nombre de usuario o password es invalido muestra el siguiente mensaje
                        String usuarioInvalido = (String) request.getAttribute("usuarioInvalido");
                        if (usuarioInvalido != null) {
                            out.print("<br/>");
                            out.print("<center>");
                            out.print("<span style='color:red'>Email o password incorrectos</span>");
                            out.print("</center>");
                        }
                    %>
            </form>
        </div>

        
    </body>
</html>
