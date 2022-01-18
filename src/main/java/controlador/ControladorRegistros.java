package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO.DAOUsuario;
import modelo.POJO.Registro;

@WebServlet(name = "ControladorRegistros", urlPatterns = {"/ControladorRegistros"})
public class ControladorRegistros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Registro registro = new Registro();

        registro.setNombre((String) request.getParameter("Name"));
        registro.setCorreo((String) request.getParameter("exampleInputEmail1"));
        registro.setContraseña((String) request.getParameter("exampleInputPassword1"));
        registro.setConfirmarContraseña((String) request.getParameter("confirmPass"));
        
        String presupuesto = request.getParameter("budget");
        
        registro.setPresupuesto((Long.parseLong(presupuesto)));
        
        
        try {
            if (registro.getContraseña().equals(registro.getConfirmarContraseña())) {
             
                DAOUsuario usuario = new DAOUsuario();
             
            try {
                usuario.guardarUsuario(registro);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistros.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
        } catch (Exception e) {
            e.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
