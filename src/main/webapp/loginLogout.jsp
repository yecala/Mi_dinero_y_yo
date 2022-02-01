<h1>
    <span>Mi dinerito</span>

    <span id="loginLogoutRegistrese">
        <%
            // Recupera el tipo de usuario de las variables de session
            String tipoUsuario = (String) session.getAttribute("tipoUsuario");

            if (tipoUsuario == null) {
                // El usuario que est� navegando es an�nimo
                out.print("<a  href='login.jsp'>Login</a>");
                // Se invoca el m�todo get del ControladorLogin con el par�metro registrese
                out.print("      <a  href='ControladorLogin?registreseOcrear=registrese'>Reg�strese</a>");

            } else {
                // El usuario que est� navegando est� registrado o es administrador
                String nombreUsuario = (String) session.getAttribute("nombreUsuario");
                out.print("Hola " + nombreUsuario + "      <a  href='ControladorLogin?registreseOcrear=logout'>Logout</a>");
            }
        %>    
    </span>  
</h1>
