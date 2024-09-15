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
    int id_usuario;
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

        id_usuario = (int) session.getAttribute("idUsuario");
        
        String accion = request.getParameter("accion");
       String id = String.valueOf(id_usuario);
        switch(accion){
            case "Listar":
                
                listar(request,response,null);
                break;
            case "Editar":
                
                Usuario usu = dao.ListarId(id);
                request.setAttribute("usuario", usu);
                request.getRequestDispatcher("editarPerfil.jsp").forward(request, response);
                break;

            case "Actualizar":
                boolean success=false;
                String nom = request.getParameter("txtnom");
                String pass = request.getParameter("txtpass");
                String presupuesto1 = request.getParameter("txtpresupuesto");
                nom=nom.trim();
                pass=pass.trim();
                
                if(!nom.equals("") && !pass.equals("")){
                   
                    us.setId_usuario(id_usuario);
                    us.setNombre_usuario(nom);
                    us.setPassword(pass);
                    us.setPresupuesto_total(Long.parseLong(presupuesto1));

                    boolean contraSegura = false;
                    contraSegura = esSegura(pass);

                    int r=0;
                    if(contraSegura){
                       r=dao.actualizarPerfil(us);
                    }
                    if(r==1){
                        session.setAttribute("nombreUsuario", us.getNombre_usuario());
                        success=true;
                    }else{
                        request.setAttribute("error", "Ocurrio un error al actualizar, intenta de nuevo");
                        success=false;
                    }
                }else{
                    success=false;
                }
                
                listar(request,response,String.valueOf(success));
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
        HttpSession session = request.getSession();
    /*
        String id_usuario = (String) session.getAttribute("idUsuario");
        */
        String accion = request.getParameter("accion");
        switch(accion){
            case "Recuperar":
                String correo = request.getParameter("txtcorreo");
                
                Usuario usuario=dao.obtenerUsuarioPorEmail(correo);
                
                String contra= usuario.getPassword();
                
               
                request.setAttribute("usuario", usuario);
                
                request.getRequestDispatcher("recuperarContra.jsp").forward(request, response);
                break;
        
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

    public static boolean esSegura(String password) {
        if (password.length() > 8) {
            boolean mayuscula = false;
            boolean numero = false;
            char c;
            for (int i = 0; i < password.length(); i++) {
                c = password.charAt(i);
                if (Character.isDigit(c)) {
                    numero = true;
                }
                if (Character.isUpperCase(c)) {
                    mayuscula = true;
                }

            }
            if (numero && mayuscula) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response, String editar){
        try {
            String id = String.valueOf(id_usuario);
            Usuario u = dao.ListarId(id);
            request.setAttribute("usuario", u);
            if(editar!=null){
                if(editar.equals("false")){
                    request.setAttribute("camposVacios", true);
                }else{
                    request.setAttribute("successEdit", true);
                }
            }else{
                 request.setAttribute("camposVacios", false);
                 request.setAttribute("successEdit", false);
            }
            request.getRequestDispatcher("perfil.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControladorPerfil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
