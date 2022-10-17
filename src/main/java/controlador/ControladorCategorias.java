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
//import org.json.JSONArray;

/**
 *
 * @author Usuario
 */
public class ControladorCategorias extends HttpServlet {

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
           
            case "Listar":
                listar(request,response);
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
        String accion = request.getParameter("accion");
        switch (accion) {
           
            case "Listar":
                listar(request,response);
                break;

            case "Editar":
                editar(request,response);
                break;

            case "Actualizar":
                actualizar(request,response);
                break;
                
            case "Eliminar":
                eliminar(request,response);
                break;

            case "Nuevo":
                try {
                    request.getRequestDispatcher("agregarCategorias.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                      Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "Enviar":
                enviar(request,response);
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

    /**
     * Lista las categorias en el administrador
     * @param request
     * @param response 
     */
    public void listar(HttpServletRequest request, HttpServletResponse response){
        List<Categoria> datos = dao.listar();
        request.setAttribute("datos", datos);
        try {
            request.getRequestDispatcher("adminCategorias.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtiene los datos de la categoria seleccionada para enviarlos al formulario de editar
     * @param request
     * @param response 
     */
    public void editar(HttpServletRequest request, HttpServletResponse response){
        String ide = request.getParameter("id");
        Categoria cat = dao.ListarId(ide);
        request.setAttribute("Categoria", cat); 
        try {
           request.getRequestDispatcher("editCategoria.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Envia datos nuevos al metodo que actualiza en base de datos las categorias
     * @param request
     * @param response 
     */
    public void actualizar(HttpServletRequest request, HttpServletResponse response){
        String id1 = request.getParameter("txtid");
        String nom1 = request.getParameter("txtnom");
        String consejo = request.getParameter("txtconsejo");
        int idint = Integer.parseInt(id1);

        cate.setId_categoria(idint);
        cate.setNombre_categoria(nom1);
        cate.setConsejo(consejo);
        dao.actualizar(cate);
                
        try {
           request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Envia el Id de la categoria que se desea eliminar al metodo que elimina en base de datos
     * @param request
     * @param response 
     */
    public void eliminar(HttpServletRequest request, HttpServletResponse response){
        response.setContentType( "text/html; charset=iso-8859-1" );
        String id2 = request.getParameter("id");

        int num_bolsillos = dao.num_bolsillos(id2);
        if (num_bolsillos > 0) {
            request.setAttribute("loginError", true);
        } else {
            dao.delete(id2);
            request.setAttribute("success", true);
        }
                   
        try {
           request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);   
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Envia los datos nuevos al metodo que agrega categorias en base de datos
     * @param request
     * @param response 
     */
    public void enviar(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("txtid");
        String nombres = request.getParameter("txtnombres");
        String consejo1 = request.getParameter("txtconsejo");
        int id3 = Integer.parseInt(id);

        cate.setId_categoria(id3);
        cate.setNombre_categoria(nombres);
        cate.setConsejo(consejo1);
        dao.agregar(cate);
                
        try {
           request.getRequestDispatcher("ControladorCategorias?accion=Listar").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ControladorCategorias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
