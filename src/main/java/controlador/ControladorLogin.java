/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.RegistroDAO;
import modelo.DAO.UsuarioDAO;
import modelo.POJO.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera el valor del parámetro registreseOcrear del objeto request
        String registreseOcrear = (String) request.getParameter("registreseOcrear");

        if (registreseOcrear.equals("logout")) {
            // Cierra la sesión del usuario
            HttpSession session = request.getSession(); // Recupera la sesión actual
            session.invalidate(); // Destruye la sesión actual

            // Invoca la página index.jsp
            response.sendRedirect("index.jsp");
        }

        /*
        if (registreseOcrear.equals("registrese")) {
            
            ServiciosUsuario.mostrarPaginaCreacionUsuario(request, response, "registrese");
        }*/
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Captura el valor de los campos email y pass de la página login.jsp
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        try {
            // Busca si existe un usuario en la tabla Usuario con el email entrado 
            // en la página login.jsp
            //DAOUsuario daoUsuario = new RegistroDAO();
            UsuarioDAO daoUsuario = new UsuarioDAO();

            Usuario usuario = daoUsuario.obtenerUsuarioPorEmail(email);

            if ((usuario != null) && usuario.getPassword().equals(pass) && usuario.getEstado()==1) {
                // El usuario ya está registrado
                // Crea la sesión para el usuario
                HttpSession session = request.getSession();

                // Almacena en las variables de sesión el nombre y el tipo de usuario
                session.setAttribute("nombreUsuario", usuario.getNombre_usuario());
                session.setAttribute("tipoUsuario", usuario.getBit_admin() == 1 ? "administrador" : "usuario");
                session.setAttribute("idUsuario", usuario.getId_usuario());
                
                
                if (session.getAttribute("tipoUsuario").equals("administrador")) {

                    response.sendRedirect("administrador.html");

                } else {
                    // invoca la página index.jsp
                    response.sendRedirect("index.jsp");

                }

            } else {
                // Trató de loguearse un usuario que no está regisrado
                request.setAttribute("usuarioInvalido", "usuarioInvalido");

                // Se invoca la página login.jsp
                RequestDispatcher vista = request.getRequestDispatcher("/login.jsp");
                vista.forward(request, response);
            }
        } catch (Exception ex) {
            // obtiene el mensaje de error del objecto excepcion ex
            String mensage = ex.getMessage();

            // La traza de la pila se lleva a la variable string trazaPila
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String trazaPila = errors.toString();

            // Se almacena el mensaje de error y la traza de la pila en variables del objeto request
            request.setAttribute("mensage", mensage);
            request.setAttribute("trazaPila", trazaPila);

            // Se invoca la página de error
            RequestDispatcher vista = request.getRequestDispatcher("/error.jsp");
            vista.forward(request, response);
            //processRequest(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
