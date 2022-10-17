/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.DAO.CategoriaDAO;
import modelo.POJO.Categoria;
import modelo.POJO.Usuario;

/**
 *
 * @author Usuario
 */
public class ControladorCate extends HttpServlet {
    CategoriaDAO dao = new CategoriaDAO();
    Categoria cate = new Categoria();
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
            out.println("<title>Servlet ControladorCategorias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCategorias at " + request.getContextPath() + "</h1>");
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
            
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listarTodo":
                List<Categoria> datoscat=null;
                try{
                 datoscat=dao.listar();
                }catch(Exception ex){
                    ex.getStackTrace();
                    System.out.println("Fallo al intentar conectar con base de datos");
                }
               
                request.setAttribute("datos", datoscat);
                request.getRequestDispatcher("categorias.jsp").forward(request, response);
                break;
            case "bolsillo" :
                verBolsillo(request, response);
                break;
                
        default:
                throw new AssertionError();
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

    public void verBolsillo(HttpServletRequest request, HttpServletResponse response){
        int id_categorias = Integer.parseInt(request.getParameter("idCategoria"));
        String nom_cate = request.getParameter("nomCate");
        HttpSession session = request.getSession();
        session.setAttribute("categoria_actual", id_categorias);
        session.setAttribute("nom_categoria", nom_cate);

        //valida si es ususario anonimo o registrado
        if (session.getAttribute("idUsuario") == null) {
           
            try {
               response.sendRedirect("tablaBolsillos.jsp");
            } catch (IOException ex) {
                Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //si es usuario registrado envia info para ver bolsillos
            int id_usuario = (int) session.getAttribute("idUsuario");
            int id_categoria = (int) session.getAttribute("categoria_actual");

            Categoria cat = new Categoria();
            cat = dao.sumarPresupuestoGasto(id_usuario, id_categoria);

            Usuario usu = new Usuario();
            usu = dao.presupuestoDisponible(id_usuario);
            
            //realiza calculo de presupuesto disponible de la categoria
            long presupuesto_disponible = usu.getPresupuesto_total() - usu.getPresupuesto_disponible();
            usu.setPresupuesto_disponible(presupuesto_disponible);

            request.setAttribute("Usuario", usu);
            request.setAttribute("Categoria", cat);
            
            try {
                request.getRequestDispatcher("tablaBolsillos.jsp").forward(request, response);
        
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    
    }
}
