package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.RegistroDAO;
import modelo.DAO.UsuarioDAO;
import modelo.POJO.Registro;
import modelo.POJO.Usuario;

@WebServlet(name = "ControladorRegistros", urlPatterns = {"/ControladorRegistros"})
public class ControladorRegistros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        session.setAttribute("usuarioExistente", "usuarioInexistente");
        
        Registro registro = new Registro();

        registro.setNombre((String) request.getParameter("Name"));
        registro.setCorreo((String) request.getParameter("exampleInputEmail1"));
        registro.setContraseña((String) request.getParameter("exampleInputPassword1"));
        registro.setConfirmarContraseña((String) request.getParameter("confirmPass"));
        String presupuesto = request.getParameter("budget");

        registro.setPresupuesto((Long.parseLong(presupuesto)));
        UsuarioDAO usuario = new UsuarioDAO();

        RegistroDAO registroU = new RegistroDAO();

        Usuario usuario2;
        usuario2 = new Usuario();

        usuario2 = usuario.obtenerUsuarioPorEmail(registro.getCorreo());

        try {
            if (registro.getContraseña().equals(registro.getConfirmarContraseña()) && usuario2.getId_usuario() == 0) {

                try {
                    registroU.guardarUsuario(registro);
                    response.sendRedirect("login.jsp");
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorRegistros.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
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
