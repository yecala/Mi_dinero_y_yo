/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO.UsuarioDAO;
import modelo.POJO.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorUsuarios extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario us = new Usuario();

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
            out.println("<title>Servlet ControladorUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuarios at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":

                List<Usuario> datos = dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("adminUsuarios.jsp").forward(request, response);
                break;

            case "Editar":
                String ide = request.getParameter("id");
                Usuario u = dao.ListarId(ide);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;

            case "Actualizar":
                String id1 = request.getParameter("txtid");
                String nom1 = request.getParameter("txtnom");
                String correo1 = request.getParameter("txtcorreo");
                String password1 = request.getParameter("txtcontrasena");
                String presupuesto1 = request.getParameter("txtpresupuesto");
                String estado1 = request.getParameter("txtestado");

                int idint = Integer.parseInt(id1);
                long presupuestlolong = Long.parseLong(presupuesto1);
                int estado2 = Integer.parseInt(estado1);

                us.setId_usuario(idint);
                us.setNombre_completo(nom1);
                us.setCorreo(correo1);
                us.setPassword(password1);
                us.setPresupuesto_total(presupuestlolong);
                us.setEstado(estado2);
                dao.actualizar(us);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
            case "Delete":
                String id2 = request.getParameter("id");
                int id3 = Integer.parseInt(id2);
                us.setId_usuario(id3);
                dao.delete(us);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;

            case "Nuevo":
                request.getRequestDispatcher("agregar.jsp").forward(request, response);
                break;
                
                
            case "submit":
                
                String id = request.getParameter("txtid");
                String nombres = request.getParameter("txtnombres");
                String correo = request.getParameter("txtcorreo");
                String password = request.getParameter("txtpassword");
                String presupuesto = request.getParameter("txtpresupuesto");
                String estado = request.getParameter("txtestado");
                
                int id4 = Integer.parseInt(id);
                long presupuesto3 = Long.parseLong(presupuesto);
                int estado3 = Integer.parseInt(estado);
                
                us.setId_usuario(id4);
                us.setNombre_completo(nombres);
                us.setCorreo(correo);
                us.setPassword(password);
                us.setPresupuesto_total(presupuesto3);
                us.setEstado(estado3);
                
                dao.agregar(us);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                
                break;
            default:
                throw new AssertionError();
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
