/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ControladorPerfil extends HttpServlet {
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
            out.println("<title>Servlet ControladorPerfil</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPerfil at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        int id_usuario = (int) session.getAttribute("idUsuario");
        
        String accion = request.getParameter("accion");
       String id = String.valueOf(id_usuario);
        switch(accion){
            case "Listar":
                
                Usuario u = dao.ListarId(id);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
                break;
            case "Editar":
                
                Usuario usu = dao.ListarId(id);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("editarPerfil.jsp").forward(request, response);
                break;

            case "Actualizar":
                
                String nom = request.getParameter("txtnom");
                String pass = request.getParameter("txtpass");
                String presupuesto1 = request.getParameter("txtpresupuesto");
               
                us.setId_usuario(id_usuario);
                us.setNombre_usuario(nom);
                us.setPassword(pass);
                us.setPresupuesto_total(Long.parseLong(presupuesto1));
               
                int r=dao.actualizarPerfil(us);
                
                if(r==1){
                    session.setAttribute("nombreUsuario", us.getNombre_usuario());
                    request.getRequestDispatcher("ControladorPerfil?accion=Listar").forward(request, response);
                }else{
                    request.setAttribute("error", "Ocurrio un error al actualizar, intenta de nuevo");
                    request.getRequestDispatcher("editarPerfil.jsp").forward(request, response);
                }
                
                break;
        
        }
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
        /*HttpSession session = request.getSession();

        String id_usuario = (String) session.getAttribute("idUsuario");
        
        String accion = request.getParameter("accion");
        switch(accion){
            case "Listar":
                
                Usuario u = dao.ListarId(id_usuario);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("navegacion.jsp").forward(request, response);
                break;
            case "Editar":
                
                Usuario usu = dao.ListarId(id_usuario);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
                break;

            case "Actualizar":
                
                String nom = request.getParameter("txtnom");
                String pass = request.getParameter("txtpass");
                String presupuesto1 = request.getParameter("txtpresupuesto");
               
                us.setId_usuario(Integer.parseInt(id_usuario));
                us.setNombre_usuario(nom);
                us.setPassword(pass);
                us.setPresupuesto_total(Long.parseLong(presupuesto1));
               
                dao.actualizarPerfil(us);
                request.getRequestDispatcher("ControladorUsuarios?accion=Listar").forward(request, response);
                break;
        
        }*/
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
